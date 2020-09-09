<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../include/admin/adminHeader.jsp"%>
<%@include file="../include/admin/adminNavigator.jsp"%>


<title>編輯產品</title>

<script>
$(function() {
	$("#editForm").submit(function() {
		if (!checkEmpty("name", "產品名稱"))
			return false;
		if (!checkNumber("orignalPrice", "原價格"))
			return false;
		if (!checkNumber("promotePrice", "優惠價格"))
			return false;
		if (!checkInt("stock", "庫存"))
			return false;
		return true;
	});
});
</script>

<div class="workingArea">
	<ol class="breadcrumb">
	  <li><a href="${pageContext.request.contextPath}/admin/category/list">所有分類</a></li>
	  <li><a href="${pageContext.request.contextPath}/admin/product/list?categoryId=${p.category.categoryId}">${p.category.cname}</a></li>
	  <li class="active">${p.pname}</li>
	  <li class="active">編輯產品</li>
	</ol>
	
	<div class="panel panel-warning editDiv">
		<div class="list-group-item list-group-item-info">編輯產品</div>
		<div class="panel-body">
			<form method="post" id="editForm" action="${pageContext.request.contextPath}/admin/product/update">
				<table class="editTable">
				<tr>
						<td>產品名稱</td>
						<td><input id="name" name="pname" value="${p.pname}"
							type="text" class="form-control"></td>
					</tr>
					<tr>
						<td>產品小標題</td>
						<td><input id="subTitle" name="subTitle" type="text"
						value="${p.subTitle}"
							class="form-control"></td>
					</tr>
					<tr>
						<td>原價格</td>
						<td><input id="orignalPrice" value="${p.orignalPrice}" name="orignalPrice" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>優惠價格</td>
						<td><input id="promotePrice"  value="${p.promotePrice}" name="promotePrice" type="text"
							class="form-control"></td>
					</tr>
					<tr>
						<td>庫存</td>
						<td><input id="stock"  value="${p.stock}" name="stock" type="text"
							class="form-control"></td>
					</tr>
										
					<tr class="submitTR">
						<td colspan="2" align="center">
						<input type="hidden" name="productId" value="${p.productId}">
						<input type="hidden" name="categoryId" value="${p.category.categoryId}">
						<button type="submit" class="btn btn-success">提 交</button></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</div>