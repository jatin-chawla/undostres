package undostres.testing.utilities;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class Getlogs {
	
	public static void logscapture(String classname, String message)
	{
	
	DOMConfigurator.configure("../Undostres/logfile.xml");
	Logger l = Logger.getLogger(classname);
	l.info(message);
	}
}
