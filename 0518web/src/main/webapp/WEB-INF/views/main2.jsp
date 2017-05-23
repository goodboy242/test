<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<title>Play</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
/* Full height image header */
.bgimg-1 {
	background-position: center;
	background-size: cover;
	background-image:
		url("https://bsbproduction.s3.amazonaws.com/portals/7363/images/baseball%20fields%203.jpg");
	min-height: 100%;
}

.w3-bar .w3-button {
	padding: 16px;
}

html, body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
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

	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-green w3-card-2" id="myNavbar">
			<a href="../" class="w3-bar-item w3-button w3-wide">Play</a>
			<!-- Right-sided navbar links -->
			<div class="w3-right w3-hide-small">
				<a href="#about" class="w3-bar-item w3-button">ABOUT</a> <a
					href="#team" class="w3-bar-item w3-button"><i
					class="fa fa-user"></i> TEAM</a> <a href="#work"
					class="w3-bar-item w3-button"><i class="fa fa-th"></i> WORK</a> <a
					href="#pricing" class="w3-bar-item w3-button"><i
					class="fa fa-usd"></i> PRICING</a> <a href="#contact"
					class="w3-bar-item w3-button"><i class="fa fa-envelope"></i>
					CONTACT</a>
			</div>
			<!-- Hide right-floated links on small screens and replace them with a menu icon -->

			<a href="javascript:void(0)"
				class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium"
				onclick="w3_open()"> <i class="fa fa-bars"></i>
			</a>
		</div>
	</div>

	<!-- Sidebar on small screens when clicking the menu icon -->
	<nav
		class="w3-sidebar w3-bar-block w3-light-grey w3-card-2 w3-animate-left w3-hide-medium w3-hide-large"
		style="display:none" id="mySidebar"> <a
		href="javascript:void(0)" onclick="w3_close()"
		class="w3-bar-item w3-button w3-large w3-padding-16">Close ×</a> <a
		href="#about" onclick="w3_close()" class="w3-bar-item w3-button">ABOUT</a>
	<a href="#team" onclick="w3_close()" class="w3-bar-item w3-button">TEAM</a>
	<a href="#work" onclick="w3_close()" class="w3-bar-item w3-button">WORK</a>
	<a href="#pricing" onclick="w3_close()" class="w3-bar-item w3-button">PRICING</a>
	<a href="#contact" onclick="w3_close()" class="w3-bar-item w3-button">CONTACT</a>
	</nav>

	<!-- Header with full-height image -->
	<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
	<div class="w3-display-middle w3-text-white w3-center">
		<span class="w3-jumbo w3-hide-small">Welcome ${sessionScope.userId }님!</span><br>
		<span class="w3-xxlarge w3-hide-large w3-hide-medium">Welcome
			${sessionScope.userId }님!</span><br> <span class="w3-large">Stop wasting valuable
			time with projects that just isn't you.</span>
		<p>
			<a href="#about"
				class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Start
				Today</a>
		</p>
	</div>
	<div class="w3-display-bottomleft w3-text-grey w3-large"
		style="padding: 24px 48px">
		<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
			class="fa fa-instagram w3-hover-opacity"></i> <i
			class="fa fa-snapchat w3-hover-opacity"></i> <i
			class="fa fa-pinterest-p w3-hover-opacity"></i> <i
			class="fa fa-twitter w3-hover-opacity"></i> <i
			class="fa fa-linkedin w3-hover-opacity"></i>
	</div>
	</header>

	<!-- About Section -->
	<div class="w3-container w3-grey" style="padding: 128px 16px" id="about">
		<h3 class="w3-center">ABOUT THE COMPANY</h3>

	</div>

	<!-- Promo Section - "We know design" -->
	<div class="w3-container w3-light-grey" style="padding: 64px 16px" id="notice">
		<div class="w3-margin-left">
			<h2>Important Notice</h2>
		</div>



		<!-- Notice Board List -->


	<c:choose>
		<c:when test="${not  empty boardList}">

			<c:forEach var="boardVO" items="${boardList}">
				<!--  Board List -->
				<c:set value="${boardVO.contents}" var="contents" />
				<c:if test="${fn:length(contents) > 150}" var="result">
					<c:set value="${fn:substring(contents,0,150) }" var="contents" />
				</c:if>

				<div class="w3-row w3-padding-16">
					<div class="w3-col.s7 w3-container">
						<span class="w3-opacity">${boardVO.writedate}</span>
						<h3 class="w3-text-teal">
							<a
								href="/board/article?bidx=${boardVO.bidx}"
								class="notice">${boardVO.title}</a>
						</h3>
						<span class="w3-opacity">${boardVO.userId} &ensp; category
							&ensp; hit【${boardVO.hitcnt}】</span>
						<p>
							${contents}
							<c:if test="${result }">
								<a
									href="/board/article?bidx=${boardVO.bidx}"
									class="w3-text-teal notice">&ensp;....more</a>
							</c:if>
						</p>
					</div>
				</div>
				<!-- END Notice -->
			</c:forEach>

		</c:when>
		<c:otherwise>
			<p>No Articles Yet</p>
		</c:otherwise>
	</c:choose>




	<div class="w3-margin-left">
		<p>
			<button class="w3-button w3-padding-large w3-grey w3-border"
				onclick="location.href='/board/write' ">
				<b>write »</b>
			</button>
		</p>
	</div>




	</div>


	<!-- Promo Section "Statistics" -->
	<div class="w3-container w3-row w3-center w3-dark-grey w3-padding-64">
		<div class="w3-quarter">
			<span class="w3-xxlarge">14+</span>

		</div>
	</div>

	<!-- Modal for full size images on click-->
	<div id="modal01" class="w3-modal w3-black"
		onclick="this.style.display='none'">
		<span
			class="w3-button w3-xxlarge w3-black w3-padding-large w3-display-topright"
			title="Close Modal Image">×</span>
		<div
			class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
			<img id="img01" class="w3-image">
			<p id="caption" class="w3-opacity w3-large"></p>
		</div>
	</div>

	<!-- Skills Section -->
	<div class="w3-container w3-light-grey w3-padding-64">
		<div class="w3-row-padding">
			<div class="w3-col m6">
				<h3>Our Skills.</h3>

			</div>
		</div>
	</div>

	<!-- Contact Section -->
	<div class="w3-container w3-light-grey" style="padding: 128px 16px"
		id="contact">
		<h3 class="w3-center">CONTACT</h3>
		<p class="w3-center w3-large">Lets get in touch. Send us a
			message:</p>
		<div class="w3-row-padding" style="margin-top: 64px">
			<div class="w3-half">
				<p>
					<i class="fa fa-map-marker fa-fw w3-xxlarge w3-margin-right"></i>
					Chicago, US
				</p>
				<p>
					<i class="fa fa-phone fa-fw w3-xxlarge w3-margin-right"></i> Phone:
					+00 151515
				</p>
				<p>
					<i class="fa fa-envelope fa-fw w3-xxlarge w3-margin-right"> </i>
					Email: mail@mail.com
				</p>
				<br>
				<form action="/action_page.php" target="_blank">
					<p>
						<input class="w3-input w3-border" type="text" placeholder="Name"
							required name="Name">
					</p>
					<p>
						<input class="w3-input w3-border" type="text" placeholder="Email"
							required name="Email">
					</p>
					<p>
						<input class="w3-input w3-border" type="text"
							placeholder="Subject" required name="Subject">
					</p>
					<p>
						<input class="w3-input w3-border" type="text"
							placeholder="Message" required name="Message">
					</p>
					<p>
						<button class="w3-button w3-black" type="submit">
							<i class="fa fa-paper-plane"></i> SEND MESSAGE
						</button>
					</p>
				</form>
			</div>
			<div class="w3-half"></div>
		</div>
	</div>

	<!-- Footer -->
	<footer class="w3-center w3-black w3-padding-64"> <a
		href="#home" class="w3-button w3-light-grey"><i
		class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
	<div class="w3-xlarge w3-section">
		<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
			class="fa fa-instagram w3-hover-opacity"></i> <i
			class="fa fa-snapchat w3-hover-opacity"></i> <i
			class="fa fa-pinterest-p w3-hover-opacity"></i> <i
			class="fa fa-twitter w3-hover-opacity"></i> <i
			class="fa fa-linkedin w3-hover-opacity"></i>
	</div>
	<p>
		Powered by <a href="https://www.w3schools.com/w3css/default.asp"
			title="W3.CSS" target="_blank" class="w3-hover-text-green">w3.css</a>
	</p>
	</footer>


	<script>
		// Toggle between showing and hiding the sidebar when clicking the menu icon
		var mySidebar = document.getElementById("mySidebar");

		function w3_open() {
			if (mySidebar.style.display === 'block') {
				mySidebar.style.display = 'none';
			} else {
				mySidebar.style.display = 'block';
			}
		}

		// Close the sidebar with the close button
		function w3_close() {
			mySidebar.style.display = "none";
		}
	</script>


</body>
</html>
