<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	

<div class="categoryMenu">
	
		<c:forEach items="${cs}" var="c" varStatus="st">
			<c:if test="${st.count<=4}">
			
			
				<a href="${pageContext.request.contextPath}/fore/category?categoryId=${c.categoryId}">
				<span class="glyphicon glyphicon-link"></span>
					${c.cname}
				</a>		
			</c:if>
		</c:forEach>
	</div>
