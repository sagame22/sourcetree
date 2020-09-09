package testDB;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.member.MemberVO;
import com.order.OrderVO;
import com.service.OrderService;

public class OrderTest {
//	@Test
//	public void add$list() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		OrderService bean = (OrderService) ap.getBean("orderServiceImpl");
//		OrderVO ordervo = new OrderVO();
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMemberId(4);
//		ordervo.setAddress("55");
//		ordervo.setConfirmDate(new Date());
//		ordervo.setDeliveryDate(new Date());
//		ordervo.setOrderDate(new Date());
//		ordervo.setPayDate(new Date());
//		ordervo.setMember(memberVO);
//		ordervo.setMobile("556");
//		ordervo.setOrderCode("5586");
//		ordervo.setPost("655");
//		ordervo.setReceiver("755");
//		ordervo.setStatus("455");
//		ordervo.setUserMessage("45");
//		bean.add(ordervo);
//		System.out.println(ordervo + "-------------------------");
//		List<OrderVO> list = bean.list();
//		list.forEach(System.out::println);
//		System.out.println("************************************");
//		List<OrderVO> list2 = bean.list(2, "44");
//		list2.forEach(System.out::println);
//		
//	}
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		OrderService bean = (OrderService) ap.getBean("orderServiceImpl");
//		OrderVO orderVO = bean.get(3);
//		System.out.println(orderVO);
//	}
}
