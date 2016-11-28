<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<% 
if(request.getParameter("lastName") !=null){
	String lastName = request.getParameter("lastName");
	if(lastName.equals("mcguire")){
		out.println("Hello Tim");
	} else {
		// filter out the string "script":
		lastName = lastName.replaceAll("script","");
		out.println(lastName);
	}
} else {
	out.println("NULL!");
}

%>
<t:genericpage>
<script src="/mngoat/javascript/jquery-1.6.js"></script>


<!--  
 -->
<h2>This page filters script tags by not allowing the string "script"</h2>

<br>

</t:genericpage>