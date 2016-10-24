<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
	<h3>Protected by ESAPI</h3><br>
	<%@ page import="java.util.List" %>
	<%@ page import="java.io.*,java.util.*,java.sql.*"%>
	
	<%@ page import="org.owasp.esapi.*" %>
	 <%@ include file="header.jsp" %>
	<% String result = request.getParameter("arch"); %>
	<body>
	<h2>Hello World!</h2>
	<%
	
	String result2 = ESAPI.encoder().encodeForHTML(result);
	%>
	<%=result2 %> IS Result
</t:genericpage>
