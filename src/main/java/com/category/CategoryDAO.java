package com.category;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CategoryDAO {
	
	public int getTotal();
	public int add(CategoryVO bean);
	public void update(CategoryVO bean);
	public void delete(@Param("categoryId") int id);
	public CategoryVO get(@Param("categoryId") int id);
	public List<CategoryVO> list();
}
