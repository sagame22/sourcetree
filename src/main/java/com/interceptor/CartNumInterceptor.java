package com.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.member.MemberVO;
import com.orderitem.OrderItemVO;
import com.service.OrderItemService;

public class CartNumInterceptor implements HandlerInterceptor {
	@Autowired
	private OrderItemService orderItemService;
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		MemberVO member;
		Integer cartnum = 0;
		if((member=(MemberVO) request.getSession().getAttribute("member"))!=null) {
		List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
		for (OrderItemVO oi : ois) {
			cartnum += oi.getCount();
		}
		request.getSession().setAttribute("cartTotalItemNumber", cartnum);
	}}
}
