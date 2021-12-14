<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>식당 상세 페이지</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/restaurant/restaurantCategory.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/bootstrap.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/main.css'/>" />
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javaScript" language="javascript" defer="defer">
	let totalPrice = 0
	let selectMenuList = []

	function selectMenu() {
		document.getElementById("menuTab").classList.add("active");
		document.getElementById("infoTab").classList.remove("active");

		document.getElementById("menu").style = "display:block;"
		document.getElementById("info").style = "display:none;"
	}

	function selectInfo() {
		document.getElementById("menuTab").classList.remove("active");
		document.getElementById("infoTab").classList.add("active");

		document.getElementById("menu").style = "display:none;"
		document.getElementById("info").style = "display:block;"
	}
	
	function insertMenu(name, price, menuIndex, restaurant_index){
		let menuVO = {}
		menuVO.menuIndex = menuIndex;
		menuVO.restaurant_index = restaurant_index;
		menuVO.name = name;
		menuVO.price = price;
		
		selectMenuList.push(menuVO);
		
		totalPrice += price;
		document.getElementById("cart-empty").style = "display:none;";
		
		let liNode = document.createElement("li")
		liNode.classList.add("list-group-item");
		liNode.classList.add("ng-scope");
		liNode.classList.add("clearfix"); 
		
		liNode.innerHTML  += "<div class='row'>";
		liNode.innerHTML  += "<div class='menu-name ng-binding'>" + name + "</div>";
		liNode.innerHTML  += "<div>";
		liNode.innerHTML  += "<div class='col-xs-6 pull-left'>";
		liNode.innerHTML  += "<a class='btn btn-del-menu'>삭제</a>";
		liNode.innerHTML  += "<span class='order-price ng-binding'>" + price + "원 </span>";
		liNode.innerHTML  += "</div>";
		liNode.innerHTML  += "<div class='col-xs-6 text-right'>";
		liNode.innerHTML  += "<a class='btn btn-minus'></a>"; 
		liNode.innerHTML  += "<span class='order-num ng-binding' name='num'>1 개</span> <a class='btn btn-plus'></a>";	
		liNode.innerHTML  += "</div>";
		liNode.innerHTML  += "</div>";
		liNode.innerHTML  += "</div>";

		document.getElementById("selectMenuList").appendChild(liNode);
		
		document.getElementById("totalPrice").innerHTML = "합계 : " + totalPrice + "원"
	}
	
	function orderInput(){
		selectMenuList.forEach(menuVO => {
			$.ajax({
	            method: "POST",
	            url: "/ReviewService/insertForwardingMenu.do",
	            async: false,
	            data: {
	            	user_index: 11,
	            	restaurantID: menuVO.restaurant_index,
	            	menu_index: menuVO.menuIndex,
	            	count: 1,
	            },
	            success: (response) => {
	            	location.href = "orderList.do";
	            },
	            error: () => {
	                console.log("Error")
	            },
	        });
		})
	}
