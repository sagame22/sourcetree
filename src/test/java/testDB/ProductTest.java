package testDB;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.category.CategoryVO;
import com.product.ProductVO;
import com.productimage.ProductImageVO;
import com.service.ProductService;


public class ProductTest {
	
//	@Test
//	public void add() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		ProductVO productVO = new ProductVO();
//		
//		CategoryVO categoryVO = new CategoryVO();
//		categoryVO.setCategoryId(2);
//		
//		productVO.setCategory(categoryVO);
//		productVO.setCreateDate(new Date());
//		productVO.setPname("tool");
//		productVO.setSubTitle("hi");
//		productVO.setOrignalPrice(444.0);
//		productVO.setPromotePrice(500.0);
//		productVO.setStock(555);
//		bean.add(productVO);
//		
//	}
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		ProductVO productVO = bean.get(2);
//		System.out.println(productVO);
//		
//	}
//	@Test
//	public void update() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		ProductVO productVO = bean.get(3);
//		productVO.setProductId(4);
//		bean.update(productVO);
//		
//	}
//	@Test
//	public void update() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		ProductVO productVO = bean.get(3);
//		productVO.setProductId(4);
//		bean.update(productVO);
//		
//	}
//	@Test
//	public void list() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		List<ProductVO> list = bean.list();
//		list.forEach(System.out::println);
//		
//		List<ProductVO> list2 = bean.list(1);
//		list2.forEach(System.out::println);
//	}
//	@Test
//	public void search() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductService bean = (ProductService)ap.getBean("productServiceImpl");
//		List<ProductVO> search = bean.search("5");
//		search.forEach(System.out::println);
//	}

}
