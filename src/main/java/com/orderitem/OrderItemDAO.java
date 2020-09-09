package com.orderitem;

import java.util.List;

import org.apache.ibatis.annotations.Param;




public interface OrderItemDAO {

//	public int getTotal();
	public int add(OrderItemVO bean);
	public void update(OrderItemVO bean);
	public void delete(@Param("orderItemId") int id);
	public OrderItemVO get(@Param("orderItemId") int id);
	public List<OrderItemVO> listByUser(@Param("memberId") int uid);
	public List<OrderItemVO> listByOrder(@Param("orderId") int oid);
	public List<OrderItemVO> listByProduct(@Param("productId") int pid);
	public Integer getSaleCount(@Param("productId") int pid);
	
}
