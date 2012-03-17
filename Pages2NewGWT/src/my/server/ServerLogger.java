package my.server;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import my.ForumGlobalConfig;


public class ServerLogger {
	private static ServerLogger instance = null;
	private static Logger logger = Logger.getLogger("MyLog");;
	
	public ServerLogger() {
		  	//logger = 
		    FileHandler fh;
		    ConsoleHandler ch;
		    System.out.println("LoggerInited");
		    try {

		      fh = new FileHandler("/home/cher80/forum.txt", true);
		      ch = new ConsoleHandler(); 
		      logger.addHandler(fh);
		      logger.addHandler(ch);
		      logger.setLevel(Level.ALL);
		      SimpleFormatter formatter = new SimpleFormatter();
		      fh.setFormatter(formatter);

		      // the following statement is used to log any messages   
		      logger.log(Level.WARNING,"My first log");

		    } catch (SecurityException e) {
		      e.printStackTrace();
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
	}
	
	public static ServerLogger getInstance() {
		if(instance == null) {
				instance = new ServerLogger();	         
	      }
	      return instance;
	}
	
	public Logger getLogger() {
		return logger; 
	}
}