</script>
</head>
<body>
	<header class="header text-uppercase header-main-text" id="mainHeader">
		<div class="container header-main-text">
			<div>Restaurant Review</div>
		</div>
	</header>
	<main class="container">
		<div class="restaurant-detail row ng-scope">

			<div class="col-sm-8">
				<div class="restaurant-info">
					<div class="restaurant-title">
						<span class="restaurant-name ng-binding">${ restaurantVO.name }</span>
					</div>
					<div class="restaurant-content">
						<div class="logo"
							style="background-image: url(&quot;/media/restaurant_logos/DHK촬영_20210806_427121_인생아구찜_대표사진_300x300.jpg&quot;), url(&quot;image/default_restaurant_logo.png&quot;);"></div>
						<ul class="list">
							<li class="">결제 <span class="ico-payment-yogiyo">신용카드</span>
								<span class=""> , </span> <span class="ico-payment-yogiyo">현금</span>
								<span class=""></li>
							<li class="delivery-time-tooltip">영업시간 <span
								class="ng-binding"> ${ restaurantVO.business_hours } </span>
							</li>
							<li class="disposable-menu-tooltip ng-hide">일회용품 <span>일회용품
									무상 제공 </span>
							</li>
						</ul>
					</div>

					<div class="clearfix"></div>
				</div>
				<div class="owner_intro_message">
					<strong>설명</strong> <span class="tc ng-binding">${ restaurantVO.description }</span>
				</div>

				<div id="banner_11st" class="banner_11st"></div>

				<ul class="nav nav-tabs restaurant-tab">
					<li onclick="selectMenu()" id="menuTab" class="active"><a>메뉴
					</a></li>
					<li onclick="selectInfo()" id="infoTab"><a>정보</a></li>
				</ul>

				<div id="menu" class="menu-list">
					<div
						class="panel-group ng-untouched ng-valid ng-dirty ng-valid-parse">
						<div class="panel panel-default ng-scope">
							<div class="panel-heading">
								<h4 class="panel-title ng-hide">
									<a class="clearfix"> <span
										class="menu-name pull-left ng-binding">Menu Items</span> <i
										class="pull-right"></i>
									</a>
								</h4>
							</div>
							<div class="panel-collapse collapse in btn-scroll-container">
								<div class="panel-body photo-menu-container">
									<div class="category-desc ng-binding ng-hide"></div>
									<ul class="sub-list ng-hide">
										<c:forEach var="menu" items="${lstMenuVO}" varStatus="status">
											<li class="ng-scope photo-menu"
												onclick="insertMenu('${menu.menu_name }' , ${ menu.price }, ${ menu.index }, ${ menu.restaurant_index })">
												<table>
													<tbody>
														<tr>
															<td class="menu-text">
																<div class="menu-name ng-binding">${ menu.menu_name }</div>
																<div class="menu-desc ng-binding">${ menu.menu_info }</div>
																<div class="menu-price">
																	<span class="color-price ng-binding ng-hide">가격
																		: ${ menu.price } 원</span>
																</div>
															</td>
															<td class="photo-area">
																<div class="photo"
																	style="background-image: url(&#39;https://images.yogiyo.co.kr/image/yogiyo/PHOTOGRAPHER_IMG/%EA%B2%BD%EA%B8%B0/%EA%B2%BD%EA%B8%B0%EB%B6%80%EC%B2%9C%EC%8B%9C/427121_%EC%9D%B8%EC%83%9D%EC%95%84%EA%B5%AC%EC%B0%9C/DHK%EC%B4%AC%EC%98%81_20210806_427121_%EC%9D%B8%EC%83%9D%EC%95%84%EA%B5%AC%EC%B0%9C_%EC%95%8C%EC%B0%9C_1080x640.jpg?width=384&amp;height=273&amp;quality=100&#39;), url(&#39;image/ic_photomenu_default.png&#39;);"></div>
															</td>
														</tr>
													</tbody>
												</table>
											</li>
										</c:forEach>

									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>

				<div id="info" class="info-list ng-hide" style="display: none;">
					<div class="info-item">
						<div class="info-item-title info-icon">사장님알림</div>
						<div class="info-text ng-binding">${ restaurantVO.description }
						</div>
					</div>

					<div class="info-item">
						<div class="info-item-title info-icon1">업체정보</div>
						<p>
							<i>영업시간</i> <span class="tc ng-binding">${ restaurantVO.business_hours }</span>
						</p>
						<p class="ng-hide">
							<i>전화번호</i> <span class="tc ng-binding">${ restaurantVO.phone_number }</span>
						</p>
						<p class="">
							<i>주소</i> <span class="tc ng-binding">${ restaurantVO.address }</span>
						</p>
						<p class="">
							<i>부가정보</i> <span class="cesco info-icon5 tc">세스코멤버스 사업장</span>
						</p>
					</div>

					<div class="info-item">
						<div class="info-item-title info-icon2">결제정보</div>
						<p>
							<i>결제수단</i> <span class="tc"><span
								class="ico-payment-yogiyo">신용카드</span> <span class=""> ,
							</span> <span class="ico-payment-yogiyo">현금</span>
						</p>
					</div>

					<div class="info-item">
						<div class="info-item-title info-icon3">사업자정보</div>
						<p>
							<i>상호명</i> <span class="tc ng-binding">${ restaurantVO.name }</span>
						</p>
						<p>
							<i>사업자등록번호</i> <span class="tc ng-binding">${ restaurantVO.business_number }</span>
						</p>
					</div>

					<div class="info-item">
						<div class="info-item-title info-icon4">원산지정보</div>
						<p></p>
						<pre class="ng-binding">쌀 (국내산)</pre>
						<p></p>
					</div>

					<div class="info-item food-safety ng-hide">
						<div class="info-item-title info-icon6">위반사항</div>
						<ul class="list">
						</ul>
						<ul class="list1">
							<li>* 3개월 이내 식약처에 기재된 행정처분 정보를 제공합니다.</li>
							<li class="ng-binding ng-hide"></li>
						</ul>
					</div>
				</div>

				<div class="labels">
					<a class="">원산지 정보</a> <a rel="noopener noreferrer" target="_blank"
						class="ng-hide">영양성분 정보</a> <a rel="noopener noreferrer"
						target="_blank" class="ng-hide">알레르기 유발 정보</a>
				</div>
			</div>

			<div class="col-sm-4 hidden-xs restaurant-cart"
				style="top: 0px; position: relative;">
				<div class="">
					<div class="sub-title">
						<span>주문표</span> <a class="ng-hide"> <span class="ico-clear"></span>
						</a>
					</div>
					<div class="cart">
						<div class="restaurant-name ng-hide">
							<a class="ng-binding"></a>
						</div>
						<ul class="list-group" id="selectMenuList">
						</ul>

						<div class="cart-empty" id="cart-empty">주문표에 담긴 메뉴가 없습니다.</div>

						<div class="clearfix">
							<span id="totalPrice"
								class="list-group-item cart-total-order-price ng-binding ng-hide">
								합계: 0원 </span>
						</div>

						<div class="cart-btn clearfix">
							<a class="btn btn-lg btn-ygy1 btn-block" id="orderButton"
								onclick="orderInput()">주문하기</a>
						</div>
					</div>
				</div>

				</ng-include>
			</div>
		</div>
	</main>
	<footer class="footer text-center">
		<div class="container">
			<h4>융합 서비스 프로젝트</h4>
			<div class="text-center">Copyright &copy; BCU 2021</div>
		</div>
	</footer>
</body>
</html>