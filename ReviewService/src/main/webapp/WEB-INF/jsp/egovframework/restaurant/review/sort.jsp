<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javaScript" language="javascript">
	function orderStar() {
		document.orderForm.action = "<c:url value='/reviewMain_orderStar.do'/>";
		document.orderForm.submit();
	}
</script>

<div class="btn-group reviewListFilter">
	<form:form class="btn-group reviewListFilter" name="orderForm">
	<button type="button" class="btn btn-danger dropdown-toggle"
		data-toggle="dropdown" aria-expanded="false"
		style="background-color: #0679fa; border: 1px solid #0679fa;">
		정렬</button>
	<ul class="dropdown-menu">
		<li><a class="dropdown-item" href="#">최신순</a></li>
		<li><a class="dropdown-item" href="#" onclick="orderStar()">추천순</a></li>
		<li><a class="dropdown-item" href="#">좋아요순</a></li>
	</ul>
	</form:form>
</div>