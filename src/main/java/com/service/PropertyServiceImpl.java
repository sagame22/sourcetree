package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.property.PropertyDAO;
import com.property.PropertyVO;

@Service
public class PropertyServiceImpl implements PropertyService {
	@Autowired
	private PropertyDAO propertyDAOImpl;

	@Override
	public int add(PropertyVO bean) {
		int add = propertyDAOImpl.add(bean);
		return add;
	}

	@Override
	public void update(PropertyVO bean) {
		propertyDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		propertyDAOImpl.delete(id);
		
	}

	@Override
	public PropertyVO get(int id) {
		PropertyVO propertyVO = propertyDAOImpl.get(id);
		return propertyVO;
	}

	@Override
	public List<PropertyVO> list(int cid) {
		List<PropertyVO> list = propertyDAOImpl.list(cid);
		return list;
	}
	
	public void setPropertyDAOImpl(PropertyDAO propertyDAOImpl) {
		this.propertyDAOImpl = propertyDAOImpl;
	}


}
