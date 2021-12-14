<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>리뷰 조회</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">
        function check(str) {
            if (str.value == ''
                || str.value == null
                || str.value.replace(/^\s+|\s+$/g, '') == ""
                || /[\s]/g.test(str.value) == true) {
                alert('입력이 올바르지 않습니다.');
                return false;
            }

            return true;
        }

        function updateReview() {
            const checkTitle = check(document.reviewUpdateForm["title"]);
            let checkContent = false;
            if (checkTitle) {
                checkContent = check(document.reviewUpdateForm["content"]);
            }
            if (checkTitle && checkContent) {
                document.reviewUpdateForm.action = "<c:url value='/updateReview.do'/>";
                document.reviewUpdateForm.submit();
            }
        }

        function deleteReview() {
            document.reviewUpdateForm.action = "<c:url value='/deleteReview.do'/>";
            document.reviewUpdateForm.submit();
        }

        function addReviewComment() {
            document.reviewCommentForm.action = "<c:url value='/addReviewComment.do'/>";
            document.reviewCommentForm.submit();
        }

        function updateReviewComment() {
            document.reviewCommentForm.action = "<c:url value='/updateReviewComment.do'/>";
            document.reviewCommentForm.submit();
        }

        function deleteReviewComment() {
            document.reviewCommentForm.action = "<c:url value='/deleteReviewComment.do'/>";
            document.reviewCommentForm.submit();
        }
    </script>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/css/egovframework/review/reset.css'/>"/>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/css/egovframework/review/detail.css'/>"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
            integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
            crossorigin="anonymous"></script>
    <script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
            integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="<c:url value='/js/review/like.js'/>"></script>
</head>
<body>
<header class="header text-uppercase header-main-text" id="mainHeader">
    <div class="container header-main-text">
        <div>Restaurant Review</div>
    </div>
</header>

