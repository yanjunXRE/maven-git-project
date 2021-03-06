<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="row">
<div class="container">
<h3 class="text-center">List of Users</h3>
<hr>
<div class="container text-left">
<!-- Add new user button redirects to the register.jsp page -->
<a href="<%=request.getContextPath()%>/register.jsp" class="btn btnsuccess">Add New User</a>
</div>
<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>Email</th>
<th>Password</th>

</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
<tbody>
<c:forEach var="user" items="${listUsers}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${user.email}" />
</td>
<td>
<c:out value="${user.password}" />
</td>

<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?email=<c:out value='${user.email}'
/>&password=<c:out value='${user.password}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?email=<c:out
value='${user.email}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</body>
</html>