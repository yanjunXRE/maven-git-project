<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Forums</title>
<h1>Forums</h1>
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

</body>
</html>