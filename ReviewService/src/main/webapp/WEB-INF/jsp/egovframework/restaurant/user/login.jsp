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
	<title>로그인</title>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/bootstrap.css'/>"/>
    <link type="text/css" rel="stylesheet" href="<c:url value='/css/egovframework/main.css'/>"/>
     <script type="text/javaScript" language="javascript" defer="defer">
     /* 회원가입 function */
	     function login() {      		     	
	     	document.loginForm.action = "<c:url value='/restaurantList.do'/>";
	        	document.loginForm.submit();           
	     }
     </script>
</head>
<body>
  <header class="header text-uppercase header-main-text" id="mainHeader">
    <div class="container header-main-text">
      <div>Restaurant Review</div>
    </div>
  </header>
  <main class="container page-section">
    <h1 class="text-center title">로그인</h1>
    <form:form commandName="userVO" method="post" id="login-form" name="loginForm">
      <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" class="form-control" id="id" placeholder="아이디" name="id">
      </div>
      <div class="form-group">
        <label for="pw">비밀번호</label>
        <input type="password" class="form-control" id="pw" placeholder="비밀번호" name="pw">
      </div>
      <div style="margin-bottom: 0.5rem;">
        <input class="btn btn-success" style="width: 100%;" id="login" type="submit" value="로그인" onClick="login()"/>
      </div>      
    </form:form>
    <form action='signUp.do'>
    	<div><input class="btn btn-primary" style="width: 100%;" id="singUp" type="submit" value="회원가입"/></div>
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