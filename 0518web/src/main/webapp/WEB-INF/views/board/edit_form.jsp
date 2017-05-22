<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Writing</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<div class="222">
			<h3>Editing form</h3>
		</div>
		<form class="form-horizontal" method="post"
			action="/board/edit_complete">
			<div class="form-group">
				<label class="control-label col-sm-2" for="title">제목</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="title"
						placeholder="Enter title" name="title">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-2" for="contents">내용</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="10" cols="10"
						placeholder="Enter contents" id="contents" name="contents"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label><input type="checkbox" name="secretOption">
							비밀글</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success ">Submit</button>
					<a href="#" class="btn btn-default">Cancel</a>
				</div>
			</div>
		</form>
	</div>

</body>
</html>