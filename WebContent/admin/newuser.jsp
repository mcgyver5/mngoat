<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create New User</title>
</head>
<body>
 <%@ include file="adminHeader.jsp" %>
<table>
<caption>Create a new User:</caption>

<form name="userForm" action="../admin/CreateUser" method="post">
<tr>
	<td>Full Name:</td>
	<td> <input type="text" name="fullname" ></td>
</tr>
<tr>
	<td>username:</td><td> <input type="text" name="username" ></td>
</tr>
<tr>
	<td>password:</td><td> <input type="text" name="password" > </td>
</tr>
<tr>
	<td>Role:</td><td> <input type="text" name="role" > </td>
</tr>
<tr>
	<td></td><td><input type = "submit" value="create"></td>
</tr>
</table>
</form>
</body>
</html>