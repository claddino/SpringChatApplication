package ie.claddino.chat.utilities;

import java.io.Serializable;

public class CustomDate implements Serializable {
//TODO Add comments
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	java.util.Date dt = new java.util.Date();

	java.text.SimpleDateFormat sdf = 
	     new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	String currentTime = sdf.format(dt);
	
}
