<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>
<%@ page import="com.member.*"%>
<%@ page import="com.service.*"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
 
<% 	ServletContext sc = this.getServletContext();
	ApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
	MemberService bean = (MemberService) ac.getBean("memberServiceImpl");		
	List<MemberVO> list =bean.list();
	request.setAttribute("list",list);
																						%>
<script>
</script>

<title>用戶管理</title>


<div class="workingArea">
	<h1 class="label label-info" >用戶管理</h1>

	<br>
	<br>
	
	<div class="listDataTableDiv">
		<table class="table table-striped table-bordered table-hover  table-condensed">
			<thead>
				<tr class="bg-primary">
					<th>ID</th>
					<th>用戶名稱</th>
				</tr>
			</thead>
<%@ include file="/WEB-INF/page/page1.file" %> 		
			<tbody>
				<c:forEach items="${list}" var="m" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
				
				<tr>
					<td>${m.memberId}</td>
					<td>${m.mname}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<%@ include file="/WEB-INF/page/page2.file" %> 
	
	
</div>

<%@include file="../include/admin/adminFooter.jsp"%>
