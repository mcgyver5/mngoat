<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

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
</t:genericpage>