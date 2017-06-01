<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page session="true" %>

<t:genericpage>
<h2> Welcome!</h2>
<h3>Here is your account information.  Please Review</h3>
<table>
             <tr><td>Username</td><td><c:out value="${sessionScope.user.userName}"></c:out></td></tr>
             <tr><td>FirstName</td><td><c:out value="${sessionScope.user.firstName}"/></td></tr>
             <tr><td>LastName</td><td><c:out value="${sessionScope.user.lastName}"/></td></tr>
             <tr><td>email</td><td><c:out value="${sessionScope.user.emailAddress}"/></td></tr>
             <tr><td>Role</td><td><c:out value="${sessionScope.user.userRole}"/></td></tr>
			
</table>
<br>
<a href="EditUser">This Isn't Correct.  Let me edit my account information!</a><br>
<a href="CreateQuote">Create Quote</a>
</t:genericpage>