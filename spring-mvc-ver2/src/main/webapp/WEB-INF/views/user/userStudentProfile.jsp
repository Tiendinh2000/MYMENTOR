<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Trainers</title>
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<body>

	<%@include file="/WEB-INF/views/layout/header.jsp"%>
	<main id="main" data-aos="fade-in">

		<!-- ======= Breadcrumbs ======= -->
		<div class="breadcrumbs">
			<div class="container">
				<h2>Trainers for ${SubjectName}</h2>
				<p>They are all out best teacher for Mathematics. They will make
					it easier for everyone</p>
			</div>
		</div>
		<!-- End Breadcrumbs -->

		<!-- ======= Trainers Section ======= -->
		<section id="trainers" class="trainers">
			<div class="container" data-aos="fade-up">

				<div class="row" data-aos="zoom-in" data-aos-delay="100">

					<c:forEach items="${studentList}" var="student">

						<div class="col-lg-4 col-md-6 d-flex align-items-stretch">
							<div class="member">
								<div class="member-content">
									<h4>${student.studentName}</h4>
									<div>Address: ${student.skill}</div>
									<p>${student.phonenumber} </p>
									<p>
									<div>Address: ${student.address}</div>
									<div>Experiences </div>
									</p>
								</div>
								<td>
									<button class="btn btn-outline-warning"
										data-confirm="Are you sure to delete ?"
										href="userDeletestudent/${student.id}">delete</button> <script>
											$('.btn')
													.on(
															"click",
															function(e) {
																e
																		.preventDefault();
																var choice = confirm($(
																		this)
																		.attr(
																				'data-confirm'));

																if (choice) {
																	window.location.href = $(
																			this)
																			.attr(
																					'href');
																}

															});
										</script>
								</td>
							</div>
						</div>

					</c:forEach>

				</div>

			</div>
		</section>
		<!-- End Trainers Section -->

	</main>
	<!-- End #main -->

	<%@include file="/WEB-INF/views/layout/footer.jsp"%>


	<!-- Vendor JS Files -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
	<script src="assets/vendor/counterup/counterup.min.js"></script>
	<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
</body>


</body>
</html>