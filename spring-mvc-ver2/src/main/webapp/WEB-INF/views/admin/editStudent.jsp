<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">

  <form:form  action="editStudent" method="post" modelAttribute="editedStudent">
  <h3 name ="id">Editting ${editedStudent.id} <form:hidden path="id"/></h3>
 
   <div class="form-group">
      <label >Name:</label>
      <td> <form:input path="studentName" type="text" class="form-control" id="urs" required="required" placeholder="Enter email" name="name"/>
    </div>
    
      <div class="form-group">
      <label >Address:</label>
     <td> <form:input path="address" type="text" class="form-control" id="urs" placeholder="Enter Address" name="address"/>
    </div>
    
          <div class="form-group">
      <label >Skill:</label>
     <td> <form:select path="skill" type="text" class="form-control" id="urs" placeholder="Enter Phone" name="address">
     									<form:option value="A">GOOD</form:option>
									<form:option value="B">IMMEDIATE</form:option>
									<form:option value="C">BASIC</form:option>
     </form:select>
    </div>
    
          <div class="form-group">
      <label >Phone number:</label>
     <td> <form:input path="phonenumber" type="text" class="form-control" id="urs" placeholder="Enter Address" name="address"/>
    </div>
    
        <div class="form-group">
      <label >Grade:</label>
      <form:input path="grade" type="text" class="form-control" id="urs" placeholder="Enter Credential" name="credential"/>
    </div>
    
  
  <form:hidden path="fk_accountId"/>
    <button type="submit" class="btn btn-default">Submit</button>
  </form:form>
</div>
</body>
</html>