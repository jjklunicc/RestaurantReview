<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!--메뉴 추천 순위-->
<div>
	<h5 class="reviewContentTitle">
		메뉴 추천 순위 <span class="badge badge-secondary">식당에서 가장 인기 많은
			Best3</span>
	</h5>
	<ol class="recoMenuList">
		<li><strong class="badge-pill badge-primary">1위 메뉴</strong>
			<div class="img-thumbnail">
				<img src="<c:url value='/images/egovframework/review/menu1.jpeg'/>" /> <span>반반 치킨</span>
			</div></li>
		<li><strong class="badge-pill badge-primary">2위 메뉴</strong>
			<div class="img-thumbnail">
				<img src="<c:url value='/images/egovframework/review/menu2.jpeg'/>"  /> <span>핫 크리스피 치킨</span>
			</div></li>
		<li><strong class="badge-pill badge-primary">3위 메뉴</strong>
			<div class="img-thumbnail">
				<img src="<c:url value='/images/egovframework/review/menu3.jpeg'/>" /> <span>황금 올리브유 치킨</span>
			</div></li>
	</ol>
</div>