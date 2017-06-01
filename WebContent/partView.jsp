<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<form class="w3-container w3-padding-16" action = "BikeParts" method="GET">
<br>
<label class="w3-text-blue"><b>Search String:</b></label> <input class="w3-input w3-border" type = "text" name="searchString">
<input class="w3-btn w3-blue" type="submit" value = "search">
</form>
<div></div>
<p   class="w3-blue w3-padding-8" style="text-shadow:1px 1px 0 #444"> You Searched for: <span class="w3-text-orange">"${searchString}"</span>
<p  class="w3-blue" style="text-shadow:1px 1px 0 #444"> Here is what we found:</p>
 <table class="w3-table-all" >
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
    <h4>>Hint:  SQL Query ends up looking like: select * from tire where tire_name like '%hhh%'
    </h4>
    <br>
    
    <a href="${pageContext.request.contextPath}/partForm.jsp"><button class="w3-button w3-khaki">Create new Part Entry</button></a>
    
</t:genericpage>