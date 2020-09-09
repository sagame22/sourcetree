package testDB;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.member.MemberVO;
import com.service.MemberService;

public class MemberTest {
//	@Test
//	public void add$$list() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MemberService bean = (MemberService)ap.getBean("memberServiceImpl");
//		MemberVO memberVO = new MemberVO();
//		memberVO.setMname("ZZZ");
//		memberVO.setPassword("123");
//		bean.add(memberVO);
//		System.out.println(memberVO+"-------------------------");
//		List<MemberVO> list = bean.list();
//		list.forEach(System.out::println);
//	}
	
//	@Test
//	public void get() {
//		ApplicationContext ap = new ClassPathXmlApplicationContext("applicationContext.xml");
//		MemberService bean = (MemberService)ap.getBean("memberServiceImpl");
//		MemberVO memberVO = bean.get(1);
//		System.out.println(memberVO+"**********");
//		MemberVO memberVO2 = bean.get("BBB");
//		System.out.println(memberVO2+"***********");
//		MemberVO memberVO3 = bean.get("HHH", "123");
//		System.out.println(memberVO3);
//	}
}
