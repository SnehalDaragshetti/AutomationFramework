package GenericUtilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * this class consists of generic methods related to properties file
 * @author Snehal
 * 
*/
public class PropertyFileUtilities {
	public String readFromPropertyFile(String key) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis = new FileInputStream(".\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
		
	}

}
