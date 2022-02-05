<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Restaurant</title>
</head>
<body>

	<form action="RestaurantServlet" method="post">
		Name: <input type="text" name="name"> 
		Address: <input type="text" name="address">
		Image: <input type="text" name="image">
		Phone: <input type="text" name="phone">
		Description: <input type="text" name="description">
		 <input type="submit" value="submit" />
	</form>
	
</body>
</html>