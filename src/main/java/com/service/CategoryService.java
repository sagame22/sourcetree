package com.service;

import java.util.List;

import com.category.CategoryVO;

public interface CategoryService {

	public int getTotal();
	public int add(CategoryVO bean);
	public void update(CategoryVO bean);
	public void delete(int id);
	public CategoryVO get(int id);
	public List<CategoryVO> list();
}
