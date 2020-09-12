package com.controller;

import java.util.Date;
import java.util.List;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.order.OrderVO;
import com.service.OrderServiceImpl;

@Controller
@MultipartConfig
@RequestMapping("/admin/order")
public class OrderServlet extends FatherServlet {

	@RequestMapping("/add")
	public String add(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}
	@RequestMapping("/delivery")
	public String delivery(int orderId) {
		//接收哪個會員的訂單
		OrderVO o = orderService.get(orderId);
		o.setDeliveryDate(new Date());
		//修改訂單狀態
		o.setStatus(OrderServiceImpl.waitConfirm);
		orderService.update(o);
		return "redirect:/redirect/listOrder.jsp";
	}

	
	public String edit(HttpServletRequest request, HttpServletResponse response) {
		return null;	
	}

	
	public String update(HttpServletRequest request, HttpServletResponse response) {
		return null;
	}

	@RequestMapping("/list")
	public String list(Model m) {
		List<OrderVO> os = orderService.list();
		orderItemService.fill(os);
		m.addAttribute("os", os);
		
		return "admin/listOrder";
	}
}
