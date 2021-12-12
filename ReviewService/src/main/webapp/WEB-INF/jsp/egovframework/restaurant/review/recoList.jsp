<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--사용자 리뷰 추천-->

<!--리뷰 추천 리스트-->
<ul class="recoReviewList">
	<!--리뷰 추천 1-->
	<li>
		<div class="card">
			<div class="card-body">
				<div class="card-title">
					<img src="<c:url value='/images/egovframework/review/profile.png'/>" alt="프로필 아이콘" width="80px">
					<div class="info_area">
						<p class="user_name">위승빈</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img src="<c:url value='/images/egovframework/review/like.png'/>" alt="좋아요" width="25px">
								<p class="like_count">45</p>
							</div>
						</div>
					</div>
				</div>
				<h6 class="card-subtitle mb-2 text-muted" style="text-align: left;">최고에요</h6>
			</div>
		</div>
	</li>
	<!--리뷰 추천 2-->
	<li>
		<div class="card">
			<div class="card-body">
				<div class="card-title">
					<img src="<c:url value='/images/egovframework/review/profile.png'/>" alt="프로필 아이콘" width="80px">
					<div class="info_area">
						<p class="user_name">위승빈</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img src="<c:url value='/images/egovframework/review/like.png'/>" alt="좋아요" width="25px">
								<p class="like_count">45</p>
							</div>
						</div>
					</div>
				</div>
				<h6 class="card-subtitle mb-2 text-muted" style="text-align: left;">최고에요</h6>
			</div>
		</div>
	</li>
	<!--리뷰 추천 3-->
	<li>
		<div class="card">
			<div class="card-body">
				<div class="card-title">
					<img src="<c:url value='/images/egovframework/review/profile.png'/>" alt="프로필 아이콘" width="80px">
					<div class="info_area">
						<p class="user_name">위승빈</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img src="<c:url value='/images/egovframework/review/like.png'/>" alt="좋아요" width="25px">
								<p class="like_count">45</p>
							</div>
						</div>
					</div>
				</div>
				<h6 class="card-subtitle mb-2 text-muted" style="text-align: left;">최고에요</h6>
			</div>
		</div>
	</li>
</ul>
