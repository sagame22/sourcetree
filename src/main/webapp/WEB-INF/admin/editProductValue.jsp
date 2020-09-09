<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


<title>編輯產品屬性值</title>
<style>
.wrong{
color:red;
background:url(<%=request.getContextPath()%>/img/site/xx.png) no-repeat ;
background-position: 85% 10%;
}
.right{
background:url(<%=request.getContextPath()%>/img/site/oo.png) no-repeat  ;
background-position: 85% 10%;
}
</style>
<script>
$(function(){
	
	$("input").each(function(){
		$(this).on("keyup",function(){
			var value = $(this).val();
			var page = "updatePropertyValue";
			var propertyValueId = $(this).attr("propertyValueId");
			var parentSpan = $(this).parent();
			$.post(
				    page,
				    {"value":value,"propertyValueId":propertyValueId},
				    function(result){
				    	if("success"==result){
				    		parentSpan.parent().addClass("wrong");
				    		parentSpan.parent().addClass("right");
			    	    	}
				    	else{
				    		parentSpan.parent().addClass("right");
				    		parentSpan.parent().addClass(" wrong");
			    	    	}
			});
		});
	});
});

</script>

<div class="workingArea">
	<ol class="breadcrumb">
	  <li><a href="${pageContext.request.contextPath}/admin/category/list">所有分類</a></li>
	  <li><a href="${pageContext.request.contextPath}/admin/product/list?categoryId=${p.category.categoryId}">${p.category.cname}</a></li>
	  <li class="active">${p.pname}</li>
	  <li class="active">編輯產品屬性</li>
	</ol>
	
	<div class="editPVDiv">
		<c:forEach items="${pvs}" var="pv" varStatus="status">
			<div class="eachPV form-group">
				<div style="text-align:center">　
				<span style="padding-right:40px;" class="pvName" >${pv.property.name}</span>
				<span class="pvValue　message"　>
				<input size=6 class='pvValue form-control ' propertyValueId="${pv.propertyValId}" type="text" value="${pv.value}">
				 </span></div>
			</div>
		</c:forEach>
	<div style="clear:both"></div>	
	</div>
	
</div>

