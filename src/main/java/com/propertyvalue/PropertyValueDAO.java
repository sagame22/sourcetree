package com.propertyvalue;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.product.ProductVO;


public interface PropertyValueDAO {

	public void add(PropertyValueVO bean);
	public void update(PropertyValueVO bean);
	public void delete(@Param("ptvid")int id);
	public PropertyValueVO get(@Param("ptvid")int id);
	public PropertyValueVO get1(@Param("ptid")int ptid,@Param("pid") int pid );
	public List<PropertyValueVO> list();
	public void init(ProductVO p);
	public List<PropertyValueVO> list1(@Param("pid")int pid);
	
}
