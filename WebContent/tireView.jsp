

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Bicycle Tire Data 4 You</title>
</head>
<body>
 <%@ include file="header.jsp" %>
<form action = "BikeTires" method="POST">
Search String: <input type = "text" name="searchString">
<input type="submit" vale = "search">
</form>
Tires:
 <table border="1" cellpadding="5" cellspacing="1" >
       <tr>
          <th>ID</th>
          <th>Vendor</th>
          <th>Tire</th>
          <th>Size</th>
          <th>Price</th>

       </tr>
       <c:forEach items="${tireList}" var="tire" >
          <tr>
             <td>${tire.id}</td>
             <td>${tire.make}</td>
             <td>${tire.model}</td>
             <td>${tire.size}</td>
             <td>${tire.price}</td>
            
          </tr>
       </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/tireForm.jsp">Create new Tire Entry</a>
</body>
</html>
