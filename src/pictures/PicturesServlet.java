package pictures;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	private Map cameraMake(File file){
		TiffField make = null;
		HashMap<String,String> metaDataMap = new HashMap<>();
		try {
			IImageMetadata metadata = Sanselan.getMetadata(file);
			if(metadata != null){
			for(Object x : metadata.getItems()){
				String xString = x.toString();
				String[] arr = xString.split(": ");
				// make, model, time, location, Software
				if(arr[0].contains("Software") || 
						arr[0].toUpperCase().equals("MODEL") ||
						arr[0].toUpperCase().equals("MAKE") ||
						arr[0].toUpperCase().contains("CREATE DATE")){
				metaDataMap.put(arr[0], arr[1]);
				}
			}
			if (metadata instanceof JpegImageMetadata) {
			      make = ((JpegImageMetadata) metadata).findEXIFValue(ExifTagConstants.EXIF_TAG_MAKE);
			      ((JpegImageMetadata) metadata).dump();
			      
			}
			}
			} catch (Exception e) {
				e.printStackTrace();
		
			}
		
		return metaDataMap;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		File[] files = filesDir.listFiles();
	    String fileName = "";
	    ArrayList<ImageDataObj> imageList = new ArrayList<>();

	    for (File f : files){
	    	fileName = f.getName();
	    	if(fileName.toUpperCase().endsWith(".JPG") || fileName.toUpperCase().endsWith(".PNG")){
	    		Map metaDataMap = this.cameraMake(f);
	    	
	    		ImageDataObj ido = new ImageDataObj(f,metaDataMap);
	    		imageList.add(ido);
	    	}
	    }
	    request.setAttribute("filesDir", filesDir.getAbsolutePath());
	    request.setAttribute("fileList",imageList);
	    
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
