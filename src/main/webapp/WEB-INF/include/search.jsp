<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<div class="row" style="width:1250px;">
 

	<div class="firstPage col-md-3">
	<a href="${pageContext.request.contextPath}/index_f.jsp">
		<img id="logo" src="${pageContext.request.contextPath}/img/site/YL.png" class="logo">
	</a>
	</div>
	<form action="${pageContext.request.contextPath}/fore/search" method="post" >	
		<div class="searchDiv col-md-9">
			<input name="keyword" type="text" placeholder="時尚女裝 " class="keyword" style="
   			 border-right-width: 1px;
   			 margin-right: 0px;
   			 padding-right: -5;
   			 ">
			<button  type="submit" class="btn" style="
  			width: 58px;
  			padding-left: 10px;
  			border-left-width: 0px;
  			border-bottom-width: 0px;
  			border-top-width: 0px;
  			border-right-width: 0px;
  			height: 28px;
  			padding-top: 7px;
  			margin-top: 1px;
  			font-size: 12px;
  			">搜尋</button>
  			
			<div class="searchBelow">
				<c:forEach items="${cs}" var="c" varStatus="st">
					<c:if test="${st.count>=2 and st.count<=8}">
						<span>
							<a href="${pageContext.request.contextPath}/fore/category?categoryId=${c.categoryId}">
								${c.cname}
							</a>
							<c:if test="${st.count!=8}">				
								<span>|</span>				
							</c:if>
						</span>			
					</c:if>
				</c:forEach>		
			</div>
		</div>
	</form>	
</div>