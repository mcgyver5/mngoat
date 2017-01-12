<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<table>
             <tr><td>ID</td><td>${part.id}</a></td></tr>
             <tr><td>Brand</td><td>${part.make}</td></tr>
             <tr><td>Model</td><td>${part.model}</td></tr>
             <tr><td>size</td><td>${part.size}</td></tr>
             <tr><td>Price</td><td>${part.price}</td></tr>

</table>
</t:genericpage>