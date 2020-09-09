package com.productimage;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.product.ProductVO;


public interface ProductImageDAO {

	public int add(ProductImageVO bean);
	public void delete(@Param("piid") int id);
	public ProductImageVO get(@Param("piid") int id);
	public List<ProductImageVO> list(@Param("product") ProductVO p, @Param("type")String type);
	
}
