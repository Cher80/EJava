package my.server;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

import my.client.rpcs.GetForumService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class GetForumServiceImpl extends RemoteServiceServlet implements
		GetForumService {

	@Override
	public int getForum(int fid) {
		
		/*
		Mongo m = null;
		try {
			m = new Mongo();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MongoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		DB db = m.getDB( "leforum" );
		DBCollection coll = db.getCollection("forums");
		DBObject myDoc = coll.findOne();
		ServerLogger.getInstance().getLogger().log(Level.INFO, myDoc.toString());
		*/
		
		
		DB db = DBConnector.getInstance().getForumDB();
		//DBConnector.getInstance();
		
		// TODO Auto-generated method stub
		
		DBCollection coll = db.getCollection("forums");
		//DBCollection coll = db.getCollection("forums");

		DBObject myDoc = coll.findOne();
		Map mapDoc = myDoc.toMap();
		
		//mapDoc.get(arg0)
		//ServerLogger.getInstance().getLogger().log(Level.INFO, myDoc.toString());
		
		LinkedHashMap lhmDoc = (LinkedHashMap)myDoc;
		
		
		System.out.println(myDoc);
		System.out.println(lhmDoc);
		System.out.println(mapDoc);
		System.out.println(mapDoc.get("fid"));
		
		ArrayList groups = (ArrayList) mapDoc.get("groups"); 
		System.out.println(groups);
		
		Map group1 = (Map)groups.get(1);
		System.out.println(group1);
		
		ArrayList fids = (ArrayList) group1.get("fids"); 
		System.out.println(fids);

		Map fid1 = (Map)fids.get(1);
		System.out.println(fid1);

		Object curfid = fid1.get("fid");
		System.out.println(curfid);
		
		return fid*2;
	}

}
