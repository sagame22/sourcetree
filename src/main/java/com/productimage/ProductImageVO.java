package com.productimage;

import com.product.ProductVO;

public class ProductImageVO implements java.io.Serializable{

    private String type;
    private ProductVO product;
    private int imageId;
 
    public int getImageId() {
        return imageId;
    }
     
    public void setImageId(int id) {
        this.imageId = id;
    }
 
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public ProductVO getProduct() {
        return product;
    }
    public void setProduct(ProductVO productVO) {
        this.product = productVO;
    }

	@Override
	public String toString() {
		return "ProductImageVO [type=" + type + ", product=" + product.getCategory().getCategoryId() + ", imageId=" + imageId + "]";

	}

	
    
}