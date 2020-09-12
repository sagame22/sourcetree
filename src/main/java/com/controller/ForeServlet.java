package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.util.HtmlUtils;

import com.category.CategoryVO;
import com.comparator.ProductAllComparator;
import com.comparator.ProductPriceComparator;
import com.comparator.ProductSaleCountComparator;
import com.member.MemberVO;
import com.order.OrderVO;
import com.orderitem.OrderItemVO;
import com.product.ProductVO;
import com.productimage.ProductImageVO;
import com.propertyvalue.PropertyValueVO;
import com.review.ReviewVO;
import com.service.OrderServiceImpl;
import com.service.ProductImageServiceImpl;

@Controller
@SessionAttributes(value= {"member","ois","cartTotalItemNumber"})
@RequestMapping("/fore")
public class ForeServlet extends FatherServlet {
	
		
	@RequestMapping("/home")
	public String home(Model m) {
		List<CategoryVO> cs = categoryService.list();
		productService.fill(cs);
		productService.fillByRow(cs);
		m.addAttribute("cs", cs);
		return "forward:/frontpage/home.jsp";
	}
	
	@RequestMapping("/register")
	public String register(MemberVO member,Model m,String status) {
		System.out.println("777777");
		//轉譯HTML標籤,防止惡意注入
		String mname = HtmlUtils.htmlEscape(member.getMname());
		boolean exist = memberService.isExist(mname);
		if(exist){
			m.addAttribute("msg", "用戶名已被使用");
			return "forward:/frontpage/register.jsp";	
		}System.out.println("6666666");
		member.setMname(mname);
		memberService.add(member);
		System.out.println("55555555555");
		return "redirect:/frontpage/registerSuccess.jsp";	
	}	
	
	@RequestMapping("login")
	public String login(String mname,String password,Model m) {
		String name = HtmlUtils.htmlEscape(mname);
		MemberVO member = memberService.get(name,password);
		if(null==member){
			m.addAttribute("msg", "帳號密碼錯誤");
			return "forward:/frontpage/login.jsp";		
		}
		m.addAttribute("member", member);
		return "redirect:/index_f.jsp";	
	}	
	@RequestMapping("/product")
	public String product(int productId,Model m) {
		//查出產品,將圖片注入
		ProductVO p = productService.get(productId);
		List<ProductImageVO> productSingleImages = productImageService.list(p, ProductImageServiceImpl.type_single);
		List<ProductImageVO> productDetailImages = productImageService.list(p, ProductImageServiceImpl.type_detail);
		p.setProductSingleImages(productSingleImages);
		p.setProductDetailImages(productDetailImages);
		//查出產品屬性值和評價
		List<PropertyValueVO> pvs = propertyValueService.list(productId);		
		List<ReviewVO> reviews = reviewService.list(productId);
		productService.setSaleAndReviewNumber(p);
		//轉發
		m.addAttribute("reviews", reviews);
		m.addAttribute("p", p);
		m.addAttribute("pvs", pvs);
		
		return "forward:/frontpage/product.jsp";		
	}
	@RequestMapping("/logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		return "redirect:/index_f.jsp";	
	}	
	
