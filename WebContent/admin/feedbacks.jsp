<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Administrator</title>
</head>
<body>
 <%@ include file="adminHeader.jsp" %>
<h1>Site Feedback</h1>
<c:forEach items="${postList}" var="post" >
	<h2>${post.postTitle}</h2>
	<p>${post.postContent}</p>
	<br><a href="${pageContext.request.contextPath}/DeletePost?action=delete&postId=${post.postId}">Delete Post</a>
	<br>
	<hr>
</c:forEach>

</body>
</html>