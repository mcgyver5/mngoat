<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%
String width = "";
if(request.getParameter("width") == null){
	width = "";
} else {
	width = request.getParameter("width");
}

String bgcolor = "";
if(request.getParameter("bgcolor") == null){
	bgcolor = "";
} else {
	bgcolor = request.getParameter("bgcolor");
}


request.setAttribute("bgcolor",bgcolor);
request.setAttribute("width",width);
%>

<t:genericpage>

<style>
img.med {
	width:${width};
}
figure {
	border: 2px solid;
	background-color: ${bgcolor};	
}
</style>
<h1>Bike Parts II</h1>
<form method="get" action="bikeparts.jsp">
Select Image Width:
<select name = width onchange="document.forms[0].submit()">
	<option value=100>100</option>
	<option value=200>200</option>
	<option value=300>300</option>
	<option value=400>400</option>
</select><br>
Select background color:
<select name = bgcolor onchange="document.forms[0].submit()">
	<option value=blue>blue</option>
	<option value=red>red</option>
	<option value=green>green</option>
	<option value=yellow>yellow</option>
</select>

</form>
<figure>
<img class="med" src = "images/rear_droput.jpg">
<figcaption>rear dropout</figcaption>
</figure>
<br>
<figure>
<img class="med" src = "images/chainstay.jpg">
<figcaption>chainstay</figcaption>
</figure><!--  <br><img class="med" src = "images/chainring.jpg">
 --><figure>
<br><img class="med" src = "images/front_derailleur.jpg">
<figcaption>Front derailleur</figcaption>
</figure>
<figure>
<br><img class="med" src = "images/bottom_bracket.jpg">
<figcaption>bottom bracket</figcaption>
</figure>
<figure>
<br><img class="med" src = "images/seatpost.jpg">
<figcaption>Seat post</figcaption>
</figure>
<br>
</t:genericpage>
