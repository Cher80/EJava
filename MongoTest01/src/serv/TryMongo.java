package serv;

import java.lang.reflect.Array;
import java.net.UnknownHostException;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

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
		
		DBCollection coll = db.getCollection("test");
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		// cur;
		//Array curLoaded = new Array[];
		List obj;
		for (int i=100;i<110;i++) {
			//System.out.println(i);
			query.clear();
			

			query.put("parent", i);
			//Pattern john = Pattern.compile("^sub13", Pattern.CASE_INSENSITIVE);
			//BasicDBObject query = new BasicDBObject("parent", john);
			//query.put("page", john);
        
			//collection.find( query ).skip( 1000 ).limit( 100 )
			//DBCursor cur = coll.find(query);
			obj = coll.find(query).toArray();
			System.out.println(obj);
			/*
			while(cur.hasNext()) {
				//System.out.println(cur.next());
				cur.next();
			}
			*/
			
		}
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		//System.out.println(myDate2);
		//Timestamp timeStampDate3 = timeStampDate2 - timeStampDate1;
		
		//Timestamp st = new Timestamp(System.currentTimeMillis());
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		
		
		
	}

}
