package com.propertyvalue;

import com.product.ProductVO;
import com.property.PropertyVO;

public class PropertyValueVO implements java.io.Serializable{

	 private String value;
	    private ProductVO productVO;
	    private PropertyVO propertyVO;
	    private int propertyValId;
	 
	    public int getPropertyValId() {
	        return propertyValId;
	    }
	 
	    public void setPropertyValId(int id) {
	        this.propertyValId = id;
	    }
	 
	    public String getValue() {
	        return value;
	    }
	    public void setValue(String value) {
	        this.value = value;
	    }
	    public ProductVO getProduct() {
	        return productVO;
	    }
	    public void setProduct(ProductVO product) {
	        this.productVO = product;
	    }
	    public PropertyVO getProperty() {
	        return propertyVO;
	    }
	    public void setProperty(PropertyVO property) {
	        this.propertyVO = property;
	    }

		@Override
		public String toString() {
			return "PropertyValueVO [value=" + value + ", productVO=" + productVO + ", propertyVO=" + propertyVO
					+ ", propertyValId=" + propertyValId + "]";
		}
	    
	}
