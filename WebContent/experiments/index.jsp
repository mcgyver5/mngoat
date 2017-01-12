<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
	<h3>Welcome To Experiments.</h3>
	The idea on this page is to call https resources on other sites and not get warned about certificates. What insecurities are introduced?

	<hr>
	<h2>Menu</h2>

	<h4>Call https web services</h4>
	<a href=fileUploadForm.jsp>DNR</a><br>
	<a href="PicturesServlet">SSL Labs API</a>
	<br>
	<br>
	<h4>Call https auth server:</h4>
	
	<ul>
	<li><a href=page1.jsp?abc=Minnesota>OAUTH</a></li>	
	<li><a href=page2.jsp?arch=5>Don't know nuthin about AUTH</a></li>
	<li><a href=page3.jsp>Auth is Auth</a></li>
	</ul>
	<br>
	<br>
	<h4>Load Iframe that comes from https website</h4>
	<ul>
	<li><a href=bikeparts.jsp>simple jsp with IFrame to https (browser will warn the user)</a></li>
	<li><a href=bikepartsprotected.jsp>Servlet will act as a kind of proxy and manage the interaction with the other site (essentially stripping the https out)grab the site and render it as its own.</a></li>
	<li><a href="BikeParts">CORS approach between http and https</a></li>	
	</ul>
	<br>
	<br>
	<h4>Download and save a file from a remote (https) site</h4>
	<ul>

	<li><a href=createPost.jsp>Create new Post</a></li>
	<li><a href='Welcome'>Read Posts (Protected by JSoup)</a></li>
	</ul>
	
	<h4>Finally, what are the differences when sha-1 is upgraded to sha-2?</h4>
	<a href=Insurance>Enter some Private data to sign up for Bicycle Insurance</a><br>
	
</t:genericpage>