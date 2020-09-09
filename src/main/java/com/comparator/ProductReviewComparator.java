package com.comparator;

import java.util.Comparator;

import com.product.ProductVO;

public class ProductReviewComparator implements Comparator<ProductVO>{

	@Override
	public int compare(ProductVO p1, ProductVO p2) {
		return p2.getReviewCount()-p1.getReviewCount();
	}

}
