package utilities;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil extends BaseTest {
	
	final static Logger logger = Logger.getLogger(PropertyUtil.class);

	public static String value ;
	public static  String getProperty(String key)  {
		try {
			FileInputStream fs = new FileInputStream(".//src/test/resources/application.properties");
			Properties pt= new Properties();
			pt.load(fs);
			value =pt.getProperty(key).toString();
			logger.info("Value presnet in properties file for  "+key + " and value is" + value);
		}catch(IOException e) {
			
		}
		return value;
		
	}
	
	
}
