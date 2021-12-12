<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>리뷰 메인</title>
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
	<script type="text/javaScript" language="javascript" defer="defer">
	    function searchReview() {
		    	document.reviewForm.action = "<c:url value='/detailReview.do'/>";
		    	document.reviewForm.submit();
	    }
	</script>
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/review/reset.css'/>" />
	<link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/review/main.css'/>" />
	<link rel="stylesheet"
		  href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<header class="header text-uppercase header-main-text" id="mainHeader">
   <div class="container header-main-text">
     <div>Restaurant Review</div>
   </div>
 </header>
<main class="container page-section-review">
	<div class="reviewMain">
		<div class="reviewMainTopBox">

			<div class="reviewRecoBox">
				<!--제목-->
				<div class="review_area">
					<h5 class="reviewContentTitle">
					사용자 리뷰 추천 <span class="badge badge-secondary">사장님이 추천하는 리뷰!
						식당의 주력 상품을 확인해보세요!</span>
					</h5>
					<div class="write_btn_area">
    					<form action='addReview.do'>
   							<div><input class="btn btn-primary" style="float:right; margin-right:20px;" id="write_btn" type="submit" value="글 작성"/></div>
   						</form>
					</div>
				</div>
				<jsp:include page="recoList.jsp" />
				<!--사용자 리뷰 추천-->
			</div>
			<!--별점 통계 및 메뉴 추천 순위-->
			<div class="recoStateBox">
				<jsp:include page="starStat.jsp" />
				<!--별점 통계 및 메뉴 추천 순위-->

				<jsp:include page="menuStat.jsp" />
				<!--메뉴 추천 순위-->
			</div>

		</div>
		<!--사용자 리뷰 리스트-->
		<div>
			<div class="reviewListTopBox">
				<h5 class="reviewContentTitle">
					사용자 리뷰 리스트 <span class="badge badge-secondary">사용자들의 리뷰를
						확인하세요.</span>
				</h5>
				<jsp:include page="sort.jsp" />
				<!--정렬-->

			</div>
			<jsp:include page="cardList.jsp" />
			<!--리뷰카드 리스트-->
		</div>
	</div>
</main>
<footer class="footer text-center">
	<div class="container">
		<h4>융합 서비스 프로젝트</h4>
		<div class="text-center">
			Copyright &copy; BCU 2021
		</div>
	</div>
</footer>
</body>
</html>
