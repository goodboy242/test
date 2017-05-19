<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	Userid = ${userData.userId}
	<br>
	<br>
	<a href="http://localhost:8080/web/board/write">write</a>
	<br>
	<a href="http://localhost:8080/web/board/list">list</a>
	<br>
	<a href="http://localhost:8080/web/board/edit">edit</a>
	<br>
	<br>
	<br> Title = ${boardData.title }
	<br> Contents = ${boardData.contents }
	<br>


</body>
</html>