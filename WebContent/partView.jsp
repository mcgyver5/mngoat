<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<form action = "BikeTires" method="GET">
Search String: <input type = "text" name="searchString">
<input type="submit" vale = "search">
</form>
Tires:
 <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID - Link</th>
          <th>Vendor</th>
          <th>Tire</th>
          <th>Size</th>
          <th>Price</th>
			<th>Delete</th>

       </tr>
       <c:forEach items="${tireList}" var="tire" >
          <tr>
             <td>${tire.id}</td>
             <td>${tire.make}</td>
             <td>${tire.model}</td>
             <td>${tire.size}</td>
             <td>${tire.price}</td>
             <td><a href="${pageContext.request.contextPath}/DeleteTire?action=delete&tireId=${tire.id}">Delete</a>
          </tr>
       </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/tireForm.jsp">Create new Tire Entry</a>
</t:genericpage>