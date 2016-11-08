<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage Users</title>
</head>
<body>
 <%@ include file="adminHeader.jsp" %>
<div>
	<form action="UserList" name = "searchForm" method="POST">
		Search By username:<input type="text" name="userName"><br>
		<!--  OR: Search By name:<input type="text" name="fullName"><br> -->
		<input type="submit" value="search">
	
	</form>
</div>
<table>


 <tr>
          <th>ID</th>
          <th>Name</th>
          <th>username</th>
          <th>password</th>
          <th>Role</th>
		  <th>Delete</th>
       </tr>
       <c:forEach items="${userList}" var="user" >
          <tr>
             <td>${user.userId}</td>
             <td>user</td>
             <td>${user.userName}</td>
             <td>....</td>
             <td>${user.userRole}</td>
             <td><a href="DeleteUser?userId=${user.userId}&action=delete">Delete</a>
            
          </tr>
       </c:forEach>

<a href=newuser.jsp>Create New User</a>
</table>
</body>
</html>