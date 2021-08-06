<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>Mentor Bootstrap Template - Index</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>

	<header id="header" class="fixed-top">
		<div class="container d-flex align-items-center">

			<h1 class="logo mr-auto">
				<a href="index.html">Mentor</a>
			</h1>
			<!-- Uncomment below if you prefer to use an image logo -->
			<!-- <a href="index.html" class="logo mr-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>-->

			<nav class="nav-menu d-none d-lg-block">
				<ul>
					<li class="active"><a
						href="<%=request.getContextPath()%>/homepage">Home</a></li>


					<security:authorize access="!isAuthenticated()">
						<li><a href="<%=request.getContextPath()%>/login">Login</a></li>
						<li><a href="<%=request.getContextPath()%>/user/getRegister">Register</a></li>
					</security:authorize>


					<li><a href="<%=request.getContextPath()%>/user/trainer">Trainers</a></li>
					<security:authorize access="isAuthenticated()">
						<li class="drop-down"><a href="">Creation</a>
							<ul>
								<li><a
									href="<%=request.getContextPath()%>/user/registryTutorPage">Registery
										yourself as Tutor</a></li>
								<li><a
									href="<%=request.getContextPath()%>/user/registryStudentPage">Registery
										yourself as Student</a></li>
							</ul></li>
					</security:authorize>
					<li class="drop-down"><a href="">Subject</a>
						<ul>
							<li><a href="<%=request.getContextPath()%>/user/math_tutors">Math</a></li>
							<li class="drop-down"><a href="#">Find Your Subject</a>
								<ul>
									<li><a>Math</a></li>
									<li><a href="#">English</a></li>
									<li><a>Literature</a></li>
								</ul></li>
							<li><a
								href="<%=request.getContextPath()%>/user/english_tutors">English</a></li>
							<li><a
								href="<%=request.getContextPath()%>/user/literature_tutors">Literature</a></li>
						</ul></li>
					<li><a href="<%=request.getContextPath()%>/user/contact">Contact</a></li>

				</ul>
			</nav>
			<!-- .nav-menu -->

			<security:authorize access="!isAuthenticated()">
				<a href="<%=request.getContextPath()%>/login"
					class="get-started-btn">Login</a>
			</security:authorize>

			<security:authorize access="isAuthenticated()">

				<div class="dropdown show">
					<a class="ml-5 btn btn-success dropdown-toggle" href="#"
						role="button" id="dropdownMenuLink" data-toggle="dropdown"
						aria-haspopup="true" aria-expanded="false"> Welcome <security:authentication
							property="principal.username" />
					</a>

					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item"
							href="<%=request.getContextPath()%>/user/userTutors">Your Tutor profiles</a> 
							<a class="dropdown-item" href="<%=request.getContextPath()%>/user/userStudents">Your Student profiles</a>
							<a class="dropdown-item" href="#">Something else here</a>
							<a class="dropdown-item" href="<c:url value="/logout" />">logout</a>
					</div>
				</div>


			</security:authorize>

		</div>
	</header>
	<!-- End Header -->


	<div class="container">
		<h3>Navbar Forms</h3>
		<p>Use the .navbar-form class to vertically align form elements
			(same padding as links) inside the navbar.</p>
	</div>

</body>
</html>