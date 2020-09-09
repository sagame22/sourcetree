package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.ProductVO;
import com.productimage.ProductImageDAO;
import com.productimage.ProductImageVO;
@Service
public class ProductImageServiceImpl implements ProductImageService {
	@Autowired
	private ProductImageDAO productImageImpl;
	public static final String type_single = "type_single";
	public static final String type_detail = "type_detail";
	@Override
	public int add(ProductImageVO bean) {
		productImageImpl.add(bean);
		return bean.getImageId();
	}
	@Override
	public void delete(int id) {
		productImageImpl.delete(id);
		
	}
	@Override
	public ProductImageVO get(int id) {
		ProductImageVO productImageVO = productImageImpl.get(id);
		return productImageVO;
	}
	@Override
	public List<ProductImageVO> list(ProductVO p, String type) {
		List<ProductImageVO> list = productImageImpl.list(p, type);
		return list;
	}
	public void setProductImageImpl(ProductImageDAO productImageImpl) {
		this.productImageImpl = productImageImpl;
	}
	
}
