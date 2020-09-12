<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<script>
$(function(){
	
	<c:if test="${!empty msg}">
	$("span.errorMessage").html("${msg}");
	$("div.loginErrorMessageDiv").show();		
	</c:if>
	
	$("form.loginForm").submit(function(){
		if(0==$("#name").val().length||0==$("#password").val().length){
			$("span.errorMessage").html("請輸入帳號密碼");
			$("div.loginErrorMessageDiv").show();			
			return false;
		}
		return true;
	});
	
	$("form.loginForm input").keyup(function(){
		$("div.loginErrorMessageDiv").hide();	
	});
	
	
	
	
})
</script>


<div id="loginDiv" style="position: relative">

 	<%-- <div class="simpleLogo">
		<a href="${pageContext.request.contextPath}/index_f.jsp"><img src="${pageContext.request.contextPath}/img/site/simpleLogo.png" style="
    width: 150px;"></a>
	</div>  --%>

	
	 <img id="loginBackgroundImg" class="loginBackgroundImg" src="${pageContext.request.contextPath}/img/site/loginBackground.png" style="
    width: 1263px;height: 500px;">
	 
	<form class="loginForm" action="${pageContext.request.contextPath}/fore/login" method="post">
		<div id="loginSmallDiv" class="loginSmallDiv">
			<div class="loginErrorMessageDiv">
				<div class="alert alert-danger" >
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
				  	<span class="errorMessage"></span>
				</div>
			</div>
				
			<div class="login_acount_text">會員登入</div>
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-user"></span>
				</span>
				<input id="name" name="mname" placeholder="會員名稱/郵件" type="text">			
			</div>
			
			<div class="loginInput " >
				<span class="loginInputIcon ">
					<span class=" glyphicon glyphicon-lock"></span>
				</span>
				<input id="password" name="password" type="password" placeholder="密碼" type="text">
			</div>
			
			
			
			<div>
				<a Style="color:black;" class="notImplementLink" href="#nowhere">忘記密碼</a> 
				<a Style="color:black;" href="${pageContext.request.contextPath}/frontpage/register.jsp" class="pull-right">免費註冊</a> 
			</div>
			<div calss ="subbtn" style="margin-top:20px">
				<button Style="background-color:black;color:white;" class="btn btn-block blackbtn " type="submit">登入</button>
			</div>
		</div>	
	</form>


</div>	