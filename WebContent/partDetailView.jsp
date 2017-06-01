<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
<div class="w3-display-middle w3-container w3-padding-16" style="height:300px;width:450px" >
<table class="w3-display-middle w3-table-all w3-card-4 w3-xlarge" >
<caption ><p class="w3-blue w3-padding-8" style="text-shadow:1px 1px 0 #444">Your Details for part #${part.id}</p></caption>
 
             <tr><td><b>Brand</b></td><td><u>${part.make}</u></td></tr>
             <tr><td><b>Model</b></td><td><u>${part.model}</u></td></tr>
             <tr><td><b>size</b></td><td><u>${part.size}</u></td></tr>
             <tr><td><b>Price</b></td><td><u>$${part.price}</u></td></tr>
			 
</table>
 </div>
<div class="w3-padding-16">
 <a href="${pageContext.request.contextPath}/BikeParts"><button class="w3-button w3-khaki">Back To Parts List</button></a>
 </div>

</t:genericpage>