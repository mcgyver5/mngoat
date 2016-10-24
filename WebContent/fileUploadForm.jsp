<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

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
</t:genericpage>