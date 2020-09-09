package com.product;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProductDAO {

//	public int getTotal(int cid);
	public int add(ProductVO bean);
	public void update(ProductVO bean);
	public void delete(@Param("productId") int id);
	public ProductVO get(@Param("productId")int id);
	public List<ProductVO> list(@Param("categoryId")int cid);
	public List<ProductVO> list1();
//	public void fill(List<CategoryVO> cs);
//	public void fill(CategoryVO c);
//	public void fillByRow(List<CategoryVO> cs);
//	public void setFirstProductImage(ProductVO p);
//	public void setSaleAndReviewNumber(ProductVO p);
//	public void setSaleAndReviewNumber(List<ProductVO> products);
	public List<ProductVO> search(@Param("keyword")String keyword);
}
