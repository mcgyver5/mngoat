<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Welcome to DHSGoat</title>
</head>
<body>
 <%@ include file="header.jsp" %>
<c:forEach items="${postList}" var="post" >
	<h2>${post.postTitle}</h2>
	<p>${post.postContent}</p>
	<br><a href="/DHSGoat/DeletePost?action=delete&postId=${post.postId}">Delete Post</a>
	<br>
	<hr>
</c:forEach>
</table>
</body>
</html>