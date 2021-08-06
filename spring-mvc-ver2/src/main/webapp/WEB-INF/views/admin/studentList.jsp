 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>

<head>
  <title>Tutor List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>

<body>

<table class="table table-condensed">
    <thead>
      <tr>
        <th>id</th>
        <th>Name</th>
        <th>Skill</th>
        <th>Address</th>
        <th>Phone number</th>
        <th>Grade</th>
        <th>Created by</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${studentmenu}" var="student">
      <tr>
        <td>${student.id}</td>
        <td>${student.studentName}</td>
         <td>${student.skill}</td>
        <td>${student.address}</td>
        <td>${student.phonenumber}</td>
         <td>${student.grade}</td>
<td>${student.fk_accountId }</td>

       <td>  <button  class="delete" data-confirm="Are you sure to delete this item?" href="deleteTutor/${student.id}"> delete </button>
         <script > $('.delete').on("click", function (e) {
            e.preventDefault();
            var choice = confirm($(this).attr('data-confirm'));

            if (choice) {
                window.location.href = $(this).attr('href');
            }
            
        }); 
        </script>
   </td>
       
      <td>  <a href="editStudentPage?id=<c:out value='${student.id}'/> "> update</a></td>
      </tr>
     </c:forEach>
    </tbody>
    

  </table>
<a href="<%=request.getContextPath()%>/insertPage">insert</a>
</body>

</html>