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
     <script type="text/javaScript" language="javascript" defer="defer">
     /* 회원가입 function */
	     function signUp() {      		     	
	     	document.signUpForm.action = "<c:url value='/login.do'/>";
	        	document.signUpForm.submit();           
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
    <form:form commandName="userVO" method="post"  id="sign-up-form" name="signUpForm">
      <div class="form-group">
        <label for="id">아이디</label>
        <input type="text" class="form-control" id="id" placeholder="아이디" name="id">
        <input class="btn" style="width: 100%; margin-top:0.5rem;" id="login" type="submit" value="중복확인"/>
      </div>            
      <div class="form-group">
        <label for="pw">비밀번호</label>
        <input type="pw" class="form-control" id="pw" placeholder="비밀번호" name="pw">
      </div>
       <div class="form-group">
        <label for="pw2">비밀번호 확인</label>
        <input type="pw2" class="form-control" id="pw2" placeholder="비밀번호 확인">
      </div>
      <div class="form-group">
        <label for="name">이름</label>
        <input type="text" class="form-control" id="name" placeholder="이름" name="name">
      </div>
      <div class="form-group">
        <label for="phonenumber">연락처</label>
        <input type="text" class="form-control" id="phonenumber" placeholder="연락처" name="phonenumber">
      </div>
      <div class="form-group">
        <label for="addr">주소</label>
        <input type="text" class="form-control" id="addr" placeholder="주소" name="addr">
      </div>
      <div style="margin-bottom: 0.5rem;">
        <input class="btn btn-success" style="width: 100%;" id="signUp" type="submit" value="가입하기" onClick="signUp()"/>
      </div>      
    </form:form>
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