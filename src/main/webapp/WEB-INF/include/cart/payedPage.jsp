<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
	
<div class="payedDiv">
	<div class="payedTextDiv">
		<img src="${pageContext.request.contextPath}/img/site/paySuccess.png">
		<span>你已成功付款</span> 
		
	</div>
	<div class="payedAddressInfo">
		<ul>
			<li>收貨地址：${o.address} ${o.receiver} ${o.mobile }</li>
			<li>實付：<span class="payedInfoPrice">
			NT$<fmt:formatNumber type="number" value="${param.total}" />元
			</li>
			<li>預計七日內送達</li>
		</ul>
				
		<div class="paedCheckLinkDiv">
			你可以
			<a class="payedCheckLink" href="${pageContext.request.contextPath}/fore/bought">查看已購買商品</a>
			<a class="payedCheckLink" href="${pageContext.request.contextPath}/fore/bought">查看交易詳情 </a>
		</div>
			
	</div>
	
	<div class="payedSeperateLine">
	</div>
	
	<div class="warningDiv">
		<img src="${pageContext.request.contextPath}/img/site/warning.png">
		<b>安全提醒：</b>下單後，<span class="redColor boldWord"></span>嚴防假冒客服電話詐騙！
	</div>

	

</div>