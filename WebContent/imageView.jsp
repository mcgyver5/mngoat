<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<hr>
<h3>This Page Shows EXIF Metadata of Uploaded images:</h3>

<br>
<c:forEach items="${fileList}" var="imageFile">
	<img width = "300" src="RetrievePicture?fileName=${imageFile.name}"><br>
	
</c:forEach>
<c:forEach items="${cameraList}" var="camera">
	${camera}
	<br>
</c:forEach>
</t:genericpage>