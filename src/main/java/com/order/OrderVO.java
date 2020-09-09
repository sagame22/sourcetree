package com.order;

import java.util.Date;
import java.util.List;

import com.member.MemberVO;
import com.orderitem.OrderItemVO;
import com.service.OrderServiceImpl;


 
public class OrderVO implements java.io.Serializable{

	    private String orderCode;
	    private String address;
	    private String post;
	    private String receiver;
	    private String mobile;
	    private String userMessage;
	    private Date orderDate;
	    private Date payDate;
	    private Date deliveryDate;
	    private Date confirmDate;
	    private MemberVO member;
	 

		private int orderId;
	    private List<OrderItemVO> orderItems;
	    private float total;
	    private int totalNumber;
	    private String status;
	     
	    public String getStatusDesc(){
	        String desc ="未知";
	        switch(status){
	          case OrderServiceImpl.waitPay:
	              desc="待付款";
	              break;
	          case OrderServiceImpl.waitDelivery:
	              desc="待出貨";
	              break;
	          case OrderServiceImpl.waitConfirm:
	              desc="待收貨";
	              break;
	          case OrderServiceImpl.waitReview:
	              desc="待評價";
	              break;
	          case OrderServiceImpl.finish:
	              desc="完成";
	              break;
	          case OrderServiceImpl.delete:
	              desc="刪除";
	              break;
	          default:
	              desc="未知";
	        }
	        return desc;
	    }
	     
	    public int getOrderId() {
	        return orderId;
	    }
	 
	    public void setOrderId(int id) {
	        this.orderId = id;
	    }
	    public String getAddress() {
	        return address;
	    }
	    public void setAddress(String address) {
	        this.address = address;
	    }
	    public String getPost() {
	        return post;
	    }
	    public void setPost(String post) {
	        this.post = post;
	    }
	 
	    public String getMobile() {
	        return mobile;
	    }
	    public void setMobile(String mobile) {
	        this.mobile = mobile;
	    }
	    public String getUserMessage() {
	        return userMessage;
	    }
	    public void setUserMessage(String userMessage) {
	        this.userMessage = userMessage;
	    }
	    public Date getOrderDate() {
	        return orderDate;
	    }
	    public void setOrderDate(Date createDate) {
	        this.orderDate = createDate;
	    }
	    public Date getPayDate() {
	        return payDate;
	    }
	    public void setPayDate(Date payDate) {
	        this.payDate = payDate;
	    }
	    public Date getDeliveryDate() {
	        return deliveryDate;
	    }
	    public void setDeliveryDate(Date deliveryDate) {
	        this.deliveryDate = deliveryDate;
	    }
	    public Date getConfirmDate() {
	        return confirmDate;
	    }
	    public void setConfirmDate(Date confirmDate) {
	        this.confirmDate = confirmDate;
	    }
	 
	    public String getReceiver() {
	        return receiver;
	    }
	 
	    public void setReceiver(String receiver) {
	        this.receiver = receiver;
	    }
	 
	    public String getOrderCode() {
	        return orderCode;
	    }
	 
	    public void setOrderCode(String orderCode) {
	        this.orderCode = orderCode;
	    }
	 
	    public MemberVO getMember() {
	        return member;
	    }
	 
	    public void setMember(MemberVO user) {
	        this.member = user;
	    }
	 
	    public List<OrderItemVO> getOrderItems() {
	        return orderItems;
	    }
	 
	    public void setOrderItems(List<OrderItemVO> orderItems) {
	        this.orderItems = orderItems;
	    }
	 
	    public float getTotal() {
	        return total;
	    }
	 
	    public void setTotal(float total) {
	        this.total = total;
	    }
	 
	    public String getStatus() {
	        return status;
	    }
	 
	    public void setStatus(String status) {
	        this.status = status;
	    }
	 
	    public int getTotalNumber() {
	        return totalNumber;
	    }
	 
	    public void setTotalNumber(int totalNumber) {
	        this.totalNumber = totalNumber;
	    }
	    
	    @Override
	 		public String toString() {
	 			return "OrderVO [orderCode=" + orderCode + ", address=" + address + ", post=" + post + ", receiver="
	 					+ receiver + ", mobile=" + mobile + ", userMessage=" + userMessage + ", orderDate=" + orderDate
	 					+ ", payDate=" + payDate + ", deliveryDate=" + deliveryDate + ", confirmDate=" + confirmDate
	 					+ ", memberid=" + member.getMemberId()  +", orderId=" + orderId + ", orderItems=" + orderItems + ", total=" + total
	 					+ ", totalNumber=" + totalNumber + ", status=" + status + "]";
	 		}
	    
	    

	     
	}