<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
String output = "";
if(request.getParameter("abc") !=null){
	String req = request.getParameter("abc");
	if(req.equals("mcguire")){
		output = "Hello Tim";
	} else {
		output = req;
	}
} else {
	output = "NULL!";
}
request.setAttribute("output", output);
%>
<t:genericpage>

Not Protected!
OUTPUT IS ${output}
<br>


<h2>Hello World!</h2>
<a href="page2.jsp?arch=5">PAGE 2 (protected By ESAPI)</a><br>
<a href="page3.jsp?abc=5">PAGE 3 (Number Guessing - Protected by Input Validation)</a>

<a href="page4.jsp?lastName=Jones">PAGE 4 (NotProtected)</a>
</t:genericpage>