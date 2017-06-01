<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage>
<div class="w3-panel w3-blue w3-round-xlarge">
  <h2>Add To Database of Bike Parts!  Customers Build It!</h2>
  <p>Please Round to nearest dollar</p>
</div>
<div class="w3-container w3-teal w3-padding-16">
<form name="partForm" action="CreatePart" method="POST">
<div class="w3-row-padding">
<div class="w3-half">
<label>Brand</label> <input class="w3-input w3-border" type="text" name="brand"></div>
<div class="w3-half">
<label>Model:</label> <input class="w3-input w3-border" type="text" name="model">
</div>
<div class="w3-half">
<label>Manufacturer:</label> <input class="w3-input w3-border" type="text" name="model">
</div>
<div class="w3-half">
<label>Country of Origin:</label> <input class="w3-input w3-border" type="text" name="model">
</div>
<div class="w3-half">
<label>Price:</label> <input class="w3-input w3-border" type="text" name="price">
</div>
<div class="w3-half">
<label>Width (mm):</label> <input class="w3-input w3-border" type="text" name="width">
</div>
<div class="w3-half w3-padding-16">
<label>Weight (g): </label><input class="w3-input w3-border" type="text" name="weight">
</div>
<div class="w3-half  w3-padding-16">
<label>Part Type </label><input class="w3-input w3-border" type="text" name="partType">
</div>
<input class="w3-input" type="submit" value="==Save==">
</div>
</form>
</div>
</t:genericpage>