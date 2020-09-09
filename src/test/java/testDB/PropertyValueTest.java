package testDB;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.category.CategoryVO;
import com.product.ProductVO;
import com.property.PropertyVO;
import com.propertyvalue.PropertyValueVO;
import com.service.PropertyValueService;

public class PropertyValueTest {
//	@Test
//	public void add() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		PropertyValueService bean = (PropertyValueService)ap.getBean("propertyValueServiceImpl");
//		PropertyValueVO propertyValueVO = new PropertyValueVO();
//		propertyValueVO.setValue("666");
//		ProductVO product = new ProductVO();
//		product.setProductId(3);
//		PropertyVO property = new PropertyVO();
//		property.setPropertyId(2);
//		propertyValueVO.setProduct(product);
//		propertyValueVO.setProperty(property);
//		bean.add(propertyValueVO);
//}
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		PropertyValueService bean = (PropertyValueService)ap.getBean("propertyValueServiceImpl");
//		PropertyValueVO propertyValueVO = bean.get(2, 3);
//		System.out.println(propertyValueVO);
//}
	@Test
	public void list() {
		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
		PropertyValueService bean = (PropertyValueService)ap.getBean("propertyValueServiceImpl");
		List<PropertyValueVO> list = bean.list(2);
		System.out.println(list.size());
		System.out.println(list);
}
}
