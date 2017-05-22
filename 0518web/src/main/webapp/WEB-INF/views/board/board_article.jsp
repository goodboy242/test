<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Article no.${boardVO.bidx}</title>
<meta charset="UTF-8">

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}

.notice:hover {
	text-decoration: underline;
	font-weight: bold;
}

.notice:link {
	text-decoration: none;
}
</style>
<body>



	<!--  Board List -->
	<c:set value="${boardVO.contents}" var="contents" />
	<c:if test="${fn:length(contents) > 2000}" var="result">
		<c:set value="${fn:substring(contents,0,2000) }" var="contents" />
	</c:if>


	<div class="w3-row w3-padding-16">
		<div class="w3-col.s7 w3-container">
			<span class="w3-opacity">${boardVO.writedate}</span>
			<h3 class="w3-text-teal">
				<a href="#" class="notice">${boardVO.title}</a>
			</h3>
			<span class="w3-opacity">${boardVO.userId} &ensp; category
				&ensp; hit【${boardVO.hitcnt}】</span>
			<p>
				${contents}
				<c:if test="${result }">
				<a href="#" class="w3-text-teal notice">&ensp;....more</a>
				</c:if>
			</p>
		</div>
	</div>
	<!-- END Notice -->




	<div class="w3-margin-left">
		<p>
			<button class="w3-button w3-padding-large w3-grey w3-border" onclick="location.href='/board/list#notice' ">
				<b>Back to List »</b>
			</button>
		</p>
	</div>

</body>
</html>