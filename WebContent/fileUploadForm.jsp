<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<h2>Upload Pictures Here</h2>
This page accepts Image Files Only.<br>
<hr>

<form action="${pageContext.request.contextPath}/FileUploadServlet" method="POST" enctype="multipart/form-data">
<input type="file" name="filename">
<input type="submit">
</form>
</t:genericpage>