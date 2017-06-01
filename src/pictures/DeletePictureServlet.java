package pictures;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DeletePicture")
public class DeletePictureServlet  extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("attempting picture retrieve");
		
		String filename = request.getParameter("fileName");
		//System.out.println("filename is " + filename);
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		
		String filesDirString = filesDir.getAbsolutePath();
		File file = new File(filesDirString, filename);
		file.delete();
		
		 RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/PicturesServlet");
	        dispatcher.forward(request, response);  
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
