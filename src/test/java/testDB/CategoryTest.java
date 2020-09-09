package testDB;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.category.CategoryVO;
import com.service.CategoryService;
import com.service.CategoryServiceImpl;

public class CategoryTest {
	@Test
	public void add() {
		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
		CategoryService bean = (CategoryService)ap.getBean("categoryServiceImpl");
		System.out.println(bean);
		CategoryVO categoryVO = new CategoryVO();
		categoryVO.setCname("什");
		int add = bean.add(categoryVO);
		System.out.println(categoryVO+"id="+add);
		
	}
//	
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CategoryService bean = (CategoryService)ap.getBean("categoryServiceImpl");
//		CategoryVO categoryVO = bean.get(1);
//		System.out.println(categoryVO);
//	}
//	@Test
//	public void update() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CategoryService bean = (CategoryService)ap.getBean("categoryServiceImpl");
//		CategoryVO categoryVO = bean.get(1);
//		categoryVO.setCname("888");
//		bean.update(categoryVO);
//		
//		
//	}
//	
//	@Test
//	public void list() {
//		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		CategoryService bean = (CategoryService)ap.getBean("categoryServiceImpl");
//		List<CategoryVO> list = bean.list();
//		list.forEach(System.out::println);
//		ap.close();
//		
//	}

	
	
	
}