	@RequestMapping("/checkLogin")
	public @ResponseBody String checkLogin(ModelMap mp) {
		MemberVO member = (MemberVO)mp.get("member");
		if(null!=member)
			return "success";
		return "fail";
	} 
	@RequestMapping("/loginAjax")
	public @ResponseBody String loginAjax(String mname ,String password,Model m) {
		MemberVO member = memberService.get(mname,password);
		if(null==member){
			return "fail";	
		}
		m.addAttribute("member", member);
		return "success";	
	}	
	@RequestMapping("/category")
	public String category(int categoryId ,String sort,Model m) {
		CategoryVO c = categoryService.get(categoryId);
		productService.fill(c);
		productService.setSaleAndReviewNumber(c.getProducts());		
		if(null!=sort){
		switch(sort){
			case "review":
				Collections.sort(c.getProducts(),(p1,p2)->(p2.getReviewCount()-p1.getReviewCount()));
				break;
			case "date" :
				List<ProductVO> list = c.getProducts().stream()
				.sorted((p1,p2)->(p1.getCreateDate().compareTo(p2.getCreateDate()))).collect(Collectors.toList());
				c.setProducts(list);
				break;
			case "saleCount" :
				Collections.sort(c.getProducts(),new ProductSaleCountComparator());
				break;
			case "price":
				Collections.sort(c.getProducts(),new ProductPriceComparator());
				break;
			case "all":
				Collections.sort(c.getProducts(),new ProductAllComparator());
				break;
			}
		}
		
		m.addAttribute("c", c);
		return "forward:/frontpage/category.jsp";		
	}	
	@RequestMapping("/search")
	public String search(String keyword,Model m){
		List<ProductVO> ps= productService.search(keyword);
		productService.setSaleAndReviewNumber(ps);
		m.addAttribute("ps",ps);
		return "forward:/frontpage/searchResult.jsp";
	}	
	@RequestMapping("/buyone")
	public String buyone(int productId,int num,ModelMap mp) {
		ProductVO p = productService.get(productId);
		MemberVO member =(MemberVO)mp.get("member");
		int oiid = 0;
		//定義一個flag,若是相同產品則改為true
		boolean found = false;
		//取得會員編號,用會員編號查詢該會員的訂單細項
		List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
		
		//將訂單細項取出比對,若產品相同則將產品數量累加
		for (OrderItemVO oi : ois) {
			if(oi.getProduct().getProductId()==p.getProductId()){
				oi.setCount(oi.getCount()+num);
				//將訂單明細新增
				orderItemService.update(oi);
				found = true;
				oiid = oi.getOrderItemId();
				break;
			}
		}		
		
		//若不是相同產品
		if(!found){
			OrderItemVO oi = new OrderItemVO();
			oi.setMember(member);
			oi.setCount(num);
			oi.setProduct(p);
			oiid = orderItemService.add(oi);
		}
		return "redirect:/fore/buy?oiid="+oiid;
	}

	@RequestMapping("/addCart")
	public @ResponseBody String addCart(int productId , int num,ModelMap mp) {
		ProductVO p = productService.get(productId);
		MemberVO member =(MemberVO) mp.get("member");
		
		boolean found = false;
		//取會員的購物車內容
		List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
		
		for (OrderItemVO oi : ois) {
			if(oi.getProduct().getProductId()==p.getProductId()){
				oi.setCount(oi.getCount()+num);
				orderItemService.update(oi);
				found = true;
				break;
			}
		}		
		//無購物車內容
		if(!found){
			OrderItemVO oi = new OrderItemVO();
			oi.setMember(member);
			oi.setCount(num);
			oi.setProduct(p);
			orderItemService.add(oi);
		}
		return "success";
	}
	@RequestMapping("buy")
	public String buy(int[] oiid,Model m){
		//取得所有訂單明細
		//創建一個放訂單VO的list
		List<OrderItemVO> ois = new ArrayList<>();
		int total = 0;
		for (int oi_id : oiid) {
			OrderItemVO oi= orderItemService.get(oi_id);
			//取出訂單中的產品的價格*數量計算總金額
			total +=oi.getProduct().getPromotePrice()*oi.getCount();
			ois.add(oi);
		}
		//把所有訂單明細和金額存入轉發至結帳頁面
		m.addAttribute("ois", ois);
		m.addAttribute("total", total);
		return "forward:/frontpage/buy.jsp";
	}	
	@RequestMapping("cart")
	public String cart(ModelMap mp) {
		//獲取會員編號查詢該會員的訂單明細
		MemberVO member =(MemberVO) mp.get("member");
		List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
		mp.addAttribute("ois", ois);
		return "forward:/frontpage/cart.jsp";
	}	
	@RequestMapping("changeOrderItem")
	 public @ResponseBody String changeOrderItem(ModelMap mp,int pid ,int count) {
		 	//取出會員編號,若無返回fail重新登錄
	        MemberVO member =(MemberVO) mp.get("member");
	        if(null==member)
	            return "fail";
	        //取出會員訂單明細
	        List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
	        for (OrderItemVO oi : ois) {
	            if(oi.getProduct().getProductId()==pid){
	                oi.setCount(count);
	                orderItemService.update(oi);
	                break;
	            }
	             
	        }      
	        return "success";
	    }
	@RequestMapping("deleteOrderItem")
	 public @ResponseBody String deleteOrderItem(ModelMap mp, int oiid){
			MemberVO member =(MemberVO) mp.get("member");
			if(null==member)
				return "fail";

			List<OrderItemVO> ois = orderItemService.listByUser(member.getMemberId());
			for (OrderItemVO oi : ois) {
				if(oi.getOrderItemId()==oiid){
					orderItemService.delete(oiid);
					break;
				}
				
			}		
			return "success";
		}
	@RequestMapping("createOrder")
	 public String createOrder(OrderVO order,ModelMap mp){
		 	MemberVO member =(MemberVO) mp.get("member");
		     //取得會員編號和訂單明細
		    List<OrderItemVO> ois= (List<OrderItemVO>) mp.get("ois");
		    if(ois.isEmpty())
		        return "redirect:/forepage/login.jsp";
		    String orderCode = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) +RandomUtils.nextInt(10000);
		    order.setOrderCode(orderCode);
		    order.setOrderDate(new Date());
		    order.setMember(member);
		    order.setStatus(OrderServiceImpl.waitPay);
		    //新增訂單和加入ORDER的PK給多方的orderItem
		    int orderPK = orderService.add(order);
		    order.setOrderId(orderPK);
		    
