<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="btn-group reviewListFilter">
	<button type="button" class="btn btn-danger dropdown-toggle"
		data-toggle="dropdown" aria-expanded="false"
		style="background-color: #0679fa; border: 1px solid #0679fa;">
		정렬</button>
	<ul class="dropdown-menu">
		<li><a class="dropdown-item" href="#">최신순</a></li>
		<li><a class="dropdown-item" href="#" onclick="location.href='/reviewMain_orderStar.do'">추천순</a></li>
		<li><a class="dropdown-item" href="#">좋아요순</a></li>
	</ul>
</div>