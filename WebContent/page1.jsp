<html>
<head><title>Not Protected</title></head>
<body>
 <%@ include file="header.jsp" %>
<% 
if(request.getParameter("abc") !=null){
	String req = request.getParameter("abc");
	if(req.equals("mcguire")){
		out.println("Hello Tim");
	} else {
		out.println(req);
	}
} else {
	out.println("NULL!");
}

%>

<h2>Hello World!</h2>
<a href="page2.jsp?arch=5">PAGE 2 (protected By ESAPI)</a><br>
<a href="page3.jsp?abc=5">PAGE 3 (Number Guessing - Protected by Input Validation)</a>

<a href="page4.jsp?lastName=Jones">PAGE 4 (NotProtected)</a>
</body>
</html>