		    float total =0;
		    for (OrderItemVO oi: ois) {
		        oi.setOrder(order);
		        orderItemService.update(oi);
		        total+=oi.getProduct().getPromotePrice()*oi.getCount();
		    }
		     
		    return "redirect:/fore/alipay?oid="+orderPK+"&total="+total;
		}
	@RequestMapping("alipay")
	 public String alipay(){
		    return "forward:/frontpage/alipay.jsp";
		}
	@RequestMapping("payed")
	 public String payed(int oid,Model m) {
		    OrderVO order = orderService.get(oid);
		    order.setStatus(OrderServiceImpl.waitDelivery);
		    order.setPayDate(new Date());
		    orderService.update(order);
		    m.addAttribute("o", order);
		    return "forward:/frontpage/payed.jsp";    
		} 
	@RequestMapping("bought")
	 public String bought(ModelMap m) {
		    MemberVO member =(MemberVO) m.get("member");
		    
		    List<OrderVO> os= orderService.list(member.getMemberId(),OrderServiceImpl.delete);
		    orderItemService.fill(os);
		     
		    m.addAttribute("os", os);
		     
		    return "forward:/frontpage/bought.jsp";       
		}
	@RequestMapping("confirmPay")
	 public String confirmPay(int oid,Model m) {
			OrderVO o = orderService.get(oid);
			orderItemService.fill(o);
			m.addAttribute("o", o);
			return "forward:/frontpage/confirmPay.jsp";		
		}
	@RequestMapping("orderConfirmed")
	 public String orderConfirmed(Model m,int oid) {
			OrderVO o = orderService.get(oid);
			o.setStatus(OrderServiceImpl.waitReview);
			o.setConfirmDate(new Date());
			orderService.update(o);
			return "forward:/frontpage/orderConfirmed.jsp";
		}
	@RequestMapping("deleteOrder")
	 public @ResponseBody String deleteOrder(int oid){
			OrderVO o = orderService.get(oid);
			o.setStatus(OrderServiceImpl.delete);
			orderService.update(o);
			return "success";		
		}
	@RequestMapping("review")
	 public String review(int oid,Model m) {
		    OrderVO o = orderService.get(oid);
		    orderItemService.fill(o);
		    ProductVO p = o.getOrderItems().get(0).getProduct();
		    List<ReviewVO> reviews = reviewService.list(p.getProductId());
		    productService.setSaleAndReviewNumber(p);
		    m.addAttribute("p", p);
		    m.addAttribute("o", o);
		    m.addAttribute("reviews", reviews);
		    return "forward:/frontpage/review.jsp";       
		}
	@RequestMapping("doreview")
	 public String doreview(ReviewVO review,ModelMap mp,int orderId,int productId) {
		    OrderVO o = orderService.get(orderId);
		    o.setStatus(OrderServiceImpl.finish);
		    orderService.update(o);
		    ProductVO p = productService.get(productId);
		 
		    MemberVO member =(MemberVO) mp.get("member");
		    review.setProduct(p);
		    review.setReviewDate(new Date());
		    review.setMember(member);
		    reviewService.add(review);
		     
		    return "redirect:/fore/review?oid="+orderId+"&showonly=true";    
		}
}
