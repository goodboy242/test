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
<body class="w3-light-grey">


<!-- Blog entries -->
<div class="w3-col l8 s12">
  <!-- Blog entry -->
  <div class="w3-card-4 w3-margin w3-white">
    <div class="w3-container">
      <h3 class="w3-text-teal"><b>${boardVO.title}<a href="#"></a></b></h3>
      <h5>${boardVO.userId}&ensp;  <span class="w3-opacity">${boardVO.writedate} &ensp;  hit【${boardVO.hitcnt}】</span></h5>
    </div>

    <div class="w3-container">
      <p>${boardVO.contents}</p>
      <div class="w3-row">
        <div class="w3-col m8 s12">
          <p><button class="w3-button w3-padding-small w3-white w3-border" onclick="location.href='/board/list#notice' "><b>Back to List »</b></button>
          <button class="w3-button w3-padding-small w3-green w3-border" onclick="location.href='/board/edit' "><b>Edit »</b></button>
          <button class="w3-button w3-padding-small w3-red w3-border" onclick="location.href='/board/delete' "><b>Delete »</b></button>
          </p>
        </div>
      </div>
    </div>
  </div>
  <hr>

<!-- END BLOG ENTRIES -->
</div>

</body>
</html>