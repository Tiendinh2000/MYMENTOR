<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
	background-color: black;
}

* {
	box-sizing: border-box;
}

/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}

/* Full-width input fields */
input[type=text], input[type=password] {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #ddd;
	outline: none;
}

/* Overwrite default styles of hr */
hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
	background-color: #04AA6D;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

/* Add a blue text color to links */
a {
	color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: #f1f1f1;
	text-align: center;
}

.error {
	color: red
}
</style>



</head>
<body>
	<%@include file="/WEB-INF/views/layout/header.jsp"%>

	<form:form action="./Register" method="POST" id="create-form"
		modelAttribute="newAccount">
		<div class="container">
			<h1>Register</h1>
			<p>Please fill in this form to create an account.</p>
			<hr>

			<div class="form-group">
				<label>User Name:</label>
				<form:input type="text" path="userName" required="required" />
				<form:errors path="userName" cssClass="error" />
			</div>

			<div class="form-group">
				<label>Password :</label>
				<form:input type="text" path="password" id="psw" onkeyup='check();'
					required="required" />
					<form:errors path="password" cssClass="error" />
			</div>

			<div class="form-group">
				<label>Confirm-Password :</label> <input type="text" id="psw-repeat"
					onkeyup='check();' required="required" />
			</div>
			<span id="message"></span>
			<p>
				By creating an account you agree to our <a href="#">Terms &
					Privacy</a>.
			</p>

			<button type="submit" id="registerbtn" class="registerbtn">Register</button>
			<script type="text/javascript">
				var check = function() {
					if (document.getElementById('psw').value == document
							.getElementById('psw-repeat').value) {
						document.getElementById('message').style.color = 'green';
						document.getElementById('message').innerHTML = 'matching';
						document.getElementById("registerbtn").disabled = false;
					} else {
						document.getElementById("registerbtn").disabled = true;
						document.getElementById('message').style.color = 'red';
						document.getElementById('message').innerHTML = 'not matching';
					}
				}
				jQuery(document).ready(function($) {

			        $("#create-form").submit(function(event) {

			            // Disble the search button
			            enableSearchButton(false);

			            // Prevent the form from submitting via the browser.
			            event.preventDefault();

			            searchViaAjax();

			        });

			    });

			    function searchViaAjax() {

			        var search = {}
			        search["username"] = $("#username").val();
			        search["email"] = $("#email").val();

			        $.ajax({
			            type : "GET",
			            contentType : "text/plain",
			            url : "",
			            data : JSON.stringify(search),
			            dataType : 'text/plain',
			            timeout : 100000,
			            success : function(data) {
			                console.log("SUCCESS: ", data);
			                display(data);
			            },
			            error : function(e) {
			                console.log("ERROR: ", e);
			                display(e);
			            },
			            done : function(e) {
			                console.log("DONE");
			                enableSearchButton(true);
			            }
			        });
			    }

			    function enableSearchButton(flag) {
			        $("#btn-search").prop("disabled", flag);
			    }

			    function display(data) {
			        var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
			                + JSON.stringify(data, null, 4) + "&lt;/pre&gt;";
			        $('#feedback').html(json);
			    }
			</script>
			
		</div>

		<div class="container signin">
			<p>
				Already have an account? <a
					href="<%=request.getContextPath()%>/login">Sign in</a>.
			</p>
		</div>

	</form:form>


	<%@include file="/WEB-INF/views/layout/footer.jsp"%>
</body>
</html>