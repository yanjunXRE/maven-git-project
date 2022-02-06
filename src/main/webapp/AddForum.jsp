<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h2>vertical (basic) form</h2>
<form action="ForumServlet" method="post">


 <div class="form-group">
      <label for="title">title:</label>
      <input type="title" class="form-control" id="title" placeholder="Enter title" name="title">
    </div>
    <div class="form-group">
      <label for="text">text:</label>
      <input type="text" class="form-control" id="text" placeholder="Enter text" name="text">
    </div>
    <div class="form-group">
      <label for="type">type:</label>
      <input type="type" class="form-control" id="type" placeholder="Enter type of comment" name="type">
    </div>
</select>
<input type = "submit" value="submit"/>
</form>
</div>



</body>
</html>