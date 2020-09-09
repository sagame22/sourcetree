package com.service;

import java.util.List;


import com.product.ProductVO;
import com.propertyvalue.PropertyValueVO;

public interface PropertyValueService {
	public void add(PropertyValueVO bean);
	public void update(PropertyValueVO bean);
	public void delete(int id);
	public PropertyValueVO get(int id);
	public PropertyValueVO get(int ptid, int pid );
	public List<PropertyValueVO> list();
	public void init(ProductVO p);
	public List<PropertyValueVO> list(int pid);
}
