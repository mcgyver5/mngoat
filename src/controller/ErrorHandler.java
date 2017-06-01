package controller;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Handles Errors", urlPatterns = { "/ErrorHandler" })
public class ErrorHandler extends HttpServlet {
	 // Method to handle GET method request.
	  public void doGet(HttpServletRequest request,
	                    HttpServletResponse response)
	            throws ServletException, IOException
	  {
		  
	      // Analyze the servlet exception       
	      Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
	      Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
	      System.out.println("Here is error::::");
	      System.out.println(request.getAttribute("javax.servlet.error.message"));
	      String servletName = (String)
	      request.getAttribute("javax.servlet.error.servlet_name");
	      if (servletName == null){
	         servletName = "Unknown";
	      }
	      String requestUri = (String)
	      request.getAttribute("javax.servlet.error.request_uri");
	      if (requestUri == null){
	         requestUri = "Unknown";
	      }

	      // Set response content type
	      response.setContentType("text/html");
	 
		

	      if (throwable == null && statusCode == null){
	    	  System.out.println("Error information is missing");
	        
	      }else if (statusCode != null){
	    	  System.out.println("The status code : " + statusCode);
	    	  System.out.println("Error information");
		         System.out.println("Servlet Name : " + servletName );
		        
		         System.out.println("The request URI: " + requestUri );

	      }else{
	         System.out.println("Error information");
	         System.out.println("Servlet Name : " + servletName );
	         System.out.println("Exception Type : " + 
	                             throwable.getClass( ).getName( ) );
	         System.out.println("The request URI: " + requestUri);
	         System.out.println("The exception message: " + 
	                                 throwable.getMessage( ));
	      }

	      String ctx = request.getContextPath();
	      response.sendRedirect(ctx+ "/404.jsp?url="+ requestUri);
	  }
	  // Method to handle POST method request.
	  public void doPost(HttpServletRequest request,
	                     HttpServletResponse response)
	      throws ServletException, IOException {
		  System.out.println("error in post to post");
	     doGet(request, response);
	  }
}
