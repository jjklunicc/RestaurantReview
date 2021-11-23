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
	<title>회원가입</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
     <script type="text/javaScript" language="javascript" defer="defer"></script>
</head>
<body>
  <header class="header text-uppercase header-main-text" id="mainHeader">
    <div class="container header-main-text">
      <div>Restaurant Review</div>
    </div>
  </header>
  <main class="container page-section">
    <h1 class="text-center title">회원가입</h1>
    <div class="form-group" role="group" ria-label="Basic radio toggle button group">
      <div class="form-check">
        <input class="form-check-input" type="radio" name="btnRadio" id="user" checked>
        <label class="form-check-label" for="user">
         	 일반 회원
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="btnRadio" id="owner">
        <label class="form-check-label" for="owner">
          	식당 회원
        </label>
      </div>
      <div class="form-check">
        <input class="form-check-input" type="radio" name="btnRadio" id="manager">
        <label class="form-check-label" for="manager">
          	관리자
        </label>
      </div>
    </div>
    <form method="post" action="login.do">
      <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" class="form-control" id="id" placeholder="아이디">
        <input class="btn" style="width: 100%; margin-top:0.5rem;" id="login" type="submit" value="중복확인"/>
      </div>            
      <div class="form-group">
        <label for="name">비밀번호</label>
        <input type="password" class="form-control" id="password" placeholder="비밀번호">
      </div>
       <div class="form-group">
        <label for="name">비밀번호 확인</label>
        <input type="password" class="form-control" id="password" placeholder="비밀번호 확인">
      </div>
      <div class="form-group">
        <label for="name">이름</label>
        <input type="text" class="form-control" id="name" placeholder="이름">
      </div>
      <div class="form-group">
        <label for="name">연락처</label>
        <input type="text" class="form-control" id="phonenumber" placeholder="연락처">
      </div>
      <div class="form-group">
        <label for="name">주소</label>
        <input type="text" class="form-control" id="address" placeholder="주소">
      </div>
      <div style="margin-bottom: 0.5rem;">
        <input class="btn btn-success" style="width: 100%;" id="login" type="submit" value="가입하기"/>
      </div>      
    </form>
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