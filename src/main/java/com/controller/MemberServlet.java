package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MemberServlet extends FatherServlet {

//	public String add(HttpServletRequest request, HttpServletResponse response) {
//
//		return null;
//	}
//
//	public String delete(HttpServletRequest request, HttpServletResponse response) {
//		return null;
//	}
//
//	
//	public String edit(HttpServletRequest request, HttpServletResponse response) {
//		return null;		
//	}
//
//	
//	public String update(HttpServletRequest request, HttpServletResponse response) {
//		return null;
//	}

	@RequestMapping("/admin/member/list")
	public String list(Model m) {
//		List<MemberVO> member = memberService.list();
//		m.addAttribute("member", member);
		return "admin/listMember";
	}
}
