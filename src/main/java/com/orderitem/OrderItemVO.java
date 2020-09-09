package com.orderitem;

import com.member.MemberVO;
import com.order.OrderVO;
import com.product.ProductVO;

public class OrderItemVO implements java.io.Serializable {

	    private int count;
	    private ProductVO product;
	    private OrderVO order;
	    private MemberVO member;
	    private int orderItemId;
	    
	    public int getCount() {
	        return count;
	    }
	    public void setCount(int number) {
	        this.count = number;
	    }
	    public ProductVO getProduct() {
	        return product;
	    }
	    public void setProduct(ProductVO product) {
	        this.product = product;
	    }
	    public OrderVO getOrder() {
	        return order;
	    }
	    public void setOrder(OrderVO order) {
	        this.order = order;
	    }
	    public MemberVO getMember() {
	        return member;
	    }
	    public void setMember(MemberVO user) {
	        this.member = user;
	    }
	    public int getOrderItemId() {
	        return orderItemId;
	    }
	    public void setOrderItemId(int id) {
	        this.orderItemId = id;
	    }
		@Override
		public String toString() {
			return "OrderItemVO [orderitemid="+orderItemId+"count=" + count + ", product+categoryId=[" + product.getPname()+product.getCategory().getCategoryId() + "], orderid=" + order.getOrderId()+"ordercode"+order.getOrderCode() + ", MMname=****" + member.getMname()
					+", MMname=****"+member.getPassword()+ ", orderItemId=" + orderItemId + "]memid="+member.getMemberId();
		}
	 
	    
	}