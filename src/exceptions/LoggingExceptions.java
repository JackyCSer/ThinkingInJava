package exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;
// An exception that reports through a Logger.

public class LoggingExceptions
{
	public static void main(String [] args)
	{
		try{
			throw new LoggingException();
			
		}catch(LoggingException le)
		{
			System.err.println("Caught: " + le);
		}
		try{
			throw new LoggingException();
			
		}catch(LoggingException le)
		{
			System.err.println("Caught: " + le);
		}
	}
}


class LoggingException extends Exception 
{
	private static Logger logger = Logger.getLogger("LoggingException_M");
	public LoggingException()
	{
		StringWriter trace = new StringWriter();
		printStackTrace(new PrintWriter(trace));
		logger.severe(trace.toString());
	}
}
