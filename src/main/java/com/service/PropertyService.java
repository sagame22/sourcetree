package com.service;

import java.util.List;


import com.property.PropertyVO;

public interface PropertyService {
	public int add(PropertyVO bean);
	public void update(PropertyVO bean);
	public void delete(int id);
	public PropertyVO get(int id);
	public List<PropertyVO> list(int cid);
}
