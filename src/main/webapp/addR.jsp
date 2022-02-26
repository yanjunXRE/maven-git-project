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


	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Restaurants</h3>
			<hr>
			<div class="container text-left">
				<!-- Add new user button redirects to the register.jsp page -->
				<a id="successBut" href="<%=request.getContextPath()%>/restaurantList.jsp"
					class="btn btn-success">Add New Restaurant</a>
			</div>
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
							<td><image  height="200px" width="300px" src="<c:out value="${restaurant.image}"/>"/></td>
							<td><c:out value="${restaurant.phone}" /></td>
							<td><c:out value="${restaurant.description}" /></td>
							<!-- For each user in the database, Edit/Delete buttons which invokes the edit/delete functions -->
							<td>
							<a id="edit" href="edit?name=<c:out value='${restaurant.name}'/>">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
							<a id="delete" href="delete?name=<c:out value='${restaurant.name}' />">Delete</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>