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

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;

public class TryMongo {
	
	public static void main(String [ ] args) throws UnknownHostException, MongoException
	{
		System.out.println("w");
		
		//Mongo m = new Mongo();
		Mongo m = new Mongo();
		

		DB db = m.getDB( "test" );
		
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
		
		
		

		
		/*
		for (int i=3;i<100;i++) {
			System.out.println(i);
			BasicDBObject docin = new BasicDBObject();
			docin.put("cid", 999);
			docin.put("content", "tuta");
			
	        
	        coll.update(new BasicDBObject().append("page_id", 222), 
	        		//new BasicDBObject().append("page_id", 222),
	        		new BasicDBObject().append("$push", new BasicDBObject().append("comments", new BasicDBObject().append("cont", "fff"))),
	        		true, 
	        		false);

		} */
		

		
		
		

	DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		List obj;
		
		for (int i=1;i<3;i++) {
			
			BasicDBObject queryup = new BasicDBObject();
			queryup.append("page_id", i);
			
			BasicDBObject upd = new BasicDBObject();
			upd.append("$push", new BasicDBObject().append("comments", new BasicDBObject().append("cont", "fff")));
			
			coll.update(
					queryup,
					upd,
	        		true, 
	        		false);
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		
		
		
		
		
		//////////////////////////////////////////////////////

		/*
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		List obj;
		
		for (int i=2;i<20;i++) {
			BasicDBObject page = new BasicDBObject();
			page.put("page_id", i);
			
			//ArrayList x = new ArrayList();
			ArrayList comments = new ArrayList();
			
			BasicDBObject comment1 = new BasicDBObject();
			comment1.append("cid", 1);
			comment1.append("text", "Ololo1");
			
			BasicDBObject comment2 = new BasicDBObject();
			comment2.append("cid", 2);
			comment2.append("text", "Ololo2");
			
			comments.add(comment1);
			comments.add(comment2);
			
			page.put("comments", comments);
			//page.comments("page_id", i);
			
			coll.insert(page);
		} 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		
		*/
		
	}

}
