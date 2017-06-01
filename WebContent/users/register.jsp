<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<table>
<form action="${pageContext.request.contextPath}/RegisterUser" method="post">
             <tr><td>Username</td><td><input  class="w3-input" name=userName></td></tr>
             <tr><td><label>FirstName</label></td><td><input class="w3-input" name=firstName></td></tr>
             <tr><td>LastName</td><td><input class="w3-input" name=lastName></td></tr>
             <tr><td>email</td><td><input class="w3-input" name=emailAddress></td></tr>
             <tr><td>password</td><td><input class="w3-input" name=password></td></tr>
             <tr><td></td><td>
			<input type=submit class="w3-input" value="register!"></td>
			</tr>
			</form>
</table>
</t:genericpage>