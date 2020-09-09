package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.OrderDAO;
import com.order.OrderVO;
@Service
public class OrderServiceImpl implements OrderService{
	
	public static final String waitPay = "waitPay";
    public static final String waitDelivery = "waitDelivery";
    public static final String waitConfirm = "waitConfirm";
    public static final String waitReview = "waitReview";
    public static final String finish = "finish";
    public static final String delete = "delete";
    @Autowired
    private OrderDAO orderDAOImpl;
	public void setOrderDAOImpl(OrderDAO orderDAOImpl) {
		this.orderDAOImpl = orderDAOImpl;
	}
	@Override
	public int add(OrderVO bean) {
		int add = orderDAOImpl.add(bean);
		return add;
	}
	@Override
	public void update(OrderVO bean) {
		orderDAOImpl.update(bean);
		
	}
	@Override
	public void delete(int id) {
		orderDAOImpl.delete(id);
		
	}
	@Override
	public OrderVO get(int id) {
		OrderVO orderVO = orderDAOImpl.get(id);
		return orderVO;
	}
	@Override
	public List<OrderVO> list() {
		List<OrderVO> list = orderDAOImpl.list();
		return list;
	}
	@Override
	public List<OrderVO> list(int uid, String excludedStatus) {
		List<OrderVO> list2 = orderDAOImpl.list2(uid, excludedStatus);
		return list2;
	}

}
