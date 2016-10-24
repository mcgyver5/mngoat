<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="header.jsp" %>
<hr>
<h2>JSP File Upload Page</h2>
Three Ways:
<br>
To Wrong Directory
<br>
Contain Second Order SQL Injection
<br>
Contain De-Serialization Attack
<br>

<form action="${pageContext.request.contextPath}/FileUploadServlet" method="POST" enctype="multipart/form-data">
<input type="file" name="filename">
<input type="submit">
</form>
</body>
</html>