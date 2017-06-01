<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="main">
		<!-- header -->
		<div id="header">
			<h1>We bet this is not what you expected to see here!<span>Application Had an Error</span></h1>
		</div>
		<!-- content -->
		<div id="content">
			<ul class="nav">
         	<li class="home"><a href="${pageContext.request.contextPath}">Home Page</a></li>
        
         </ul>
         <p>The page you requested was: <%=request.getParameter("url") %></p>
         <h2>Happy Halloween!</h2>
		</div>
		<!-- footer -->
		<div id="footer">
        </div>
	</div>



</body>
</html>