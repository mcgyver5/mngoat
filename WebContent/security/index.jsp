<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
	<h3 class="menutext">Security Index:  Direct Links To Security Pages</h3>

	<h4 class="menu">File Uploads</h4>
	<ul class="hor">
	<li class="hor"><a href="${pageContext.request.contextPath}/fileUploadForm.jsp">Upload a file.</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/PicturesServlet">View uploaded Pictures</a></li>
	</ul>
	<br>
	
	<br>
	<h4  class="menu">Cross-site Scripting in JSP Pages:</h4>
	
	<ul class="hor">
	<li class="hor"><a href="${pageContext.request.contextPath}/page1.jsp?abc=Minnesota">JSP Page 1</a></li>	
	<li class="hor"><a href="${pageContext.request.contextPath}/page2.jsp?arch=5">Page 2:  Parameter arch protected by ESAPI</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/page3.jsp">JSP page3  (Protected by input validation)</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/divide_by_zero.jsp">Error Page</a></li>
		<li class="hor"><a href="${pageContext.request.contextPath}/page4.jsp">JSP Page 4</a></li>
	</ul>
	<br>
	<h4  class="menu">Cross Site Scripting Filters</h4>
	<ul class="hor">
	<li class="hor"><a href="${pageContext.request.contextPath}/filters/scriptkeyword.jsp?lastName=Smith">Filter1:  Parameter lastName protected by keyword Filter</a></li>	
	<li class="hor"><a href="${pageContext.request.contextPath}/filters/iterativeFilter.jsp?lastName=Johnson">Filter2:  Parameter lastName protected by Strong Filter</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/filters/filter3.jsp">Filter3: remove special characters as well :-( </a></li>
	</ul>
	<br>
	<h4  class="menu">Bicycles and Bike Parts</h4>
	<ul class="hor">
	<li class="hor"><a href="${pageContext.request.contextPath}/bikeparts.jsp">Browse pictures of bike parts  (Not Protected)</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/bikepartsprotected.jsp">Browse pictures of bike parts  (Protected by Content Security Policy)</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/BikeParts">See some information about bicycle partss</a></li>	
	</ul>
	<br>
	<br>
	<h4 class="menu">Create and Read Posts:</h4>
	<ul class="hor">

	<li class="hor"><a href="${pageContext.request.contextPath}/createPost.jsp">Create new Post</a></li>
	<li class="hor"><a href="${pageContext.request.contextPath}/Welcome">Read Posts (Protected by JSoup)</a></li>
	</ul>
	<br>
	<a href="${pageContext.request.contextPath}/admin/index.jsp">Admins Only</a>
	<br>
	<br>
	<h4 class="menu">Not Implmented Yet:</h4>
	<a href=Insurance>Enter some Private data to sign up for Bicycle Insurance</a><br>
	
</t:genericpage>