<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<nav class="top ">
		<a href="${pageContext.request.contextPath}/index_f.jsp">
			<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-home redColor"></span>
			Yulin首頁
		</a>	
		
		
		<c:if test="${!empty member}">
			<a href="${pageContext.request.contextPath}/frontpage/register.jsp">${member.mname}</a>
			<a href="${pageContext.request.contextPath}/fore/logout">退出</a>		
		</c:if>
		
		<c:if test="${empty member}">
			<a href="${pageContext.request.contextPath}/frontpage/login.jsp"">登入</a>
			<a href="${pageContext.request.contextPath}/frontpage/register.jsp"">免費註冊</a>		
		</c:if>


		<span class="pull-right">
			<a href="${pageContext.request.contextPath}/fore/bought">我的訂單</a>
			<a href="${pageContext.request.contextPath}/fore/cart">
			<span style="color:#C40000;margin:0px" class=" glyphicon glyphicon-shopping-cart redColor"></span>
			購物車<strong>${cartTotalItemNumber}</strong>件</a>		
		</span>
		
		
</nav>



