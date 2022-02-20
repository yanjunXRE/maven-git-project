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
<title>Insert title here</title>
</head>
<body>
	<div class="container"> 
		<h2>Add Restaurant</h2>
		<form action="RestaurantServlet" method="post">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text" class="form-control" id="name" placeholder="Enter Name"	name="name">
			</div>
			<div class="form-group">
				<label for="address">Address:</label> <input type="text" class="form-control" id="address" placeholder="Enter Address"	name="address">
			</div>
			<div class="form-group">
				<label for="image">Image:</label> <input type="text" class="form-control" id="image" placeholder="Enter Image"	name="image">
			</div>
			<div class="form-group">
				<label for="phone">Phone:</label> <input type="text" class="form-control" id="phone" placeholder="Enter Phone"	name="phone">
			</div>
			<div class="form-group">
				<label for="description">Description:</label> <input type="text" class="form-control" id="description" placeholder="Enter Description"	name="description">
			</div>
			<button  type="submit" class="btn btn-danger">Add</button>

		</form>
	</div>

</body>
</html>