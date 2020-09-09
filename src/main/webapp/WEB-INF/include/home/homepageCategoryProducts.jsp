<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

<c:if test="${empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="100"/>
</c:if>

<c:if test="${!empty param.categorycount}">
	<c:set var="categorycount" scope="page" value="${param.categorycount}"/>
</c:if>

<div class="homepageCategoryProducts">
	<c:forEach items="${cs}" var="c" varStatus="stc">
		<c:if test="${stc.count<=categorycount}">
			<div class="eachHomepageCategoryProducts">
				<div class="left-mark"></div>
				<span class="categoryTitle">${c.cname}</span>
				<br>
				<c:forEach items="${c.products}" var="p" varStatus="st">
					<c:if test="${st.count<=5}">
						<div class="productItem" >
							<a href="${pageContext.request.contextPath}/fore/product?productId=${p.productId}"><img width="100px" src="${pageContext.request.contextPath}/img/productSingle_middle/${p.firstProductImage.imageId}.jpg"></a>
							<a class="productItemDescLink" href="${pageContext.request.contextPath}/fore/product?productId=${p.productId}">
								<span class="productItemDesc">[熱銷]
							 	${fn:substring(p.pname, 0, 20)} 
								</span>
								
						    </a>
							<span class="productPrice">
								<fmt:formatNumber type="number" value="${p.promotePrice}" />元
							</span>
						</div>
					</c:if>				
				</c:forEach>
				<div style="clear:both"></div>
			</div>
		</c:if>
	</c:forEach>
	
	
<!-- 	<img id="endpng" class="endpng" src="img/site/end.png"> -->

</div>