<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:genericpage>
	<h3 class="menutext">Welcome To MNGoat</h3>

	<div class="content">
	<div class="blurb">
		
	</div>
	<div id="member" class="content">
		
	</div>
	
	</div>
	<div class="w3-container w3-red w3-cell">
  <p>Already a member?  <a href="${pageContext.request.contextPath}/users/login.jsp">Login</a> to access your stuff and see what is new!</p>
</div>

<div class="w3-container w3-green w3-cell">
  <p>Join dozens of bike owners to document your bike and bike parts to best insure your bikes.<br>
		Get started by registering the site by <a id="begin" class="button" href="${pageContext.request.contextPath}/users/register.jsp">clicking here!</a>
	</p>
</div>
<br>
<br>
<div class="w3-container">
	<p><a href=admin/index.jsp>Admins Only</a></p>
	</div>
</t:genericpage>