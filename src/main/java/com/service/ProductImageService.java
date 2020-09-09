package com.service;

import java.util.List;

import com.product.ProductVO;
import com.productimage.ProductImageVO;

public interface ProductImageService {
	public int add(ProductImageVO bean);
	public void delete(int id);
	public ProductImageVO get(int id);
	public List<ProductImageVO> list(ProductVO p,String type);
}
