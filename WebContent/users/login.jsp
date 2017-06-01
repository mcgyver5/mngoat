<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

	Thank you for creating an account Please Login with your new credentials 
	<br>
		<form action="${pageContext.request.contextPath}/LoginServlet" method="post">
			<table>
			<tr><td>
			Please enter your username 		
			<input type="text"  class="w3-input" name="username"/><br>		
			</td></tr>
			<tr><td>
			<label>			Please enter your password</label>
			<input type="text"  class="w3-input" name="password"/>
			</td></tr>
			<tr><td>
			<input type="submit"  class="w3-input" value="Log In">			
			</td></tr>
			</table>
		</form>
</t:genericpage>