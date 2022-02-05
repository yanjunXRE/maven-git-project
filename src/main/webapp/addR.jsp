<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Add Restaurant</title>
</head>
<body> 

	<form action="dashboard" method="post">
		Name: <input type="text" name="name"> Address: <input
			type="text" name="address"> Image: <input type="text"
			name="image"> Phone: <input type="text" name="phone">
		Description: <input type="text" name="description"> <input
			type="submit" value="submit" />
	</form>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Restaurants</h3>
			<hr>
			<br>
			<!-- Create a table to list out all current users information -->
			<table class="table">
				<thead>
					<tr>
						<th>Name</th>
						<th>Address</th>
						<th>Image</th>
						<th>Phone</th>
						<th>Description</th>
					</tr>
				</thead>
				<!-- Pass in the list of users receive via the Servlet response to a loop -->
				<tbody>
					<c:forEach var="restaurant" items="${listRestaurants}">
						<!-- For each user in the database, display their information accordingly -->
						<tr>
							<td><c:out value="${restaurant.name}" /></td>
							<td><c:out value="${restaurant.address}" /></td>
							<td><c:out value="${restaurant.image}" /></td>
							<td><c:out value="${restaurant.phone}" /></td>
							<td><c:out value="${restaurant.description}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td><a href="edit?name=<c:out value='${restaurant.name}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a	href="delete?name=<c:out
value='${restaurant.name}' />">Delete</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>