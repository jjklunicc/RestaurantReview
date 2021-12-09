<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"     uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script>
    function fnMove(seq){
        var offset = $("#div" + seq).offset();
        $('html, body').animate({scrollTop : offset.top}, 400);
    }
</script>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta name = "viewport" content="width=device-width", inital-scale="1">
	<title>마이페이지</title>
	<Style>
		div #c{
		margin: 30px;
		}
	</Style>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
    <script type="text/javaScript" language="javascript" defer="defer"></script>
    <nav class="navbar navbar-default">
	    <div class="navbar-header"> 
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	    <a class="navbar-brand" a href="mypage.jsp">mypage</a> 
	    <ul class="nav navbar-nav"> 
			 <li>
			    <a href = "javascript:fnMove(1);">즐겨찾는 맛집</a>
			 </li> 
			 <li>
			    <a href = "javascript:fnMove(2);">리뷰 리스트</a> <%--으아아아아앙아아!!!!! 살려줘!!!!! --%>
			 </li> 
			 <li>
			    <a href = "javascript:fnMove(3);">주문 내역</a>
			 </li> 
		</ul>
		<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">내 정보<span class="caret"></span></a>
					<!-- 드랍다운 아이템 영역 -->	
					<ul class="dropdown-menu">
						<li><a href="login.jsp">주문내역관리</a></li>
					</ul>
				</li>
		</ul>
    	</div>
    </nav>
</head>

<body style="background-color:#fffacd">
	<div class="py-5 text-center">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1 class="display-3 text-capitalize">RestaurantReview</h1>
					<p class="lead text-muted">MyPage</p>
				</div>
			</div>
		</div>
	</div>
	
	<%-- 여기부터가 즐겨찾는 맛집 --%>
	<div class="py-4">
    <div class="container" style="background-color:#ffffff">
      <div class="row">
        <div class="col-md-12" id="div1">
          <h2>즐겨찾는 맛집</h2>
          <hr>
        </div>
      </div>
      <div class="row text-center">
        <div> 
        <img src="../../../../../images/egovframework/user/baskin.jpg" width="400" height="400">
        </div>
      </div>
    </div>
    </div>
	<%-- 여기까지가 즐겨찾는 맛집 --%>



	<%-- 여기부터가 리뷰리스트 매장이름,별점,날짜,리뷰를 테이블로 만들어서 하려고 한다.--%>
	<div class="py-5">
    <div class="container" style="background-color:#ffffff">
      <div class="row">
        <div class="col-md-12" id="div2">
          <h2>리뷰 리스트</h2>
          <hr class="mb-4">
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 p-3">
          <table class="table table-hover table-striped table-bordered">
            <thead class="thead-inverse">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">매장</th>
                <th scope="col">별점</th>
                <th scope="col">리뷰내용</th>
                <th scope="col">날짜</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>bbq 방화점</td>
                <td>4.5점</td>
                <td>생각보다 먹을만 했습니다.</td>
                <td>2021-12-01</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>베스킨라빈스 소사점</td>
                <td>1점</td>
                <td>아이스크림이 다 녹아서 왔습니다.</td>
                <td>2021-12-06</td>
              </tr>
              <tr class="bg-info">
                <th scope="row">3</th>
                <td>스타벅스 부천점</td>
                <td>4점</td>
                <td>아이스아메리카노 맛있게 잘먹었습니다.</td>
                <td>2021-12-07</td>
              </tr>
              <tr>
                <th scope="row">4</th>
                <td>베스킨라빈스 소사점</td>
                <td>3점</td>
                <td>이번에는 아이스크림이 얼어서 왔습니다</td>
                <td>2021-12-10</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
	<%-- 
	<div class="py-4" style="margin:100px; border-radius=2em; background-color:#ffffff">
	    <div class="container">
	      <div class="row">
	        <div class="col-12" style="width: 300px; border-style:bold; text-align: center">
	          <h2>리뷰 리스트</h2>
	          <hr>
	           <table style='width: 300px; border-style: solid; border-width: 1px; top: 50%; left: 50%; 
	           height: 200px; text-align: center; margin: -100px 0pt 0pt -150px; 
	           border-color:black' cellspacing="0" cellpadding="0">
	         	    <tr>
				      <td>글번호</td>
				      <td>글제목</td>
				      <td>작성일자</td>
					</tr>
			   </table>
	        </div>
	      </div>
	    </div>
	 </div>
	 --%>
	 <%-- 여기까지가 리뷰리스트 --%>
	 
	<%-- 여기부터가 나의 주문 내역 --%>
	<div class="py-5">
    <div class="container" style="background-color:#ffffff">
      <div class="row">
        <div class="col-md-12" id="div3">
          <h2>주문 내역</h2>
          <hr class="mb-4">
        </div>
      </div>
      <div class="row">
        <div class="col-md-12 p-3">
          <table class="table table-hover table-striped table-bordered">
            <thead class="thead-inverse">
              <tr>
                <th scope="col">번호</th>
                <th scope="col">매장</th>
                <th scope="col">가격</th>
                <th scope="col">메뉴</th>
                <th scope="col">날짜</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>bbq 방화점</td>
                <td>29,000$</td>
                <td>황금올리브치킨</td>
                <td>2021-12-01</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>베스킨라빈스 소사점</td>
                <td>18,000$</td>
                <td>패밀리컵</td>
                <td>2021-12-06</td>
              </tr>
              <tr class="bg-info">
                <th scope="row">3</th>
                <td>스타벅스 부천점</td>
                <td>4,500$</td>
                <td>아이스아메리카노</td>
                <td>2021-12-07</td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>베스킨라빈스 소사점</td>
                <td>18,000$</td>
                <td>패밀리컵</td>
                <td>2021-12-10</td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
	 <%-- 여기까지가 나의 주문 내역 --%>

    
</body>
</html>