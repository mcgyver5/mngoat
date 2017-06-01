<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<hr>
<h3>This Page Shows EXIF Metadata of Uploaded images:</h3>

<br>
<c:forEach items="${fileList}" var="imageFile">
	<img width = "300" src="RetrievePicture?fileName=${imageFile.f.name}"><br>
	<c:forEach items="${imageFile.metaDataMap}" var="m">
	${m}<br>
	</c:forEach>
	<br>
	<a href="DeletePicture?fileName=${imageFile.f.name}">Delete This Photo</a>	<br>
	_________________________________________________________________________________<br>
</c:forEach>

</t:genericpage>