<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<t:genericpage>

<c:forEach items="${postList}" var="post" >
	<h2>${post.postTitle}</h2>
	<p>${post.postContent}</p>
	<br><a href="${pageContext.request.contextPath}/DeletePost?action=delete&postId=${post.postId}">Delete Post</a>
	<br>
	<hr>
</c:forEach>

</t:genericpage>