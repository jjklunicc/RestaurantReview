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
    <title>식당 분류 리스트</title>
    <link type="text/css" rel="stylesheet"
          href="<c:url value='/css/egovframework/restaurant/restaurantCategory.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer"></script>
</head>
<body>
<header class="header text-uppercase header-main-text" id="mainHeader">
    <div class="container header-main-text">
        <div>Restaurant Review</div>

        <%-- 여기가 내가 추가한 버튼.실험용 --%>
        <form action='mypage.do'>
            <div style="margin-bottom: 0.5rem; margin-left: 60rem;">
                <input class="btn btn-primary" style="width: 100%" id="mypage" type="submit" value="마이페이지"/>
            </div>
        </form>
        <%-- 여기가 내가 추가한 버튼.실험용 --%>
    </div>
</header>
<main class="container">
    <div class="category-list" ng-hide='$location.path() != "/"'>
        <div class="row">
            <!-- ngRepeat: banner in banner_list -->
            <!-- end ngRepeat: banner in banner_list -->
            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-3">
                <a
                        href="lstRestaurant.do?category=0"
                        class="thumbnail"
                >
                    <div class="category-title">전체보기</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-01.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="restaurant.do?category=4"
                        class="thumbnail"
                >
                    <div class="category-title">치킨</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-02.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=5"
                        class="thumbnail"
                >
                    <div class="category-title">피자/양식</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-03.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=6"
                        class="thumbnail"
                >
                    <div class="category-title">중국집</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-04.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=1"
                        class="thumbnail"
                >
                    <div class="category-title">한식</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-05.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=3"
                        class="thumbnail"
                >
                    <div class="category-title">일식/돈까스</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-06.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=7"
                        class="thumbnail"
                >
                    <div class="category-title">족발/보쌈</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-07.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=8"
                        class="thumbnail"
                >
                    <div class="category-title">야식</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-08.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=2"
                        class="thumbnail"
                >
                    <div class="category-title">분식</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-09.png'/>"
                    /></a>
            </div>
            <div class="col-xs-6 col-sm-4 col-md-3">
                <a
                        href="lstRestaurant.do?category=11"
                        class="thumbnail"
                >
                    <div class="category-title">카페/디저트</div>
                    <img src="<c:url value='/images/egovframework/restaurant/category-11.png'/>"
                    /></a>
            </div>
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