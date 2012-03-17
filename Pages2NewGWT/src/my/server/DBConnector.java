package my.server;

import java.net.UnknownHostException;
import java.util.logging.Level;

import my.ForumGlobalConfig;

import com.allen_sauer.gwt.log.client.Log;
import com.mongodb.DB;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class DBConnector {

	private  Mongo m;
	private  DB db;
	private static DBConnector instance = null;
	
	public DBConnector() throws UnknownHostException, MongoException {
		//Mongo m = null;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		db = m.getDB( "leforum" );
		
		/*
		m = new Mongo( ForumGlobalConfig.DB_SERVER_NAME , ForumGlobalConfig.DB_SERVER_PORT );

		
		db = m.getDB( ForumGlobalConfig.DB_FORUM_DBNAME );
		ServerLogger.getInstance().getLogger().log(Level.INFO,db.getLastError().toString());
		*/
		//sys
		
		//db.getLastError();
		
	}
	
	public static DBConnector getInstance() {
		//Log.debug("DBConnector getInstance");
		ServerLogger.getInstance().getLogger().log(Level.INFO,"DBConnector getInstance");
		if(instance == null) {
	         try {
				instance = new DBConnector();
				//System.out.println("MongoDB connected");
				ServerLogger.getInstance().getLogger().log(Level.INFO,"MongoDB connected");
				//Log.debug("MongoDB connected");
			} catch (UnknownHostException e) {
				//Log.debug("Mongo UnknownHostException");
				ServerLogger.getInstance().getLogger().log(Level.INFO,"Mongo UnknownHostException");
				e.printStackTrace();
			} catch (MongoException e) {
				// TODO Auto-generated catch block
//				Log.debug("MongoException");
				ServerLogger.getInstance().getLogger().log(Level.INFO,"MongoException" + e.toString());
				e.printStackTrace();
			}
	         
	      }
	      return instance;
	}
	
	
	public DB getForumDB() {
		return db;
	}
	
	
	
}
