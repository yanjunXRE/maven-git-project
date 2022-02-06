<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ForumServlet" method="post">
title:<input type="text" name="title">
text:<input type="text" name="text">
type:<select name = "type">
<option>Question</option>
<option>guide</option>
<option>answer</option>
</select>
<input type = "submit" value="submit"/>
</form>

</body>
</html>