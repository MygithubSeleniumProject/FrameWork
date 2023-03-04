package genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property_utility {

	/*
	 * 
	 * this method is used to login to application
	 * @author santoshi
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
public String getKeyValue(String Key) throws Throwable {
	FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties.txt");
    Properties pro = new Properties();
     pro.load(fis);
     String Value = pro.getProperty(Key);
     return Value;
     
}
}
