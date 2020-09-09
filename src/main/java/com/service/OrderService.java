package com.service;

import java.util.List;


import com.order.OrderVO;

public interface OrderService {
	public int add(OrderVO bean);
	public void update(OrderVO bean);
	public void delete(int id);
	public OrderVO get(int id);
	public List<OrderVO> list();
	public List<OrderVO> list(int uid,String excludedStatus);
}
