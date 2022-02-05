
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forums</title>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
crossorigin="anonymous">
</head>
<body>
<form action="ForumServlet" method="post">
	Title: <input type="text" name="title">
	Text: <input type="text" name="text">
	type: <select name="type">
		<option>question</option>
		<option>guide</option>
		<option>others</option>
	</select>
	<input type="submit" value="submit"/>
</form>

<div class="row">
<div class="container">
<h3 class="text-center">Forum</h3>
<hr>



<br>
<!-- Create a table to list out all current users information -->
<table class="table">
<thead>
<tr>
<th>title</th>
<th>Type</th>
<th>Text</th>


<th>Actions</th>
</tr>
</thead>
<!-- Pass in the list of users receive via the Servlet’s response to a loop
-->
<tbody>
<c:forEach var="forum" items="${listForums}">
<!-- For each user in the database, display their
information accordingly -->
<tr>
<td>
<c:out value="${forum.title}" />
</td>

<td>
<c:out value="${forum.type}" />
</td>
<td>
<c:out value="${forum.text}" />
</td>

<!-- For each user in the database, Edit/Delete
buttons which invokes the edit/delete functions -->
<td>
<a href="edit?title=<c:out value='${forum.title}'
/>">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;
<a href="delete?title=<c:out
value='${forum.title}' />">Delete</a>
</td>
</tr>
</c:forEach>
</tbody>
</table>

</div>
</div>
</body>
</html>