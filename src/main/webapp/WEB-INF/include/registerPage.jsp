<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<script>
$(function(){
	
	<c:if test="${!empty msg}">
	$("span.errorMessage").html("${msg}");
	$("div.registerErrorMessageDiv").css("visibility","visible");		
	</c:if>
	
	$(".registerForm").submit(function(){
		if(0==$("#name").val().length){
			$("span.errorMessage").html("請輸入用戶名稱");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#password").val().length){
			$("span.errorMessage").html("請輸入用戶密碼");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if(0==$("#repeatpassword").val().length){
			$("span.errorMessage").html("請再次輸入密碼");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		
		if($("#password").val() !=$("#repeatpassword").val()){
			$("span.errorMessage").html("密碼不一致");
			$("div.registerErrorMessageDiv").css("visibility","visible");			
			return false;
		}		

		return true;
	});
})
</script>

<img id="loginBackgroundImg" class="loginBackgroundImg" src="${pageContext.request.contextPath}/img/site/loginBackground.png" style="
    width: 1263px;height: 500px;">

<form  method="post" action="${pageContext.request.contextPath}/fore/register" class="registerForm">

<div class="registerDiv">
	<div class="registerErrorMessageDiv">
		<div class="alert alert-danger" role="alert">
		  <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
		  	<span class="errorMessage"></span>
		</div>		
	</div>

	
	<table class="registerTable" align="center">
		<tr>
			<td  class="registerTip registerTableLeftTD">會員名稱</td>
			<td></td>
		</tr>
		<tr>
			<td class="registerTableLeftTD">登入名稱</td>
			<td  class="registerTableRightTD"><input id="name" name="mname" placeholder="設置會員名" > </td>
		</tr>
		<tr>
			<td  class="registerTip registerTableLeftTD">登入密碼</td>
		</tr>		
		<tr>
			<td class="registerTableLeftTD">登入密碼</td>
			<td class="registerTableRightTD"><input id="password" name="password" type="password"  placeholder="設置你的登入密碼" > </td>
		</tr>
		<tr>
			<td class="registerTableLeftTD">密碼確認</td>
			<td class="registerTableRightTD"><input id="repeatpassword" type="password"   placeholder="請再次輸入密碼" > </td>
		</tr>
				
		<tr>
			<td colspan="2" class="registerButtonTD">
				<button Style="background-color:black;color:white;" class="btn btn-block blackbtn" type="submit">提交</button>
			</td>
		</tr>				
	</table>
</div>
</form>