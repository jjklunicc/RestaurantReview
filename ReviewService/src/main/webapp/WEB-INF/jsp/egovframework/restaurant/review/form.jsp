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
    <title>리뷰 작성</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer">
    
	function check(str){
		if( str.value == ''
				|| str.value == null
				|| str.value.replace( /^\s+|\s+$/g, '' ) == ""
				|| /[\s]/g.test(str.value) == true){
		    alert( '입력이 올바르지 않습니다.' );
		    return false;
		}

		return true;
	}
    
    function addReview() {
    	const checkTitle = check(document.reviewForm["title"]);
    	const checkContent = false;
    	if (checkTitle) {
    		checkContent = check(document.reviewForm["content"]);
    	}
    	if (checkTitle && checkContent) {
	    	document.reviewForm.action = "<c:url value='/addReview.do'/>";
	    	document.reviewForm.submit();
    	}
    }
    </script>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/css/egovframework/review/reset.css'/>"/>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/css/egovframework/review/form.css'/>"/>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
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
        <form:form commandName="searchVO" id="reviewForm" name="reviewForm" method="post">
            <p class="review_write">리뷰작성</p>
            <section class="review_detail">
                <div class="recoReviewList">
                    <div class="card">
                        <div class="card-body" style="display: inline-block;">
                            <div class="card-title"><img src="<c:url value='/images/egovframework/review/profile.png'/>"
                                                         alt="프로필 아이콘" width="80px">
                                <div class="info_area">
                                    <p class="user_name">허근행</p>
                                    <p class="date"></p>
                                    <div class="star_like_area">
                                        <div class="star_area">
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
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="menu_container">
                    <p class="menu_title">메뉴 평가</p>
                    <select name="menu" class="selectpicker">
                        <option value="">-- 메뉴선택 --</option>
                        <option>야채튀김</option>
                        <option>고구마튀김</option>
                        <option>오징어튀김</option>
                        <option>김말이</option>
                    </select>
                    <div class="menu_area">
                    <span id="menu1">
                    <div class="menu_name">
                    &nbsp야채튀김&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click1" type="radio" class="like" id="like1" onclick="likeclick(this)">
                            <label for="like1"></label>
                            <input name="click1" type="radio" class="like2" id="like2" onclick="likeclick(this)">
                            <label for="like2"></label>
                            <p class="cancle_btn">&#215;</p>
                        </div>
                    &nbsp</span>
                        <span id="menu2">
                       	<div class="menu_name">
                    	&nbsp고구마튀김&nbsp
                    	</div>
                        <div class="like_area2">
                            <input name="click2" type="radio" class="like" id="like3" onclick="likeclick(this)">
                            <label for="like3"></label>
                            <input name="click2" type="radio" class="like2" id="like4" onclick="likeclick(this)">
                            <label for="like4"></label>
                            <p class="cancle_btn">&#215;</p>
                        </div>
                    &nbsp</span>
                        <span id="menu3">
                    <div class="menu_name">
                      &nbsp야채튀김&nbsp
                    </div>
                        <div class="like_area2">
                            <input name="click3" type="radio" class="like" id="like5" onclick="likeclick(this)">
                            <label for="like5"></label>
                            <input name="click3" type="radio" class="like2" id="like6" onclick="likeclick(this)">
                            <label for="like6"></label>
                            <p class="cancle_btn">&#215;</p>
                        </div>
                    &nbsp</span>
                        <span id="menu4">
                        <div class="menu_name">
                    		&nbsp김말이&nbsp
                    	</div>
                        <div class="like_area2">
                            <input name="click4" type="radio" class="like" id="like7" onclick="likeclick(this)">
                            <label for="like7"></label>
                            <input name="click4" type="radio" class="like2" id="like8" onclick="likeclick(this)">
                            <label for="like8"></label>
                            <p class="cancle_btn">&#215;</p>
                        </div>
                    &nbsp</span>
                    </div>
                    <!-- 메뉴옆에 좋아요 싫어요 -->
                </div>
            </section>
            <section class="review_area">
                <input name="title" type="text" class="review_title" placeholder="리뷰 제목">
                <textarea name="content" type="text" class="review_content" placeholder="리뷰내용" multiple
                          style="resize: none;"></textarea>
                <div class="owner_area">
                    <div class="review_owner">
                        <p class="owner">사장님 답변</p>
                    </div>
                    <textarea type="text" class="owner_anwser" placeholder="사장님 답글 내용" multiple
                              style="resize: none;"></textarea>
            </section>
            <button onclick="addReview()">add Test</button>

          	<div>
		
          	<input type="hidden" name="userId" value="1" class="disable_input"/>
          	<input type="hidden" name="shopId" value="2" class="disable_input"/>
          	<input type="hidden" name="orderId" value="3" class="disable_input"/>       
          
            <input type="hidden" name="starhidden" id="starhidden" value="" class="disable_star"/>
            
            <script>
            var starpath = 0;
			$('input[name=starhidden]').attr('value',starpath);
            </script>
            	
          	</div>
        </form:form>
    </div>
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
