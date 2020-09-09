<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>


<script>
$(function(){
	/*判斷庫存和購買數量是否足夠*/
	var stock = ${p.stock};
	$(".productNumberSetting").keyup(function(){
		var num= $(".productNumberSetting").val();
		num = parseInt(num);
		if(isNaN(num))
			num= 1;
		if(num<=0)
			num = 1;
		if(num>stock)
			num = stock;
		$(".productNumberSetting").val(num);
	});
	
	$(".increaseNumber").click(function(){
		var num= $(".productNumberSetting").val();
		num++;
		if(num>stock)
			num = stock;
		$(".productNumberSetting").val(num);
	});
	$(".decreaseNumber").click(function(){
		var num= $(".productNumberSetting").val();
		--num;
		if(num<=0)
			num=1;
		$(".productNumberSetting").val(num);
	});
	/*點擊加入購物車確認是否登陸*/
	$(".addCartLink").click(function(){
		var page = "${pageContext.request.contextPath}/fore/checkLogin";
		$.get(
	            page,
	            function(result){
	            	if("success"==result){
	            		var pid = ${p.productId};
	            		var num= $(".productNumberSetting").val();
	            		var addCartpage = "${pageContext.request.contextPath}/fore/addCart";
	            		$.get(
	            				addCartpage,
	            	            {"pid":pid,"num":num},
	            	            function(result){
	            	            	if("success"==result){
	            	            		$(".addCartButton").html("已加入購物車");
	            	            		$(".addCartButton").attr("disabled","disabled");
	            	            		$(".addCartButton").css("background-color","lightgray")
	            	            		$(".addCartButton").css("border-color","lightgray")
	            	            		$(".addCartButton").css("color","black")
	            	            		
	            	            	}
	            	            	else{
	            	            		
	            	            	}
	            	            }
	            		);		            		
	            	}
	            	else{
						$("#loginModal").modal('show');	            		
	            	}
	            }
		);		
		return false;
	});
	//點擊購買進行確認是否登陸
	$(".buyLink").click(function(){
		var page = "${pageContext.request.contextPath}/fore/checkLogin";
		$.get(
	            page,
	            function(result){
	            	if("success"==result){
	            		var num = $(".productNumberSetting").val();
	            		location.href= $(".buyLink").attr("href")+"&num="+num;
	            	}
	            	else{
						$("#loginModal").modal('show');	            		
	            	}
	            }
		);		
		return false;
	});
	
	
	$("img.smallImage").mouseenter(function(){
		var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
	});
	
	$("img.bigImg").load(
		function(){
			$("img.smallImage").each(function(){
				var bigImageURL = $(this).attr("bigImageURL");
				img = new Image();
				img.src = bigImageURL;
				
				img.onload = function(){
					console.log(bigImageURL);	
					$("div.img4load").append($(img));
				};
			});		
		}
	);
	
	
	
	/*倒數計時*/
	var inputTime = new Date('2020-10-10 18:00:00');
	countDown();
	setInterval(countDown,1000);
	function countDown(){
		var nowTime =new Date();
		var times = (inputTime-nowTime)/1000;
		var d=parseInt(times/60/60/24);
		d=d<10 ? '0'+d : d;
		$(".days").html(d);
		var h=parseInt(times/60/60%24);
		h=h<10 ? '0'+h : h;
		$(".hours").html(h);
		var m=parseInt(times/60%60);
		m=m<10 ? '0'+m : m;
		$(".mins").html(m)
		var s=parseInt(times%60);
		s=s<10 ? '0'+s : s;
		$(".seconds").html(s);
	}
	
});

</script>

	
<div class="imgAndInfo">

	<div class="imgInimgAndInfo">
		<img src="${pageContext.request.contextPath}/img/productSingle/${p.firstProductImage.imageId}.jpg" class="bigImg">
		<div class="smallImageDiv">
			<c:forEach items="${p.productSingleImages}" var="pi">
				<img src="${pageContext.request.contextPath}/img/productSingle_small/${pi.imageId}.jpg" bigImageURL="${pageContext.request.contextPath}/img/productSingle/${pi.imageId}.jpg" class="smallImage">
			</c:forEach>
		</div>
		<div class="img4load hidden" ></div>
	</div>
	
	<div class="infoInimgAndInfo">
		
		<div class="productTitle">
			${p.pname}
		</div>
		<div class="productSubTitle">
			${p.subTitle} 
		</div>
		
		<div class="productPrice">
			<div class="juhuasuan">
				<span class="juhuasuanBig" >促銷價</span>
				<span>
				<span class="days"></span>天
				<span class="hours"></span>時
				<span class="mins"></span>分
				<span class="seconds"></span>秒
				後結束</span>
			</div>
			<div class="productPriceDiv">
				<div class="gouwujuanDiv">
				
				</div>
				<div class="originalDiv">
					<span class="originalPriceDesc">價格</span>
					<span class="originalPriceYuan">NT$</span>
					<span class="originalPrice">
					
						<fmt:formatNumber type="number" value="${p.orignalPrice}" minFractionDigits="2"/>					
					</span>
				</div>
				<div class="promotionDiv">
					<span class="promotionPriceDesc">促銷價 </span>
					<span class="promotionPriceYuan">$</span>
					<span class="promotionPrice">
						<fmt:formatNumber type="number" value="${p.promotePrice}" minFractionDigits="2"/>
					</span>				
				</div>
			</div>
		</div>
		<div class="productSaleAndReviewNumber">
			<div>銷量 <span class="redColor boldWord"> ${p.saleCount }</span></div>	
			<div>累計評價 <span class="redColor boldWord"> ${p.reviewCount}</span></div>	
		</div>
		<div class="productNumber">
			<span>數量</span>
			<span>
				<span class="productNumberSettingSpan">
				<input class="productNumberSetting" type="text" value="1">
				</span>
				<span class="arrow">
					<a href="#nowhere" class="increaseNumber">
					<span class="updown">
						<img src="${pageContext.request.contextPath}/img/site/increase.png"> 
					</span>
					</a>
					
					<span class="updownMiddle"> </span>
					<a href="#nowhere"  class="decreaseNumber">
					<span class="updown">
							 <img src="${pageContext.request.contextPath}/img/site/decrease.png">  
					</span>
					</a>
					
				</span>
					
			件</span>
			<span>庫存${p.stock}件</span>
		</div>
		<div class="serviceCommitment">
			<span class="serviceCommitmentDesc">服務承諾</span>
			<span class="serviceCommitmentLink">
				<a href="#nowhere">正品保證</a>
				<a href="#nowhere">快速退貨</a>
				<a href="#nowhere">七天無條件退貨</a>
			</span>
		</div>	
		
		<div class="buyDiv">
			<a class="buyLink" href="${pageContext.request.contextPath}/fore/buyone?pid=${p.productId}"><button class="buyButton">立即購買</button></a>
			<a href="#nowhere" class="addCartLink"><button class="addCartButton"><span class="glyphicon glyphicon-shopping-cart"></span>加入購物車</button></a>
		</div>
	</div>
	


	<div style="clear:both"></div>
	
</div>

