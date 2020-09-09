package com.controller;


import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.category.CategoryVO;
import com.product.ProductVO;
import com.propertyvalue.PropertyValueVO;


@Controller
@MultipartConfig
@SessionAttributes(value= {"ps2","c"})
@RequestMapping("/admin/product")
public class ProductServlet extends FatherServlet{
	
	@RequestMapping("/add")
	public String add(ProductVO p,int categoryId) {
		CategoryVO c = categoryService.get(categoryId);
		p.setCategory(c);
		productService.add(p);
		return "redirect:/redirect/listProduct.jsp?categoryId="+categoryId;
	}

	@RequestMapping("/delete")
	public String delete(int productId) {
		ProductVO p = productService.get(productId);
		productService.delete(productId);
		return "redirect:/redirect/listProduct.jsp?categoryId="+p.getCategory().getCategoryId();
	}

	@RequestMapping("/edit")
	public String edit(int productId,Model m) {
		ProductVO p = productService.get(productId);
		System.out.println(p);
		m.addAttribute("p", p);
		return "admin/editProduct";		
	}
	@RequestMapping("/editPropertyValue")
	public String editPropertyValue(int productId,Model m) {
		ProductVO p = productService.get(productId);
		m.addAttribute("p", p);
		//初始化屬性值(不然第一次沒有值)
		propertyValueService.init(p);
		//查詢該產品的全部屬性值
		List<PropertyValueVO> pvs = propertyValueService.list(productId);
		m.addAttribute("pvs", pvs);
		return "admin/editProductValue";		
	}
	
	@RequestMapping("/updatePropertyValue")
	public @ResponseBody String updatePropertyValue(int propertyValueId,String value) {
		PropertyValueVO pv =propertyValueService.get(propertyValueId);
		pv.setValue(value);
		propertyValueService.update(pv);
		return "success";
	}
	@RequestMapping("/update")
	public String update(ProductVO p,int categoryId) {
		CategoryVO c = categoryService.get(categoryId);
		p.setCategory(c);		
		productService.update(p);
		return "redirect:/redirect/listProduct.jsp?categoryId="+p.getCategory().getCategoryId();
	}

	@RequestMapping("/list")
	public String list(Integer categoryId,Model m) {
		if(categoryId!=null) {
		CategoryVO c = categoryService.get(categoryId);
		List<ProductVO> ps = productService.list(categoryId);
		m.addAttribute("ps2", ps);
		m.addAttribute("c", c);
		}
		return "admin/listProduct";
	}
}
