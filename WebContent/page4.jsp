<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<% 
if(request.getParameter("lastName") !=null){
	String lastName = request.getParameter("lastName");
	if(lastName.equals("mcguire")){
		out.println("Hello Tim");
	} else {
		// filter out the string "script":
		lastName = lastName.replaceAll("script","");
		out.println(lastName);
	}
} else {
	out.println("NULL!");
}

%>
<t:genericpage>
<script src="/mngoat/javascript/jquery-1.6.js"></script>


<!--  
 -->
<h2>Hello Page4!!!</h2>
<a href="page2.jsp?arch=5">PAGE 2 (protected By ESAPI)</a><br>
<a href="page3.jsp?abc=5">PAGE 3 (Number Guessing - Protected by Input Validation)</a>
<form name=theForm>
	The First<input id=radio1 type=radio name=rad1 value=1><br>
	SQ 2<input id=radio2 type=radio name=rad2 value=2><br>
	3 To Get Ready<input id=radio3 type=radio name=rad3 value=3><br>
	For What<input id=radio4 type=radio name=rad4 value=4><br>
<input type=submit>
</form>
<br>
<script>
if (location.hash){
	var myhash = decodeURIComponent(location.hash);

	$( "<h2 id='test'>My <em>new</em> text</h2>" ).appendTo( "body" );
	$(myhash).attr('checked',true);
	
}
</script>
</t:genericpage>