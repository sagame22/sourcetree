package com.product;

import java.util.Date;
import java.util.List;
import com.category.CategoryVO;
import com.productimage.ProductImageVO;
 
public class ProductVO implements java.io.Serializable{
    
	private static final long serialVersionUID = 1L;
	
	private String pname;
    private String subTitle;
    private int orignalPrice;
    private int promotePrice;
    private int stock;
    private Date createDate;
    private CategoryVO categoryVO;
    private int productId;
    //取多方圖片的第一張作為產品圖片
    private ProductImageVO firstProductImage;
    private List<ProductImageVO> productImages;
    private List<ProductImageVO> productSingleImages;
    private List<ProductImageVO> productDetailImages;
    private int reviewCount;
    private Integer saleCount;
 
    public String getPname() {
        return pname;
    }
    public void setPname(String pname) {
        this.pname = pname;
    }
    public String getSubTitle() {
        return subTitle;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }
    public int getOrignalPrice() {
        return orignalPrice;
    }
    public void setOrignalPrice(int orignalPrice) {
        this.orignalPrice = orignalPrice;
    }
    public int getPromotePrice() {
        return promotePrice;
    }
    public void setPromotePrice(int promotePrice) {
        this.promotePrice = promotePrice;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public CategoryVO getCategory() {
        return categoryVO;
    }
    public void setCategory(CategoryVO categoryVO) {
        this.categoryVO = categoryVO;
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int id) {
        this.productId = id;
    }
     
    public ProductImageVO getFirstProductImage() {
        return firstProductImage;
    }
    public void setFirstProductImage(ProductImageVO firstProductImage) {
        this.firstProductImage = firstProductImage;
    }
    public List<ProductImageVO> getProductImages() {
        return productImages;
    }
    public void setProductImages(List<ProductImageVO> productImages) {
        this.productImages = productImages;
    }
    public List<ProductImageVO> getProductSingleImages() {
        return productSingleImages;
    }
    public void setProductSingleImages(List<ProductImageVO> productSingleImages) {
        this.productSingleImages = productSingleImages;
    }
    public List<ProductImageVO> getProductDetailImages() {
        return productDetailImages;
    }
    public void setProductDetailImages(List<ProductImageVO> productDetailImages) {
        this.productDetailImages = productDetailImages;
    }
    public int getReviewCount() {
        return reviewCount;
    }
    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }
    public Integer getSaleCount() {
        return saleCount;
    }
    public void setSaleCount(Integer saleCount) {
        this.saleCount = saleCount;
    }
	@Override
	public String toString() {
		return "ProductVO [pname=" + pname + ", subTitle=" + subTitle + ", orignalPrice=" + orignalPrice
				+ ", promotePrice=" + promotePrice + ", stock=" + stock + ", createDate=" + createDate + ", categoryVOid="
				+ categoryVO.getCategoryId() + ", productId=" + productId + ", firstProductImage=" + firstProductImage
				+ ", productImages=" + productImages + ", productSingleImages=" + productSingleImages
				+ ", productDetailImages=" + productDetailImages + ", reviewCount=" + reviewCount + ", saleCount="
				+ saleCount + "]+cname="+categoryVO.getCname();
	}
    
     
}