<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<% 
if(request.getParameter("lastName") !=null){
	String lastName = request.getParameter("lastName");
	if(lastName.equals("mcguire")){
		out.println("Hello Tim");
	} else {
		out.println(lastName);
	}
} else {
	out.println("NULL!");
}

%>

<h2>Hello Page4!!!</h2>
<a href="page2.jsp?arch=5">PAGE 2 (protected By ESAPI)</a><br>
<a href="page3.jsp?abc=5">PAGE 3 (Number Guessing - Protected by Input Validation)</a>
<br>
</t:genericpage>