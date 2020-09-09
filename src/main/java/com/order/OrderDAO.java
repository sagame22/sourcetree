package com.order;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OrderDAO {

//	public int getTotal();
	public int add(OrderVO bean);
	public void update(OrderVO bean);
	public void delete(@Param("orderId") int id);
	public OrderVO get(@Param("orderId") int id);
	public List<OrderVO> list();
	public List<OrderVO> list2(@Param("uid") int uid,@Param("status") String excludedStatus);
	
}
