package GenericUtilities;

import java.util.Date;

/**
 * this class consists of generic related to java
 * @author Snehal
 */

public class JavaUtility {
	public String getSystemDate() {
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String date = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+"_"+dArr[3].replace(":", "-");
		return date;
	}

}
