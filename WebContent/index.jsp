<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MNGoat</title>
</head>
<body>
 <%@ include file="header.jsp" %>
<h3>Welcome To MNGoat.</h3>
This is an application for selling bicycle insurance. 
<hr>
<h3>Menu</h3><br>
<a href=Insurance>Enter some Private data to sign up for Bicycle Insurance</a><br>
<a href=fileUploadForm.jsp>Upload a file.</a><br>
JSP Pages:<br>
<ul>
<li>
<a href=page1.jsp?abc=Minnesota>JSP Page 1</a></li>

<li><a href=page2.jsp?arch=5>Page 2:  Parameter arch protected by ESAPI</a></li>
<li><a href=page3.jsp>JSP page3  (Protected by input validation)</a></li>
</ul>

	
<!--  <a href=bunnyclick.html>Play bunnyclick, the most boring game in history.</a><br>-->
<a href="BikeTires">See some information about bicycle tires</a><br>
<a href=divide_by_zero.jsp>Test Error Page</a><br>
<a href=createPost.jsp>Create new Post</a><br>
<br><a href='Welcome'>Read Posts (Protected by JSoup)</a><br>

<h3>Admin Area (requires Login)</h3>
<hr>
<a href=admin/TestServlet>Administer Legislative Website</a><br>
<a href=admin/UserList>Manage Users</a><br>
<a href=admin/TestServlet>Buy Insurance</a><br>

<a href=admin/Feedback>Read User Feedback</a><br>
</body>
</html>