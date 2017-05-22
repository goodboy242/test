<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="page-header">
				<h2>로그인 하세요</h2>
			</div>
			<div class="col-md-3">
				<div class="login-box well">
					<form role="form" method="post" action="/loginchk">
						<legend>로그인</legend>
						<div class="form-group">
							<label for="userId">이메일 or 아이디</label> <input name="userId"
								value='' id="userId" placeholder="E-mail or Username"
								type="text" class="form-control" />
						</div>
						<div class="form-group">
							<label for="password">비밀번호</label> <input name="userPw"
								id="password" value='' placeholder="Password" type="password"
								class="form-control" />
						</div>
						<div class="form-group">
							 <input type="hidden" name="requestPage" value=${ requestScope.requestPage} />
						</div>
						<div class="form-group">
							<input type="submit"
								class="btn btn-default btn-login-submit btn-block m-t-md"
								value="Login" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

</body>
</html>