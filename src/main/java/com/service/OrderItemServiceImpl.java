package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.OrderDAO;
import com.order.OrderVO;
import com.orderitem.OrderItemDAO;
import com.orderitem.OrderItemVO;
@Service
public class OrderItemServiceImpl implements OrderItemService {
	@Autowired
	private OrderItemDAO orderItemDAOImpl;
	@Autowired
	private OrderDAO orderDAOImpl;
	@Autowired
	private ProductService productService;
	public void setOrderDAO(OrderDAO orderDAOImpl) {
		this.orderDAOImpl = orderDAOImpl;
	}

	public void setOrderItemDAOImpl(OrderItemDAO orderItemDAOImpl) {
		this.orderItemDAOImpl = orderItemDAOImpl;
	}

	@Override
	public int add(OrderItemVO bean) {
		int add = orderItemDAOImpl.add(bean);
		return add;
	}

	@Override
	public void update(OrderItemVO bean) {
		orderItemDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		orderItemDAOImpl.delete(id);
		
	}

	@Override
	public OrderItemVO get(int id) {
		OrderItemVO orderItemVO = orderItemDAOImpl.get(id);
		int oid = orderItemVO.getOrder().getOrderId();
		productService.setFirstProductImage(orderItemVO.getProduct());
		if(oid>0) {
			OrderVO order= orderDAOImpl.get(oid);
			orderItemVO.setOrder(order);
		}
		return orderItemVO;
	}

	@Override
	public List<OrderItemVO> listByUser(int uid) {
		List<OrderItemVO> listByUser = orderItemDAOImpl.listByUser(uid);
		for(OrderItemVO oi:listByUser)
			productService.setFirstProductImage(oi.getProduct());
		return listByUser;
	}

	@Override
	public List<OrderItemVO> listByOrder(int oid) {
		List<OrderItemVO> listByOrder = orderItemDAOImpl.listByOrder(oid);
		for(OrderItemVO oi:listByOrder)
		productService.setFirstProductImage(oi.getProduct());
		return listByOrder;
	}
	
	@Override
	public List<OrderItemVO> listByProduct(int pid) {
		List<OrderItemVO> listByProduct = orderItemDAOImpl.listByProduct(pid);
		for(OrderItemVO oi:listByProduct) {
			productService.setFirstProductImage(oi.getProduct());
			int oid = oi.getOrder().getOrderId();
			if(oid>0) {
				OrderVO order = orderDAOImpl.get(oid);
				oi.setOrder(order);
			}
		}
		return listByProduct;
	}

	@Override
	public void fill(List<OrderVO> os) {
		//取出每筆訂單的訂單detail,把總價和總量算出來
        for (OrderVO o : os) {
            List<OrderItemVO> ois=listByOrder(o.getOrderId());
            float total = 0;
            int totalNumber = 0;
            for (OrderItemVO oi : ois) {
                 total+=oi.getCount()*oi.getProduct().getPromotePrice();
                 totalNumber+=oi.getCount();
            }
            o.setTotal(total);
            o.setOrderItems(ois);
            o.setTotalNumber(totalNumber);
        }
    }
	@Override
	public void fill(OrderVO o) {
		//取出該訂單的所有訂單明細,得到產品總價
        List<OrderItemVO> ois=listByOrder(o.getOrderId());
        float total = 0;
        for (OrderItemVO oi : ois) {
             total+=oi.getCount()*oi.getProduct().getPromotePrice();
        }
        o.setTotal(total);
        o.setOrderItems(ois);
    }
		

	@Override
	public Integer getSaleCount(int pid) {
		Integer saleCount = orderItemDAOImpl.getSaleCount(pid);
		return saleCount;
	}

}
