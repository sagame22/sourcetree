package com.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

import com.member.MemberVO;

public class AuthInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		MemberVO member = (MemberVO) request.getSession().getAttribute("member");
		if (member == null) {
			response.sendRedirect("/YulinSSM/frontpage/login.jsp");
			return false;
		} else {
			return true;
		}
	}


}
