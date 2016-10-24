<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
	<head>
		<title>MNGoat</title>
	</head>
  <body>
    <div id="pageheader">
		<a href="${pageContext.request.contextPath}"><img height="100" src="images/goat22.png"><img height="100" src="images/goat22.png"></a><h4><a href="${pageContext.request.contextPath}">HOME</a></h4>
	<hr>
    </div>
    <div id="body">
      <jsp:doBody/>
    </div>
    <div id="pagefooter">
      <h4>Footer 445</h4>
    </div>
  </body>
</html>