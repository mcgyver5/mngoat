<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<form action = "BikeParts" method="GET">
Search String: <input type = "text" name="searchString">
<input type="submit" vale = "search">
</form>
Parts:
 <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID - Link</th>
          <th>Vendor</th>
          <th>Part</th>
          <th>Size</th>
          <th>Price</th>
			<th>Delete</th>

       </tr>
       <c:forEach items="${partList}" var="part" >
          <tr>
             <td><a href="${pageContext.request.contextPath}/PartDetail?partId=${part.id}">${part.id}</a></td>
             <td>${part.make}</td>
             <td>${part.model}</td>
             <td>${part.size}</td>
             <td>${part.price}</td>
             <td><a href="${pageContext.request.contextPath}/DeletePart?action=delete&partId=${part.id}">Delete</a>
          </tr>
       </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/partForm.jsp">Create new Part Entry</a>
</t:genericpage>