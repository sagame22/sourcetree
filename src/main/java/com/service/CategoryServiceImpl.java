package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category.CategoryDAO;
import com.category.CategoryVO;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryDAO categoryDAOImpl;
	@Override
	public int getTotal() {
		int total = categoryDAOImpl.getTotal();
		return total;
	}

	@Override
	public int add(CategoryVO bean) {
		int add = categoryDAOImpl.add(bean);
		
		return bean.getCategoryId();
	}

	@Override
	public void update(CategoryVO bean) {
		categoryDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		categoryDAOImpl.delete(id);
		
	}

	@Override
	public CategoryVO get(int id) {
		CategoryVO categoryVO = categoryDAOImpl.get(id);
		return categoryVO;
	}

	@Override
	public List<CategoryVO> list() {
		List<CategoryVO> list = categoryDAOImpl.list();
		return list;
	}
	

	public void setCategoryDAOImpl(CategoryDAO categoryDAOImpl) {
		this.categoryDAOImpl = categoryDAOImpl;
	}


}
