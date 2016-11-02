import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata;
import org.apache.sanselan.formats.tiff.TiffField;
import org.apache.sanselan.formats.tiff.constants.ExifTagConstants;


@WebServlet("/PicturesServlet")
public class PicturesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PicturesServlet() {
        super();
    }
    
    /**
     * expects jpg file
     * @param file
     * @return String containing make of camera used to take jpg.
     */
	private String cameraMake(File file){
		TiffField make = null;
		try {
			IImageMetadata metadata = Sanselan.getMetadata(file);
			if (metadata instanceof JpegImageMetadata) {
			      make = ((JpegImageMetadata) metadata).findEXIFValue(ExifTagConstants.EXIF_TAG_MAKE);
			      ((JpegImageMetadata) metadata).dump();
			      if(make != null){
			    	  return make.toString();
			      }
			}
			} catch (Exception e) {
				e.printStackTrace();
				return "";
			}
		if(make == null){
			return "No EXIF DATA";
		}
		return make.toString();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		File[] files = filesDir.listFiles();
	    String fileName = "";
	    File file = null;
	    ArrayList fileList = new ArrayList();
	    ArrayList cameraList = new ArrayList();
	    for (File f : files){
	    	fileName = f.getName();
	    	if(fileName.endsWith(".jpg")){
	    		fileList.add(f);
	    		cameraList.add(this.cameraMake(f));
	    		file = f;
	    	}
	    }
	    request.setAttribute("filesDir", filesDir.getAbsolutePath());
	    request.setAttribute("fileList",fileList);
	    request.setAttribute("cameraList", cameraList);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/imageView.jsp");
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
