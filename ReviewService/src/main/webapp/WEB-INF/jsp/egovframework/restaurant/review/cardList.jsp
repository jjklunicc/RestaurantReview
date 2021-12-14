<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script type="text/javascript" src="<c:url value='/js/review/like.js'/>"></script>
<script type="text/javaScript" language="javascript" defer="defer">
    function updateReview() {
        document.reviewCeoRecoForm.action = "<c:url value='/updateReview.do'/>";
        document.reviewCeoRecoForm.submit();
    }
</script>
<div class="card_container">
    <div class="card-col">

        <c:forEach var="result" items="${resultList}" varStatus="status">
            <div id="card${result.id}" class="card_width">
                <div class="card">
                    <div class="card-body">
                        <div class="card-title">
                            <img src="<c:url value='/images/egovframework/review/profile.png'/>" alt="프로필 아이콘"
                                 width="80px">
                            <div class="info_area">
                                <p class="user_name">${result.userId}</p>
                                <p class="date">${result.createDate}</p>
                                <div class="star_like_area">
                                    <div class="star_area">
                                        <div class="star_like_area">
                                            <div id="starArea${result.id}" class="star_area">
                                                <img class="unclick_star"
                                                     src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                                     alt="별점" width="15px">
                                                <img class="click_star"
                                                     src="<c:url value='/images/egovframework/review/star.png'/>"
                                                     alt="별점"
                                                     width="15px">
                                                <img class="unclick_star"
                                                     src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                                     alt="별점" width="15px">
                                                <img class="click_star"
                                                     src="<c:url value='/images/egovframework/review/star.png'/>"
                                                     alt="별점"
                                                     width="15px">
                                                <img class="unclick_star"
                                                     src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                                     alt="별점" width="15px">
                                                <img class="click_star"
                                                     src="<c:url value='/images/egovframework/review/star.png'/>"
                                                     alt="별점"
                                                     width="15px">
                                                <img class="unclick_star"
                                                     src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                                     alt="별점" width="15px">
                                                <img class="click_star"
                                                     src="<c:url value='/images/egovframework/review/star.png'/>"
                                                     alt="별점"
                                                     width="15px">
                                                <img class="unclick_star"
                                                     src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                                     alt="별점" width="15px">
                                                <img class="click_star"
                                                     src="<c:url value='/images/egovframework/review/star.png'/>"
                                                     alt="별점"
                                                     width="15px">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="like_area">
                                        <img src="<c:url value='/images/egovframework/review/like.png'/>" alt="좋아요"
                                             width="25px">
                                        <p class="like_count">45</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div>
                            <h6 class="card-subtitle mb-2 text-muted" style="text-align: left;">${result.title}</h6>
                            <div class="recommend_area" style="float:right; width:100%; text-align:right;">
                                <form name="reviewCeoRecoForm" class="recommand_btn" style="display:none;" action>
                                    <div>

                                        <input type="hidden" name="id" value="${result.id}" class="disable_input"/>
                                        <input type="hidden" name="title" value="${result.title}" class="disable_input"/>
                                        <input type="hidden" name="content" value="${result.content}" class="disable_input"/>
                                        <input type="hidden" name="star" value="${result.star}" class="disable_star"/>
                                        <input type="hidden" name="ceoReco" value="1" class="disable_star"/>
                                        <input class="btn btn-primary"
                                               style="background-color:#ff7369; border-color:#ff7369;" id="write_btn"
                                               type="submit" onclick="" value="리뷰 추천"/>
                                    </div>
                                </form>
                                <form class="review_check" style="display:inline-block;" action='detailReview.do'>
                                    <div><input class="btn btn-primary" style="float:right;" id="write_btn"
                                                type="submit" value="리뷰 보기"/></div>
                                    <input type="hidden" name="id" value="${result.id}"/>
                                </form>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
        <script type="text/javascript">
            function starDisplay(starNum, starAreaId) {
                const unstarElemets = starAreaId.getElementsByClassName("unclick_star");
                for (let i = starNum; i < unstarElemets.length; i++) {
                    unstarElemets[i].style.display = "inline-block";
                }
                const starElements = starAreaId.getElementsByClassName("click_star");
                for (let i = 0; i < starNum; i++) {
                    starElements[i].style.display = "inline-block";
                }
            }

            <c:forEach var="result" items="${resultList}" varStatus="status">
            starDisplay(${result.star}, document.getElementById("starArea" + ${result.id}));
            </c:forEach>
        </script>


    </div>
</div>