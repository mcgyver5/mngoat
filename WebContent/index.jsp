<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
	<h3 class="menutext">Welcome To MNGoat.</h3>
	This is an application for selling bicycle insurance. 
	<hr>
	<h2 class = "menutext">Menu</h2>

	<h4 class="menu">File Uploads</h4>
	<a href=fileUploadForm.jsp>Upload a file.</a><br>
	<a href="PicturesServlet">View uploaded Pictures</a>
	<br>
	<br>
	<h4  class="menu">Simple JSP Pages:</h4>
	
	<ul>
	<li><a href=page1.jsp?abc=Minnesota>JSP Page 1</a></li>	
	<li><a href=page2.jsp?arch=5>Page 2:  Parameter arch protected by ESAPI</a></li>
	<li><a href=page3.jsp>JSP page3  (Protected by input validation)</a></li>
	<li><a href=divide_by_zero.jsp>Error Page</a></li>
		<li><a href="page4.jsp">JSP Page 4</a></li>
	</ul>
	<br>
	<h4  class="menu">Filters</h4>
	<ul>
	<li><a href=filters/scriptkeyword.jsp?lastName=Smith>Filter1:  Parameter lastName protected by keyword Filter</a></li>	
	<li><a href=filters/iterativeFilter.jsp?lastName=Johnson>Filter2:  Parameter lastName protected by Strong Filter</a></li>
	<li><a href=filters/filter3.jsp>Filter3: remove special characters as well :-( </a></li>
	</ul>
	<br>
	<h4  class="menu">Bicycles and Bike Parts</h4>
	<ul>
	<li><a href=bikeparts.jsp>Browse pictures of bike parts  (Not Protected)</a></li>
	<li><a href=bikepartsprotected.jsp>Browse pictures of bike parts  (Protected by Content Security Policy)</a></li>
	<li><a href="BikeParts">See some information about bicycle partss</a></li>	
	</ul>
	<br>
	<br>
	<h4 class="menu">Create and Read Posts:</h4>
	<ul>

	<li><a href=createPost.jsp>Create new Post</a></li>
	<li><a href='Welcome'>Read Posts (Protected by JSoup)</a></li>
	</ul>
	<br>
	<a href=admin/index.jsp>Admins Only</a>
	<br>
	<br>
	<h4 class="menu">Not Implmented Yet:</h4>
	<a href=Insurance>Enter some Private data to sign up for Bicycle Insurance</a><br>
	
</t:genericpage>