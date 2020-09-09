package com.property;

import com.category.CategoryVO;

public class PropertyVO implements java.io.Serializable{
	 
	private static final long serialVersionUID = 1L;
	
	private String name;
    private CategoryVO categoryVO;
    private int propertyId;
 
    public int getPropertyId() {
        return propertyId;
    }
 
    public void setPropertyId(int id) {
        this.propertyId = id;
    }
 
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public CategoryVO getCategory() {
        return categoryVO;
    }
    public void setCategory(CategoryVO category) {
        this.categoryVO = category;
    }

	@Override
	public String toString() {
		return "PropertyVO [name=" + name + ", categoryVO=" + categoryVO + ", propertyId=" + propertyId + "]";
	}
     
}
