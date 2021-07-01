<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Input form</h2>
  <form:form action="./insert"  method="post" modelAttribute="newTutor">
  
    <div class="form-group">
      <label >Name:</label>
      <form:input type="text" path="name" required="required" />
    </div>
   
      <div class="form-group">
      <label >Address:</label>
      <form:input type="text" path="address" required="required" />
    </div>
    
        <div class="form-group">
      <label >Credential:</label>
      <form:input type="text" path="credential" required="required" />
    </div>
    
        <div class="form-group">
      <label >Experience Year:</label>
      <form:input type="number"  path="experienceYear" required="required"  />
    </div>
  
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>



</body>
</html>