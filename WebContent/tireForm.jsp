<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>

<form name="tireForm" action="CreateTire" method="POST">
Brand: <input type="text" name="brand"><br>
Model: <input type="text" name="model"><br>
Manufacturer: <input type="text" name="model"><br>
Country of Origin: <input type="text" name="model"><br>

Price: <input type="text" name="price"><br>
Width (mm): <input type="text" name="width"><br>
Weight (g): <input type="text" name="weight"><br>
<input type="submit">
</form>
</t:genericpage>