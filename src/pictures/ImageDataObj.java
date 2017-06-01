package pictures;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ImageDataObj {
	// key-value list of metadata
	// file
	File f;
	Map<String,String> metaDataMap;
	public ImageDataObj(File f2, Map metaDataMap2) {
		this.f = f2;
		this.metaDataMap = metaDataMap2;
	}
	
	public File getF() {
		return f;
	}
	public void setF(File f) {
		this.f = f;
	}
	public Map<String, String> getMetaDataMap() {
		return metaDataMap;
	}
	public void setMetaDataMap(Map<String, String> metaDataMap) {
		this.metaDataMap = metaDataMap;
	}
	
}
