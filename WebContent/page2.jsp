<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ page import="java.util.List" %>
	<%@ page import="java.io.*,java.util.*,java.sql.*"%>
	
	<%@ page import="org.owasp.esapi.*" %>
	
<% 

String result = request.getParameter("arch"); 	
	String result2 = ESAPI.encoder().encodeForHTML(result);
	request.setAttribute("result2",result2);
	%>
<t:genericpage>
	<h3>Protected by ESAPI</h3><br>
	 	
	<body>
	<h2>Hello World!</h2>
	${result2} IS RESULT

</t:genericpage>
