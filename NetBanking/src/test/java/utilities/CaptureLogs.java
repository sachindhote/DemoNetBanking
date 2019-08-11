package utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class CaptureLogs {
	
	public static Logger autologs(String TestName) {
		
		Logger logger = Logger.getLogger(TestName);
		PropertyConfigurator.configure("Log4j.properties");
		
		return logger;
	}

}
