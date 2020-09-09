package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.service.CategoryService;
import com.service.MemberService;
import com.service.OrderItemService;
import com.service.OrderService;
import com.service.ProductImageService;
import com.service.ProductService;
import com.service.PropertyService;
import com.service.PropertyValueService;
import com.service.ReviewService;

public abstract class FatherServlet {
	@Autowired
	public CategoryService categoryService;
	@Autowired
	public PropertyService propertyService;
	@Autowired
	public ProductService productService;
	@Autowired
	public PropertyValueService propertyValueService;
	@Autowired
	public MemberService memberService;
	@Autowired
	public OrderItemService orderItemService;
	@Autowired
	public OrderService orderService;
	@Autowired
	public ProductImageService productImageService;
	@Autowired
	public ReviewService reviewService;

}
