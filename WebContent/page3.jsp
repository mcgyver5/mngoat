<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
 <%@ include file="header.jsp" %>
<%! 
   public String stripParameter(String param) { 

		String s = "";
		//s = param;
		for (char a : param.toCharArray()){
			if(Character.isDigit(a)){
				s = s + a;
			} 
		}

        
		return s;
   } 
%>
<% 

out.println("<hr>");

int max = 100;
int min = 0;
java.util.Random rand = new java.util.Random();
int randomNum = rand.nextInt((max-min) + 1) + min;
if(request.getParameter("myguess") !=null){
	String req = request.getParameter("myguess");
	try{
		int n = Integer.parseInt(req);
		if(n==randomNum){
			out.println("<i>You Guessed the magic random number.  You get imaginary internet points</i>");
		} else {
			out.println("<i>Sorry, the random number was "+ randomNum);
			out.println("and you guessed: ");
			out.println(stripParameter(req));
			out.println("</i>");
		}
	} catch (NumberFormatException e){
		out.print("<b><i>NOT A NUMBER</i></b>");
	}

} else {
	out.println("<b><i>NULL!</i></b>");
}

%>
<hr>
See how good you are at guessing random numbers (between 1 and 100)
<form name=guessForm action=page3.jsp>
<br>Enter an integer between 0 and 100: <input type = text name=myguess ><br>
<input type = submit value=GUESS!>

</form>
<hr>
This is intellectual property, believe it or not.
</body>
</html>