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
        <th>name</th>
        <th>Address</th>
        <th>Credential</th>
        <th>Year of Experience</th>
      </tr>
    </thead>
    <tbody>
   <c:forEach items="${Tutormenu}" var="tutor">
      <tr>
        <td>${tutor.id}</td>
        <td>${tutor.name}</td>
        <td>${tutor.address}</td>
         <td>${tutor.credential}</td>
       <td>${tutor.experienceYear}</td>
       <td>  <button class="delete" data-confirm="Are you sure to delete this item?" href="deleteTutor/${tutor.id}"> delete </button>
         <script > $('.delete').on("click", function (e) {
            e.preventDefault();
            var choice = confirm($(this).attr('data-confirm'));

            if (choice) {
                window.location.href = $(this).attr('href');
            }
            
        }); 
        </script>
   </td>
       
      <td>  <a href="editTutorPage?id=<c:out value='${tutor.id}'/> "> update</a></td>
      </tr>
     </c:forEach>
    </tbody>
    

  </table>
<a href="<%=request.getContextPath()%>/insertPage">insert</a>
</body>

</html>