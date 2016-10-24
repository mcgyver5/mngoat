
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Site Feedback</title>
</head>
<body>
 <%@ include file="header.jsp" %>
<form action="${pageContext.request.contextPath}/CreatePostServlet" Method="POST">

Post Title:<input type="text" name="postTitle"><br>
Post Content:
<textarea name="postContent">
</textarea>

<input type="submit">
<hr>
<hr>
<br>
LLLLLLLLLLLLLLLLLL
</form>
</body>
</html>
