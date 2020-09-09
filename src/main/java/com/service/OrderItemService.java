package com.service;

import java.util.List;


import com.order.OrderVO;
import com.orderitem.OrderItemVO;

public interface OrderItemService {
	public int add(OrderItemVO bean);
	public void update(OrderItemVO bean);
	public void delete(int id);
	public OrderItemVO get(int id);
	public List<OrderItemVO> listByUser(int uid);
	public List<OrderItemVO> listByOrder(int oid);
	public void fill(List<OrderVO> os);
	public void fill(OrderVO o);
	public List<OrderItemVO> listByProduct(int pid);
	public Integer getSaleCount(int pid);
}
