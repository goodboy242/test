<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Main</title>
</head>
<body>
	<center>
		<h2>This webpage is not available</h2>

		<button class="w3-button w3-padding-large w3-pink w3-border"
			onclick="location.href='/board/list' ">
			<b>Go to List »</b>
		</button>


		<c:choose>
			<c:when test="${ empty sessionScope.userId}">
				<div>
					<button class="w3-button w3-padding-large w3-yellow w3-border"
						onclick="location.href='/login' ">
						<b>Login »</b>
					</button>
				</div>
			</c:when>

			<c:otherwise>
				<form role="form" method="post" action="/logout">
					<button type="submit"
						class="w3-button w3-padding-large w3-yellow w3-border"
						onclick="alert('로그아웃 되었습니다.')">
						<b>Logout »</b>
					</button>
			</c:otherwise>

		</c:choose>





		</form>
	</center>
</body>
</html>