package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {

	Properties p= new Properties();
	
	public Properties getObject(){
		InputStream stream = null;
		try {
			stream = new FileInputStream(new File("D:\\Automation\\SchoolAutomation\\src\\resources\\Login.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	try {
		p.load(stream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
	}
	
}

