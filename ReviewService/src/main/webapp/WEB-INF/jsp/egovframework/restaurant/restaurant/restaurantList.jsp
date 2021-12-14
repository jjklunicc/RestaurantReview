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
<title>식당 리스트 페이지</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/restaurant/restaurantCategory.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/bootstrap.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/css/egovframework/main.css'/>" />
<script type="text/javaScript" language="javascript" defer="defer">
	function pageMove(restaurantID){
		location.href = "restaurantInformation.do?restaurantID=" + restaurantID
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
		<div class="restaurant-list">
			<!-- ngRepeat: restaurant in list -->
			<c:forEach var="restaurant" items="${lstRestaurant}"
				varStatus="status">
				<div class="col-sm-6 " ng-repeat="restaurant in list">
					<div class="item clearfix" onclick="pageMove(${restaurant.index})"
						style="cursor: pointer;">
						<table>
							<tbody>
								<tr>
									<td>
										<div class="restaurants-info">
											<div class="restaurant-name ng-binding"
												title="${restaurant.name}">${restaurant.name}</div>
											<div class="stars">
												<span> <span class="ico-star1 ng-binding">${ restaurant.address }</span>
												</span>
											</div>
											<ul>
												<li class="payment-methods ng-binding yogiseo-payment">
													>${ restaurant.business_hours }</li>
											</ul>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</c:forEach>
	</main>
	<footer class="footer text-center">
		<div class="container">
			<h4>융합 서비스 프로젝트</h4>
			<div class="text-center">Copyright &copy; BCU 2021</div>
		</div>
	</footer>
</body>
</html>