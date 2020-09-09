package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.category.CategoryVO;
import com.orderitem.OrderItemDAO;
import com.product.ProductDAO;
import com.product.ProductVO;
import com.productimage.ProductImageDAO;
import com.productimage.ProductImageVO;
import com.review.ReviewDAO;
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private OrderItemDAO orderItemDAOImpl;
	@Autowired
	private ReviewDAO reviewDAOImpl;
	@Autowired
	private ProductImageDAO productImageDAOImpl;
	@Autowired
	private ProductDAO productDAOImpl;
	

	@Override
	public int add(ProductVO bean) {
		bean.setCreateDate(new Date());
		int add = productDAOImpl.add(bean);
		return add;
	}

	@Override
	public void update(ProductVO bean) {
		bean.setCreateDate(new Date());
		productDAOImpl.update(bean);
		
	}

	@Override
	public void delete(int id) {
		productDAOImpl.delete(id);
		
	}

	@Override
	public ProductVO get(int id) {
		ProductVO productVO = productDAOImpl.get(id);
		this.setFirstProductImage(productVO);
		return productVO;
	}

	@Override
	public List<ProductVO> list(int cid) {
		List<ProductVO> list = productDAOImpl.list(cid);
		for(ProductVO p:list)
			this.setFirstProductImage(p);
		return list;
	}

	@Override
	public List<ProductVO> list() {
		List<ProductVO> list1 = productDAOImpl.list1();
		return list1;
	}

	@Override
	 //取所有分類(設定onToMany也可以設定)
    public void fill(List<CategoryVO> cs) {
        for (CategoryVO c : cs)
            fill(c);
    }//把該分類的所有產品取出,存入1方(展示前台)
    public void fill(CategoryVO c) {
            List<ProductVO> ps = this.list(c.getCategoryId());
            c.setProducts(ps);
    }

	@Override
	public void fillByRow(List<CategoryVO> cs) {
		//產品每列幾個
        int productNumberEachRow = 8;
        for (CategoryVO c : cs) {
        //取出分類的所有產品(list)	
            List<ProductVO> products =  c.getProducts();
        //把所有8個產品(list)存入list    
            List<List<ProductVO>> productsByRow =  new ArrayList<>();
            for (int i = 0; i < products.size(); i+=productNumberEachRow) {
            	//size算出總共幾列(往小的取)(大於取size())
                int size = i+productNumberEachRow;
                size= size>products.size()?products.size():size;
                //假設40個產品-->每列8個-->list存入5個(8個產品的list),不足8個取products.size()擷取subList
                List<ProductVO> productsOfEachRow =products.subList(i, size);
                productsByRow.add(productsOfEachRow);
            }
            c.setProductsByRow(productsByRow);
        }
    }

	@Override
	public void setFirstProductImage(ProductVO p) {
		 List<ProductImageVO> pis= productImageDAOImpl.list(p, ProductImageServiceImpl.type_single);
	        if(!pis.isEmpty())
	            p.setFirstProductImage(pis.get(0));    
	    }

	@Override
	public void setSaleAndReviewNumber(ProductVO p) {
		//計算銷售總量-->訂單明細內透過PID查出該產品的總量-->評價內透過PID查出該評價的總量
		Integer saleCount = orderItemDAOImpl.getSaleCount(p.getProductId());
		/*Sql的SUM()如果結果為零會回傳null*/
		if(saleCount!=null)
        p.setSaleCount(saleCount);         
 
        Integer reviewCount = reviewDAOImpl.getCount(p.getProductId());
        p.setReviewCount(reviewCount);
         
    }

	@Override
	public void setSaleAndReviewNumber(List<ProductVO> products) {
		 for (ProductVO p : products) {
	            setSaleAndReviewNumber(p);
	        }
	    }

	@Override
	public List<ProductVO> search(String keyword) {
        
        if(null==keyword||0==keyword.trim().length())
            return new ArrayList<ProductVO>();
        
		List<ProductVO> search = productDAOImpl.search("%"+keyword+"%");
		return search;
	}
	
	public void setProductDAOImpl(ProductDAO productDAOImpl) {
		this.productDAOImpl = productDAOImpl;
	}

	public void setOrderItemDAOImpl(OrderItemDAO orderItemDAOImpl) {
		this.orderItemDAOImpl = orderItemDAOImpl;
	}

	public void setReviewDAOImpl(ReviewDAO reviewDAOImpl) {
		this.reviewDAOImpl = reviewDAOImpl;
	}

	public void setProductImageDAOImpl(ProductImageDAO productImageDAOImpl) {
		this.productImageDAOImpl = productImageDAOImpl;
	}
	
}
