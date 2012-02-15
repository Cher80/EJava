package serv;

import java.lang.reflect.Array;
import java.net.UnknownHostException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import javax.print.Doc;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class TryMongo {
	private static Mongo m;
	private static DB db;
	
	
	
	
	public static void main(String [ ] args) throws UnknownHostException, MongoException
	{
		System.out.println("w");
		
		//Mongo m = new Mongo();
		m = new Mongo();
		

		db = m.getDB( "test" );
		
		/*
		Set<String> colls = db.getCollectionNames();

		for (String s : colls) {
		    System.out.println(s);
		}
		DBCollection coll = db.getCollection("test");

		DBObject myDoc = coll.findOne();
		System.out.println(myDoc);
		
		
		BasicDBObject query = new BasicDBObject();

        query.put("parent", 32);
        Pattern john = Pattern.compile("^sub1", Pattern.CASE_INSENSITIVE);
        //BasicDBObject query = new BasicDBObject("parent", john);
        query.put("page", john);
        
		DBCursor cur = coll.find(query);
		
		while(cur.hasNext()) {
            System.out.println(cur.next());
        }
		*/
		
		
		

		
	
		

		
		
		

	
		
		//createTestColl("testColl");
		//clearTestColl("testColl");
		//doUpdateComments();
		//doPopulateComments();
		doUpdateInc();
	}
	

	public static void createTestColl(String collName) {
		//db.createCollection("xcx");
		db.createCollection(collName, BasicDBObjectBuilder.start().add("capped", false).add("size", 0).add("max", 0).get());
	}
	
	public static void clearTestColl(String collName) {
		//DBCollection coll = db.getCollection("testColl");
		//db.getCollection("testColl").remove(BasicDBObjectBuilder.start().add(null,null).get());
		db.getCollection(collName).remove(new BasicDBObject());

		//db.createCollection("xcx");
		//db.createCollection(collName, BasicDBObjectBuilder.start().add("capped", false).add("size", 0).add("max", 0).get());
	}

	
	
	public static void doUpdateIncArray() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		//List obj;
		
		for (int i=21;i<22;i++) {
			
			
			BasicDBObject queryup = new BasicDBObject();
			queryup.append("page_id", i);
			
			BasicDBObject inc = new BasicDBObject("$inc", new BasicDBObject("rating", 1));
			
			
			coll.update(
					queryup,
					inc,
	        		true, 
	        		false);
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}
	
	
	
	public static void doUpdateInc() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		//List obj;
		
		for (int i=1;i<100000;i++) {
			
			
			BasicDBObject queryup = new BasicDBObject();
			queryup.append("page_id", i);
			
			BasicDBObject inc = new BasicDBObject("$inc", new BasicDBObject("rating", 1));
			
			
			coll.update(
					queryup,
					inc,
	        		true, 
	        		false);
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}
	
	
	
	
	
	
	public static void doUpdateComments() {
	
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		List obj;
		
		for (int i=1;i<100;i++) {
			
			
			
			for (int k=4;k<1000;k++) {
				BasicDBObject queryup = new BasicDBObject();
				queryup.append("page_id", i);
				BasicDBObject upd = new BasicDBObject();
				
				//ArrayList comments = new ArrayList();
				
				BasicDBObject comment1 = new BasicDBObject();
				comment1.append("cid", k);
				comment1.append("text", "Ololo1");
				comment1.append("rating", 0);
				//comments.add(comment1);
				
				upd.append("$push", new BasicDBObject().append("comments", comment1));
			
				coll.update(
					queryup,
					upd,
	        		true, 
	        		false);
				}
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		
			
		
	}
	
	
	
	///////////////////  Save  ///////////////////////////////////

	
	public static void doPopulateComments() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		List obj;
		
		for (int i=2;i<100000;i++) {
			BasicDBObject page = new BasicDBObject();
			page.put("page_id", i);
			page.put("rating", 0);
			//ArrayList x = new ArrayList();
			ArrayList comments = new ArrayList();
			
			BasicDBObject comment1 = new BasicDBObject();
			comment1.append("cid", 1);
			comment1.append("text", "Ololo1");
			comment1.append("rating", 0);
			
			BasicDBObject comment2 = new BasicDBObject();
			comment2.append("cid", 2);
			comment2.append("text", "Ololo2");
			comment1.append("rating", 0);
			
			BasicDBObject comment3 = new BasicDBObject();
			comment3.append("cid", 3);
			comment3.append("text", "Ololo3");
			comment1.append("rating", 0);
			
			comments.add(comment1);
			comments.add(comment2);
			comments.add(comment3);
			
			page.put("comments", comments);
			//page.comments("page_id", i);
			
			coll.insert(page);
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		

	}

}
