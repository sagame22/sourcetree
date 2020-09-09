package com.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.category.CategoryVO;
import com.property.PropertyVO;

@Controller
@SessionAttributes(value= {"ps","c"})
@RequestMapping("/admin/property")
public class PropertyServlet extends FatherServlet{
	
	@RequestMapping("/add")
	public String add(PropertyVO p , int categoryId) {
		CategoryVO c = categoryService.get(categoryId);
		p.setCategory(c);
		propertyService.add(p);
		return "redirect:/redirect/listProperty.jsp?categoryId="+categoryId;
	}

	@RequestMapping("/delete")
	public String delete(int propertyId) {
		PropertyVO p = propertyService.get(propertyId);
		propertyService.delete(propertyId);
		return "redirect:/redirect/listProperty.jsp?categoryId="+p.getCategory().getCategoryId();
	}

	@RequestMapping("/edit")
	public String edit(int propertyId,Model m) {
		PropertyVO p = propertyService.get(propertyId);
		m.addAttribute("p", p);
		return "admin/editProperty";		
	}

	@RequestMapping("/update")
	public String update(PropertyVO p , int categoryId) {
		CategoryVO c = categoryService.get(categoryId);
		p.setCategory(c);
		propertyService.update(p);
		return "redirect:/redirect/listProperty.jsp?categoryId="+categoryId;
	}

	@RequestMapping("/list")
	public String list(Integer categoryId,Model m) {
		//把選定的分類VO和該分類底下的屬性存入
		if(categoryId!=null) {
		CategoryVO c = categoryService.get(categoryId);
		List<PropertyVO> ps = propertyService.list(categoryId);
		m.addAttribute("ps", ps);
		m.addAttribute("c", c);
		}
		return "admin/listProperty";
	}


	
}
