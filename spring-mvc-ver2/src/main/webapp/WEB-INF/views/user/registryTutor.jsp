<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
body {
	color: #000;
	overflow-x: hidden;
	height: 100%;
	background-image: url("https://i.imgur.com/GMmCQHC.png");
	background-repeat: no-repeat;
	background-size: 100% 100%
}

.card {
	padding: 30px 40px;
	margin-top: 60px;
	margin-bottom: 60px;
	border: none !important;
	box-shadow: 0 6px 12px 0 rgba(0, 0, 0, 0.2)
}

.blue-text {
	color: #00BCD4
}

.form-control-label {
	margin-bottom: 0
}

input, textarea, button {
	padding: 8px 15px;
	border-radius: 5px !important;
	margin: 5px 0px;
	box-sizing: border-box;
	border: 1px solid #ccc;
	font-size: 18px !important;
	font-weight: 300
}

input:focus, textarea:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	border: 1px solid #00BCD4;
	outline-width: 0;
	font-weight: 400
}

.btn-block {
	text-transform: uppercase;
	font-size: 15px !important;
	font-weight: 400;
	height: 43px;
	cursor: pointer
}

.btn-block:hover {
	color: #fff !important
}

button:focus {
	-moz-box-shadow: none !important;
	-webkit-box-shadow: none !important;
	box-shadow: none !important;
	outline-width: 0
}

#gender {
	margin: 25px;
}
</style>

</head>
<body>

	<%@include file="/WEB-INF/views/layout/header.jsp"%>

	<div class="container-fluid px-1 py-5 mx-auto">
		<div class="row d-flex justify-content-center">
			<div class="col-xl-7 col-lg-8 col-md-9 col-11 text-center">
				<h3>Let's become our Mentor</h3>
				<p class="blue-text">
					Just answer a few questions<br> so that we can personalize the
					right experience for you.
				</p>
				<div class="card">
					<h5 class="text-center mb-4">Powering world-class companies</h5>


					<form:form action="./registryTutor" method="POST"
						modelAttribute="registryTutor" class="form-card">

						<div class="row justify-content-between text-left">
							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">Your full name<span
									class="text-danger"> *</span></label>
								<form:input type="text" id="fname" name="fname" path="tutor.tutorName"
									placeholder="Enter your first name" onblur="validate(1)"
									required="required" />
							</div>

							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">Address<span
									class="text-danger"> *</span></label>
								<form:input path="tutor.address" type="text" id="lname" name="lname"
									placeholder="Enter your last name" onblur="validate(2)"
									required="required" />
							</div>
						</div>

						<div class="row justify-content-between text-left">

							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">Your Credential
									(optional)<span class="text-danger"> *</span>
								</label>
								<form:input path="tutor.credential" type="text" id="email"
									name="credential" placeholder="" onblur="validate(3)" />
							</div>

							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">Phone number<span
									class="text-danger"> *</span></label>
								<form:input path="tutor.phonenumber" type="text" id="mob" name="mob"
									placeholder="" onblur="validate(4)" required="required" />
							</div>
						</div>

						<div class="row justify-content-between text-left">

							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">Gender<span
									class="text-danger"> *</span></label>
								<form:select class="form-select" path="tutor.gender"
									required="required">
									<form:option value="M">Male</form:option>
									<form:option value="F">Female</form:option>
								</form:select>
							</div>

							<div class="form-group col-sm-6 flex-column d-flex">
								<label class="form-control-label px-3">experienceYear<span
									class="text-danger"> *</span></label>
								<form:input path="tutor.experienceYear" type="text" id="job"
									name="job" placeholder="" />
							</div>



						</div>

						<div class="row justify-content-between text-left">
							<div class="form-group col-12 flex-column d-flex">
								<label class="form-control-label px-3">description<span
									class="text-danger"> *</span>
								</label>
								<form:input path="tutor.description" type="text" id="ans" name="ans"
									placeholder="" onblur="validate(6)" required="required" />
							</div>
						</div>

						<div class="row justify-content-between text-left">
							<div class="form-group col-12 flex-column d-flex">
								<label class="form-control-label px-3">Subject that you teach:
								</label>
								
                           <span> English <form:checkbox path="subject.subjectName" value="E"/> </span>
                           <span>  Math <form:checkbox path="subject.subjectName" value="M"/> </span>
                             <span> Literature <form:checkbox path="subject.subjectName" value="L" /></span>
   
							</div>
						</div>

                     <input type="submit" value="Submit">
					</form:form>


				</div>
			</div>
		</div>
	</div>
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