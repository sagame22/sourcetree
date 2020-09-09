package testDB;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.category.CategoryVO;
import com.product.ProductVO;
import com.productimage.ProductImageVO;
import com.service.ProductImageService;

public class ProductImageTest {
//	@Test
//	public void add() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductImageService bean = (ProductImageService)ap.getBean("productImageServiceImpl");
//		ProductImageVO productImageVO = bean.get(1);
//		productImageVO.setImageId(0);
//		bean.add(productImageVO);
//}
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductImageService bean = (ProductImageService)ap.getBean("productImageServiceImpl");
//		ProductImageVO productImageVO = bean.get(1);
//		System.out.println(productImageVO);
//}
//	@Test
//	public void list() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		ProductImageService bean = (ProductImageService)ap.getBean("productImageServiceImpl");
//		ProductVO productVO = new ProductVO();
//		productVO.setProductId(2);
//		List<ProductImageVO> list = bean.list(productVO, "66");
//		list.forEach(System.out::println);
//		
//}
}