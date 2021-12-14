<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--사용자 리뷰 추천-->
 <script type="text/javascript" src="<c:url value='/js/review/like.js'/>"></script>
<script type="text/javaScript" language="javascript" defer="defer">

	<%--function searchReview() {--%>
	<%--	document.reviewForm.action = "<c:url value='/detailReview.do'/>";--%>
	<%--	document.reviewForm.submit();--%>
	<%--}--%>
</script>
<!--리뷰 추천 리스트-->
<ul class="recoReviewList">
	<!--리뷰 추천 1-->
	<li>
		<div class="card">
			<div class="card-body">
				<div class="card-title">
					<div class="profile_btn">
						<img
							src="<c:url value='/images/egovframework/review/profile.png'/>"
							alt="프로필 아이콘" width="80px">
						<div class="recommend_area" style="float:right; width:100%; text-align:right;">
							<form class="recommand_cancle" style="display:none;" action'>
	   							<div><input class="btn btn-primary" style="background-color:#ff7369; border-color:#ff7369;" id="write_btn" type="submit" value="추천 취소" /></div>
					    	</form>
<%--							<form name="reviewCeoRecoDeleteForm" class="recommand_btn" style="display:none;" action>--%>
<%--								<div>--%>

<%--									<input type="hidden" name="id" value="${result.id}" class="disable_input"/>--%>
<%--									<input type="hidden" name="title" value="${result.title}" class="disable_input"/>--%>
<%--									<input type="hidden" name="content" value="${result.content}" class="disable_input"/>--%>
<%--									<input type="hidden" name="star" value="${result.star}" class="disable_star"/>--%>
<%--									<input type="hidden" name="ceoReco" value="0" class="disable_star"/>--%>
<%--									<input class="btn btn-primary"--%>
<%--										   style="background-color:#ff7369; border-color:#ff7369;" id="write_btn"--%>
<%--										   type="submit" onclick="" value="리뷰 추천"/>--%>
<%--								</div>--%>
<%--							</form>--%>
							<form class="review_check" style="display:inline-block;"action='detailReview.do'>
	   							<div><input class="btn btn-primary" id="write_btn" type="submit" value="리뷰 보기" /></div>
								<input type="hidden" name="id" value="7"/>
					    	</form>
				    	</div>
					</div>
					<div class="info_area">
						<p class="user_name">reviewUser</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img
									src="<c:url value='/images/egovframework/review/like.png'/>"
									alt="좋아요" width="25px">
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
					<div class="profile_btn">
						<img
							src="<c:url value='/images/egovframework/review/profile.png'/>"
							alt="프로필 아이콘" width="80px">
						<div class="recommend_area" style="float:right; width:100%; text-align:right;">
							<form class="recommand_cancle" style="display:none;" action'>
	   							<div><input class="btn btn-primary" style="background-color:#ff7369; border-color:#ff7369;" id="write_btn" type="submit" value="추천 취소" /></div>
					    	</form>
							<form class="review_check" style="display:inline-block;"action='detailReview.do'>
	   							<div><input class="btn btn-primary" id="write_btn" type="submit" value="리뷰 보기" /></div>
								<input type="hidden" name="id" value="7"/>
					    	</form>
				    	</div>
					</div>
					<div class="info_area">
						<p class="user_name">reviewUser</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img
									src="<c:url value='/images/egovframework/review/like.png'/>"
									alt="좋아요" width="25px">
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
					<div class="profile_btn">
						<img
							src="<c:url value='/images/egovframework/review/profile.png'/>"
							alt="프로필 아이콘" width="80px">
						<div class="recommend_area" style="float:right; width:100%; text-align:right;">
							<form class="recommand_cancle" style="display:none;" action'>
	   							<div><input class="btn btn-primary" style="background-color:#ff7369; border-color:#ff7369;" id="write_btn" type="submit" value="추천 취소" /></div>
					    	</form>
							<form class="review_check" style="display:inline-block;"action='detailReview.do'>
	   							<div><input class="btn btn-primary" id="write_btn" type="submit" value="리뷰 보기" /></div>
								<input type="hidden" name="id" value="7"/>
					    	</form>
				    	</div>
					</div>
					<div class="info_area">
						<p class="user_name">reviewUser</p>
						<p class="date">21.11.20</p>
						<div class="star_like_area">
							<div class="star_area">
								<img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px"> <img
									src="<c:url value='/images/egovframework/review/star.png'/>"
									alt="별점" width="15px">
							</div>
							<div class="like_area">
								<img
									src="<c:url value='/images/egovframework/review/like.png'/>"
									alt="좋아요" width="25px">
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
