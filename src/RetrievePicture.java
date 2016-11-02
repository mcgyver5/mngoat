

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.sanselan.ImageReadException;
import org.apache.sanselan.Sanselan;
import org.apache.sanselan.common.IImageMetadata;
import org.apache.sanselan.common.ImageMetadata;
import org.apache.sanselan.formats.jpeg.JpegImageMetadata;
import org.apache.sanselan.formats.tiff.TiffField;
import org.apache.sanselan.formats.tiff.TiffImageMetadata;
import org.apache.sanselan.formats.tiff.constants.ExifTagConstants;
import org.apache.sanselan.formats.tiff.write.TiffOutputSet;



/**
 * Servlet implementation class RetrievePicture
 */
@WebServlet("/RetrievePicture")
public class RetrievePicture extends HttpServlet {
	

	
	private void displayMetaData(File file){
		 try {
			IImageMetadata metadata = Sanselan.getMetadata(file);
			if (metadata instanceof JpegImageMetadata) {
				TiffImageMetadata exif = null;
				TiffOutputSet outputSet = null;
			      TiffField dateTimeValue = ((JpegImageMetadata) metadata).findEXIFValue(ExifTagConstants.EXIF_TAG_DATE_TIME_ORIGINAL);
			      TiffField model = ((JpegImageMetadata) metadata).findEXIFValue(ExifTagConstants.EXIF_TAG_LOCALIZED_CAMERA_MODEL);
			      TiffField make = ((JpegImageMetadata) metadata).findEXIFValue(ExifTagConstants.EXIF_TAG_MAKE);
			      ((JpegImageMetadata) metadata).dump();
			      if(make != null){
			    	  System.out.println(make);
			      }
			      
			      if(model != null){
			    	  String s = model.getStringValue();
			    	  System.out.println(s + " SHOULD BE THE MODEL");
			      }
			
			      IImageMetadata metadata2 = Sanselan.getMetadata(file);
			  	JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata2;
			  	if (jpegMetadata != null) {
			  		exif = jpegMetadata.getExif();

			  		if (exif != null) {
			  			outputSet = exif.getOutputSet();
			  			System.out.println(exif);
			  		}
			  	}
			      
			  } else {
				  System.out.println("Looks like metadata was not instanceof");
			  }
			
		} catch (Exception e) {
			System.out.println("some kind of error about could not get metadata from ");
			e.printStackTrace();
		}
		 
	}
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetrievePicture() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	System.out.println("attempting picture retrieve");
		
		String filename = request.getParameter("fileName");
		//System.out.println("filename is " + filename);
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		
		String filesDirString = filesDir.getAbsolutePath();
		File file = new File(filesDirString, filename);
		displayMetaData(file);
		
	    response.setHeader("Content-Type", getServletContext().getMimeType(filename));
	    response.setHeader("Content-Length", String.valueOf(file.length()));
	    response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");
	    Files.copy(file.toPath(), response.getOutputStream());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
