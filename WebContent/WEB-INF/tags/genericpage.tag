<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html>
	<head>
		<title>MNGoat</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
		 <link rel="stylesheet" href="${pageContext.request.contextPath}/css/w3style.css"> 
	</head>
  <body class="menu">
  <div class="wrapper">
    <div id="pageheader">
    	<ul class="hor">
		<li class="hor"><a href="${pageContext.request.contextPath}">
			<img height="100" src="${pageContext.request.contextPath}/images/goat22.png">
		</a></li>
			<li class="hor">
				<a href="${pageContext.request.contextPath}">Home</a>
			</li>
			<li class="hor">
				<a href="${pageContext.request.contextPath}/insurance">Insurance</a>
			</li>
			<li class="hor">
				<a href="${pageContext.request.contextPath}/safety/">Bike Safety</a>
			</li>
			<li class="hor">
				<a href="${pageContext.request.contextPath}/theft/">Theft Prevention</a>
			</li>
			
			<li class="hor">
				<a href="${pageContext.request.contextPath}/bikes/">Bike Parts</a>
			</li>
			<li class="hor">
				<a href="${pageContext.request.contextPath}/security/">Security Index</a>
			</li>
			
		</ul>
    </div>
    <div id="body" >
      <jsp:doBody/>
      
    </div>
    <div class="push"></div>
    </div>
    <footer class="footer"><!--  footer defined in genericpage.tag -->
    mngoat is a web application written in 2016 and 2017.  DHS OIS: 
    Source code and documentation at <a href="https://git.io/vHCNW">https://git.io/vHCNW</a></footer>
    
  </body>
</html>