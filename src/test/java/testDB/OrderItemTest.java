package testDB;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.member.MemberVO;
import com.order.OrderVO;
import com.orderitem.OrderItemVO;
import com.product.ProductVO;
import com.service.OrderItemService;

public class OrderItemTest {
//	@Test
//	public void add() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		OrderItemService bean = (OrderItemService)ap.getBean("orderItemServiceImpl");
//		
//		OrderItemVO orderItemVO = new OrderItemVO();
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMemberId(2);
//		ProductVO productVO = new ProductVO();
//		productVO.setProductId(3);
//		OrderVO orderVO = new OrderVO();
//		orderVO.setOrderId(2);
//		orderItemVO.setOrder(orderVO);
//		orderItemVO.setMember(memberVO);
//		orderItemVO.setCount(4);
//		orderItemVO.setProduct(productVO);
//		int add = bean.add(orderItemVO);
//		System.out.println(add);
//	}
//	@Test
//	public void get() {
//	ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//	OrderItemService bean = (OrderItemService)ap.getBean("orderItemServiceImpl");
//	OrderItemVO orderItemVO = bean.get(2);
//	System.out.println(orderItemVO);
//	}
//	@Test
//	public void update() {
//	ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//	OrderItemService bean = (OrderItemService)ap.getBean("orderItemServiceImpl");
//	OrderItemVO orderItemVO = bean.get(2);
//	orderItemVO.setOrderItemId(10);
//	bean.update(orderItemVO);
//	}
//	@Test
//	public void list() {
//	ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//	OrderItemService bean = (OrderItemService)ap.getBean("orderItemServiceImpl");
//	
//	List<OrderItemVO> listByUser = bean.listByUser(2);
//	listByUser.forEach(System.out::println);
//	List<OrderItemVO> listByOrder = bean.listByOrder(2);
//	listByOrder.forEach(System.out::println);
//	List<OrderItemVO> listByProduct = bean.listByProduct(3);
//	listByProduct.forEach(System.out::println);
//	for(OrderItemVO o:listByProduct) {
//		System.out.println(o.getOrder());
//	}
//	}
//	@Test
//	public void getSaleCount() {
//	ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//	OrderItemService bean = (OrderItemService)ap.getBean("orderItemServiceImpl");
//	int saleCount = bean.getSaleCount(3);
//	System.out.println("*********"+saleCount);
//	}
}
