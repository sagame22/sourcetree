<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<script>
//登陸的ajax
$(function(){
	function login(){
		var name = $("#name").val();
		var password = $("#passwordModal").val();
		
		if(0==name.length||0==password.length){
			$("span.errorMessage").html("請輸入帳號密碼");
			$("div.loginErrorMessageDiv").show();			
			return false;
		}
		var page = "${pageContext.request.contextPath}/fore/loginAjax";
		$.get(
	            page,
	            {"mname":name,"password":password},
	            function(result){
	            	if("success"==result){
	            		location.reload();
	            	}
	            	else{
	            		$("span.errorMessage").html("帳號密碼錯誤");
	            		$("div.loginErrorMessageDiv").show();	            		
	            	}
	            }
		);			
		return true;
	}
	
 $("#passwordModal").keypress(function (e){
	if(e.which==13)
		login();
	})
$("button.loginSubmitButton").click(login);

});
</script>
<div class="modal " id="loginModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog loginDivInProductPageModalDiv">
	        <div class="modal-content">
					<div class="loginDivInProductPage">
						<div class="loginErrorMessageDiv">
							<div class="alert alert-danger" >
							  <button type="button" class="close" data-dismiss="alert" aria-label="Close"></button>
							  	<span class="errorMessage"></span>
							</div>
						</div>
							
						<div class="login_acount_text">帳號登入</div>
						<div class="loginInput " >
							<span class="loginInputIcon ">
								<span class=" glyphicon glyphicon-user"></span>
							</span>
							<input id="name" name="name" placeholder="會員名稱/郵件" type="text">			
						</div>
						
						<div class="loginInput " >
							<span class="loginInputIcon ">
								<span class=" glyphicon glyphicon-lock"></span>
							</span>
							<input id="passwordModal" name="password"  type="password" placeholder="密碼" type="text">			
						</div>
									<span class="text-danger"></span><br><br>
						<div>
							<a href="#nowhere">忘記密碼</a> 
							<a href="${pageContext.request.contextPath}/frontpage/register.jsp" class="pull-right">免費註冊</a> 
						</div>
						<div style="margin-top:20px">
							<button class="btn btn-block loginSubmitButton" type="submit">登入</button>
						</div>
					</div>	
	      </div>
	</div>
</div>

<!-- 刪除的model -->
<div class="modal" id="deleteConfirmModal" tabindex="-1" role="dialog" >
	<div class="modal-dialog deleteConfirmModalDiv">
       <div class="modal-content">
          <div class="modal-header">
            <button data-dismiss="modal" class="close" type="button"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h4 class="modal-title">確認刪除?</h4>
          </div>
          <div class="modal-footer">
            <button data-dismiss="modal" class="btn btn-default" type="button">關閉</button>
            <button class="btn btn-primary deleteConfirmButton" id="submit" type="button">確認</button>
          </div>
        </div>
      </div>
	</div>
</div>