<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--별점 통계-->
<div>
	<h5 class="reviewContentTitle">
		별점 통계 <span class="badge badge-secondary">식당에 대한 평가 통계를 확인해보세요!</span>
	</h5>
	<div class="starStateBox">
		<div class="averageStarBox">
			<img src="<c:url value='/images/egovframework/review/star.png'/>" /> <strong>4.3</strong>
		</div>
		<div class="starStateContent">
			<div class="star_area">
				<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
			</div>
			<div class="progress">
				<div class="progress-bar bg-warning" role="progressbar"
					style="width: 15%" aria-valuenow="75" aria-valuemin="0"
					aria-valuemax="100"></div>
			</div>

			<div class="star_area">
				<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
			</div>
			<div class="progress">
				<div class="progress-bar bg-warning" role="progressbar"
					style="width: 20%" aria-valuenow="75" aria-valuemin="0"
					aria-valuemax="100"></div>
			</div>

			<div class="star_area">
				<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
			</div>
			<div class="progress">
				<div class="progress-bar bg-warning" role="progressbar"
					style="width: 50%" aria-valuenow="75" aria-valuemin="0"
					aria-valuemax="100"></div>
			</div>

			<div class="star_area">
				<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
			</div>
			<div class="progress">
				<div class="progress-bar bg-warning" role="progressbar"
					style="width: 90%" aria-valuenow="75" aria-valuemin="0"
					aria-valuemax="100"></div>
			</div>

			<div class="star_area">
				<img src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px"> <img
					src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점" width="15px">
			</div>
			<div class="progress">
				<div class="progress-bar bg-warning" role="progressbar"
					style="width: 75%" aria-valuenow="75" aria-valuemin="0"
					aria-valuemax="100"></div>
			</div>
		</div>
	</div>
</div>