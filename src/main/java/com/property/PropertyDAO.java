package com.property;

import java.util.List;

import org.apache.ibatis.annotations.Param;



public interface PropertyDAO {
	
	public int add(PropertyVO bean);
	public void update(PropertyVO bean);
	public void delete(@Param("propertyId")int id);
	public PropertyVO get(@Param("propertyId")int id);
	public List<PropertyVO> list(@Param("categoryId")int cid);

}
