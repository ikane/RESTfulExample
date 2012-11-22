<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>User Form</title>
	</head>
	
	<body>
		<h1>JAX-RS @FormQuery Testing</h1>
		
		<form action="rest/users/add" method="post">
			<p>
				Name : <input type="text" name="name" />
			</p>
			<p>
				Age : <input type="text" name="age" />
			</p>
			<input type="submit" value="Add User" />
		</form>
	</body>
</html>