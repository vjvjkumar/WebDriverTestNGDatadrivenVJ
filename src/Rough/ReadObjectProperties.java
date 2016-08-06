package Rough;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadObjectProperties {
	public static void main(String[] args) throws Exception {
		
//create object for OR-properties
		Properties OR=new Properties();

//create object for FileInputStream-OR Properties
		FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/OR.properties");

//load the file in the properties file
		OR.load(ip);
		System.out.println(OR.getProperty("logLink"));
		System.out.println(OR.getProperty("logbuttonLOGIN"));



//create object for CONFIG properties
		Properties CONFIG=new Properties();

//create object for FileInputStream-CONFIG Properties
		FileInputStream cp=new FileInputStream(System.getProperty("user.dir")+"/src/com/gktech/config/config.properties");

//load the file in the CONFIG Properties file
		CONFIG.load(cp);
		System.out.println(CONFIG.getProperty("browsertype"));
		System.out.println(System.getProperty("user.dir"));
	}
}
