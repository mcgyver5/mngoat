

import java.io.File;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class FileLocationContextListener
 *
 */
@WebListener
public class FileLocationContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public FileLocationContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent servletContextEvent)  { 
    	System.out.println("using JAVA IO tmpdir: " + System.getProperty("java.io.tmpdir"));
        ServletContext ctx = servletContextEvent.getServletContext();
    	//System.out.println("tempfile.dir: " + ctx.getInitParameter("tempfile.dir"));
    	
    	 
        // String rootPath = System.getProperty("catalina.home");
    //    ServletContext ctx = servletContextEvent.getServletContext();
         //String relativePath = ctx.getInitParameter("tempfile.dir");
         String rootpath = System.getProperty("java.io.tmpdir");
         File file = new File(rootpath);
      //   if(!file.exists()){
       // 	 file.mkdirs();
       //  }
         System.out.println("File Dir created for storing uploaded files..............................");
         ctx.setAttribute("FILES_DIR_FILE", file);
         ctx.setAttribute("FILES_DIR", rootpath);
         
    }
	
}