<body>
<div class="review_detail_container">
    <p class="review_write">리뷰조회</p>
    <section class="review_detail">
        <div class="recoReviewList">
            <div class="card">
                <div class="card-body" style="display: inline-block;">
                    <div class="card-title"><img width="80px"
                                                 src="<c:url value='/images/egovframework/review/profile.png'/>">
                        <div class="info_area">
                            <p class="user_name">${reviewVO.userId}</p>
                            <p class="date">${reviewVO.createDate}</p>
                            <div class="star_like_area">
                                <div id="starArea" class="star_area">
                                    <img class="unclick_star"
                                         src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                         alt="별점" width="15px">
                                    <img class="click_star"
                                         src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점"
                                         width="15px">
                                    <img class="unclick_star"
                                         src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                         alt="별점" width="15px">
                                    <img class="click_star"
                                         src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점"
                                         width="15px">
                                    <img class="unclick_star"
                                         src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                         alt="별점" width="15px">
                                    <img class="click_star"
                                         src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점"
                                         width="15px">
                                    <img class="unclick_star"
                                         src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                         alt="별점" width="15px">
                                    <img class="click_star"
                                         src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점"
                                         width="15px">
                                    <img class="unclick_star"
                                         src="<c:url value='/images/egovframework/review/unclick_star.png'/>"
                                         alt="별점" width="15px">
                                    <img class="click_star"
                                         src="<c:url value='/images/egovframework/review/star.png'/>" alt="별점"
                                         width="15px">
                                </div>
                                <div class="like_area">
                                    <img class="like_unclick"
                                         src="<c:url value='/images/egovframework/review/like.png'/>" alt="좋아요"
                                         width="25px">
                                    <img class="like_click"
                                         src="<c:url value='/images/egovframework/review/like_click.png'/>" alt="좋아요"
                                         width="25px" style="display: none;">
                                    <p class="like_count">45</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="menu_container">
            <p class="menu_title">메뉴 평가</p>
            <div class="menu_area">
                    <span id="menu1">
                    <div class="menu_name">
                    	&nbsp야채튀김&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click" type="checkbox" class="like" id="like1" onclick="likeclick(this)">
                            <label for="like1"></label>
                        </div>
                    &nbsp</span>
                <span id="menu2">
                    <div class="menu_name">
                    	&nbsp고구마튀김&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click" type="checkbox" class="like2" id="like2" onclick="likeclick(this)">
                            <label for="like2"></label>
                        </div>
                    &nbsp</span>
                <span id="menu3">
                    <div class="menu_name">
                    	&nbsp오징어튀김&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click" type="checkbox" class="like2" id="like2" onclick="likeclick(this)">
                            <label for="like2"></label>
                        </div>
                    &nbsp</span>
                <span id="menu4">
                    <div class="menu_name">
                    	&nbsp김말이&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click" type="checkbox" class="like" id="like1" onclick="likeclick(this)">
                            <label for="like1"></label>
                        </div>
                    &nbsp</span>
            </div>
            <!-- 메뉴옆에 좋아요 싫어요 -->
        </div>
    </section>
    <section class="review_area">
        <form:form commandName="searchVO" name="reviewUpdateForm" method="post">
            <div class="review_title">
                    <%--                <p class="title">${reviewVO.title}</p>--%>
                <input name="title" type="text" class="review_title" value="${reviewVO.title}" readonly>
                <div class="button_area">
                    <button type="button" id="modify_btn" class="btn btn-outline-primary">수정</button>

                    <input type="hidden" name="id" value="${reviewVO.id}" class="disable_input"/>
                    <input type="hidden" name="star" id="starhidden" value="" class="disable_star"/>

                    <input class="btn btn-primary" id="user_save_btn" style="margin-right:2px;"
                           type="submit" onclick="updateReview()" value="저장"/>
                    <input class="btn btn-outline-primary"
                           type="submit" onclick="deleteReview()" value="삭제"/>
                </div>
            </div>
            <textarea name="content" class="review_content" readonly placeholder="리뷰내용"
                      style="resize: none;">${reviewVO.content}</textarea>
        </form:form>
        <div class="owner_area">
            <form:form commandName="searchVO" name="reviewCommentForm" method="post">
                <div class="review_owner">
                    <p class="owner">사장님 답변</p>
                    <div class="button_area2">
                        <input type="hidden" name="reviewId" value="${reviewVO.id}" class="disable_input"/>
                        <button type="button" id="modify_btn2" class="btn btn-outline-primary">작성</button>
                        <c:if test="${empty reviewCommentVO.content}">
                            <input class="btn btn-primary" id="save_btn" style="margin-right:2px;"
                                   type="submit" onclick="addReviewComment()" value="저장"/>
                        </c:if>
                        <c:if test="${not empty reviewCommentVO.content}">
                            <input class="btn btn-primary" id="save_btn" style="margin-right:2px;"
                                   type="submit" onclick="updateReviewComment()" value="수정"/>
                        </c:if>
                        <input class="btn btn-outline-primary" style="margin-right:2px;"
                               type="submit" onclick="deleteReviewComment()" value="삭제"/>
<%--                        <button type="button" class="btn btn-outline-primary">삭제</button>--%>
                    </div>
                </div>
                <textarea name="content" class="owner_anwser" readonly placeholder="사장님 답글 내용"
                          style="resize: none;">${reviewCommentVO.content}</textarea>
            </form:form>
        </div>
    </section>
    </section>
    <div class="toggle_area">
        <div class="toggle">
            <input type="checkbox" id="toggle_btn" checked data-toggle="toggle" data-on="유저" data-off="사장님"
                   data-onstyle="success" data-offstyle="danger">
            <!-- 				<input id="autologin" type="checkbox" checked="checked" data-size="micro" data-on-color="success" data-off-color="danger" class="bs-switch"> -->
        </div>
    </div>
</div>
&nbsp</span>
</div>
<!-- 메뉴옆에 좋아요 싫어요 -->
</div>

</section>
</div>
<footer class="footer text-center">
    <div class="container">
        <h4>융합 서비스 프로젝트</h4>
        <div class="text-center">
            Copyright &copy; BCU 2021
        </div>
    </div>
</footer>

<script type="text/javaScript" language="javascript">
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

    starDisplay(${reviewVO.star}, document.getElementById("starArea"));

    $('input[name=star]').attr('value', ${reviewVO.star});
</script>
</body>
</html>
