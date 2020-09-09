package com.category;

import java.util.List;

import com.product.ProductVO;



public class CategoryVO implements java.io.Serializable {
 
    private String cname;
    private int categoryId;
    List<ProductVO> products;
    List<List<ProductVO>> productsByRow;
 
    public int getCategoryId() {
        return categoryId;
    }
 
    public void setCategoryId(int id) {
        this.categoryId = id;
    }
 
    public String getCname() {
        return cname;
    }
 
    public void setCname(String cname) {
        this.cname = cname;
    }
 
    
    public List<ProductVO> getProducts() {
        return products;
    }
 
    public void setProducts(List<ProductVO> products) {
        this.products = products;
    }
 
    public List<List<ProductVO>> getProductsByRow() {
        return productsByRow;
    }
 
    public void setProductsByRow(List<List<ProductVO>> productsByRow) {
        this.productsByRow = productsByRow;
    }

	@Override
	public String toString() {
		return "CategoryVO [cname=" + cname + ", categoryId=" + categoryId + ", products=" + products
				+ ", productsByRow=" + productsByRow + "]";
	}
     
    
 
}