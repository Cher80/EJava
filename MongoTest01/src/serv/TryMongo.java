package serv;

import java.lang.reflect.Array;
import java.net.UnknownHostException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
		

		db = m.getDB( "leforum" );
		
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
		
		
		

		
	
		

		
		
		

		//doUpdateCommentsDocument();
		//doPopulateCommentsAsDocument();
		//createTestColl("forums");
		//clearTestColl("forums");
		//doUpdateComments();
		//doPopulateComments();
		//doUpdateInc();
		//getFromArray();
		//doUpdateIncArray();
		//doFindSort();
		
		//New
		//doPopulateForums();
		//getAggregated_cid();
		doPopulateCommentsFlat();
		//doFindSortBigColl();
	}
	
///////////////Comments find/////////////
	public static void doFindSortBigColl() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		
		
		//List obj;
		
		
			
			
			BasicDBObject query = new BasicDBObject();
			query.append("cid", 245);
			//queryy.append("comments.cid", 232);
			
			
			DBCursor cur = coll.find(query).sort(new BasicDBObject("c_thread",1)).skip(420).limit(20);
			List res = cur.toArray();
			//System.out.println(cur.toArray());
			
			/*
			while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }*/
	
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}

	
	
	
	
	
	/////////////////Comments Collection Populate//////////////
	public static void doPopulateCommentsFlat() {

		DBCollection coll = db.getCollection("testColl");

		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();

		Random randomGenerator = new Random();

		for (int i=1000;i<2000;i++) {

			for (int s=1;s<1000;s++) {
				int randomInt = randomGenerator.nextInt(100);

				BasicDBObject comment = new BasicDBObject();
				comment.put("cid", i);
				comment.put("c_name", "Comment name " + randomInt);
				comment.put("c_thread", randomInt + "_" + s);
				comment.put("text", "Comment text" + randomInt + "_" + s);

				coll.insert(comment);
			}
		}
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());


		}

	
	
	
	
///////////////////  Aggregate  ///////////////////////////////////

	
	public static void getAggregated_cid() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		
			
	//	> db.forums.aggregate({$match:{"fid":2}},{$project:{"comments":1}},{$unwind:"$comments"},{$sort:{"comments.c_thread":1}}).explain()
		
		BasicDBObject cmdBody = new BasicDBObject("aggregate", "forums");
		ArrayList<BasicDBObject> pipeline = new	ArrayList<BasicDBObject>();

		/*
		BasicDBObject projectParam = new BasicDBObject("name", 1);
		        projectParam.put("state", 1);
		        pipeline.add(new BasicDBObject("$project", projectParam));
		      }*/

		 pipeline.add(new BasicDBObject("$match", new BasicDBObject("fid", 1210)  ));
		 pipeline.add(new BasicDBObject("$project", new BasicDBObject("comments", 1)  ));
		 pipeline.add(new BasicDBObject("$unwind", "$comments"  ));
		 pipeline.add(new BasicDBObject("$sort", new BasicDBObject("comments.c_thread", 1)  ));
		 pipeline.add(new BasicDBObject("$skip", 420));
		 pipeline.add(new BasicDBObject("$limit", 500));
	 
		 cmdBody.put("pipeline", pipeline);
		 BasicDBObject res = (BasicDBObject) db.command(cmdBody);
		 //System.out.println("result: " + res); 
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}

	
	
	
	
public static void doPopulateForums() {

DBCollection coll = db.getCollection("forums");

Date myDate1 = new Date();
Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
System.out.println(timeStampDate1);
BasicDBObject query = new BasicDBObject();


for (int s=1001;s<2000;s++) {
List obj;
BasicDBObject fid = new BasicDBObject();

fid.put("fid", s);
fid.put("rating", 0);

//BasicDBObject groups = new BasicDBObject();
ArrayList<BasicDBObject> groups = new ArrayList<BasicDBObject>();


for (int i=1;i<10;i++) {

	BasicDBObject group = new BasicDBObject();
	group.put("gid", i);
	group.put("name", "Group name " + i);

//ArrayList x = new ArrayList();
	ArrayList<BasicDBObject> fids = new ArrayList<BasicDBObject>();

	
	BasicDBObject group1 = new BasicDBObject();
	group1.append("fid", i*10 + 1);
	group1.append("name", "Sub forum number one" +(i*10 + 1));
	group1.append("rating", 0);

	BasicDBObject group2 = new BasicDBObject();
	group2.append("fid", i*10 + 2);
	group2.append("name", "Sub forum number two" +(i*10 + 2));
	group2.append("rating", 0);

	BasicDBObject group3 = new BasicDBObject();
	group3.append("fid", i*10 + 3);
	group3.append("name", "Sub forum number three" +(i*10 + 3));
	group3.append("rating", 0);


	fids.add(group1);
	fids.add(group2);
	fids.add(group3);

	group.put("fids", fids);
	groups.add(group);
//page.comments("page_id", i);

} 

fid.put("groups", groups);

////////////////Comments//////////////////////////////////
ArrayList<BasicDBObject> comments = new ArrayList<BasicDBObject>();

Random randomGenerator = new Random();

  

for (int i=1;i<1000;i++) {

	int randomInt = randomGenerator.nextInt(100);
	BasicDBObject comment = new BasicDBObject();
	comment.put("cid", randomInt);
	comment.put("c_name", "Comment name " + randomInt);
	comment.put("c_thread", randomInt + "_" + i);
	comment.put("text", "Comment text" + randomInt + "_" + i);


	comments.add(comment);
//page.comments("page_id", i);

} 

fid.put("groups", groups);
fid.put("comments", comments);

///////////////////////////////////////////


coll.insert(fid);

}
Date myDate2 = new Date();
Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
System.out.println(timeStampDate2);
System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());


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

	public static void getFromArray() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		
			
			
			BasicDBObject queryup = new BasicDBObject();
			//queryup.append("page_id", 2);
			queryup.append("comments.rating", 11);
			
			DBCursor cur = coll.find(queryup);
			
			while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
		
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}

	
	
	public static void doFindSort() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		//List obj;
		
		
			
			
			BasicDBObject queryy = new BasicDBObject();
			//query.append("page_id", i);
			queryy.append("comments.cid", 2);
			
			
			DBCursor cur = coll.find().sort(new BasicDBObject("comments.rating",+1)).limit(10);
			
			while(cur.hasNext()) {
	            System.out.println(cur.next());
	        }
	
		
		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
	}
	
	
	
	
	
	public static void doUpdateIncArray() {
		
		DBCollection coll = db.getCollection("testColl");
		
		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		BasicDBObject query = new BasicDBObject();
		
		//List obj;
		
		for (int i=1;i<100000;i++) {
			
			
			BasicDBObject queryup = new BasicDBObject();
			queryup.append("page_id", i);
			queryup.append("comments.cid", 2);
			
			//Works!
			//BasicDBObject inc = new BasicDBObject("$inc", new BasicDBObject("comments.0.rating", 1)); 
			//.update({"events.profile":10},{$set:{"events.$.handled":0}},false,true)	
			//YES!!!
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(100);
			
			BasicDBObject inc = new BasicDBObject("$inc", new BasicDBObject("comments.$.rating", randomInt));
			
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
			
			Random randomGenerator = new Random();
		    int randomInt = randomGenerator.nextInt(100);
			
			BasicDBObject inc = new BasicDBObject("$inc", new BasicDBObject("rating", randomInt));
			
			
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
		
		for (int i=1;i<100000;i++) {
			BasicDBObject page = new BasicDBObject();
			page.put("cid", i);
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
			comment2.append("rating", 0);
			
			BasicDBObject comment3 = new BasicDBObject();
			comment3.append("cid", 3);
			comment3.append("text", "Ololo3");
			comment3.append("rating", 3);
			
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

	
	
	
	
///////////////////  Save  ///////////////////////////////////

	
	public static void doPopulateCommentsAsDocument() {

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
			
			BasicDBObject comments = new BasicDBObject();
			
			BasicDBObject comment1 = new BasicDBObject();
			comment1.append("cid", 1);
			comment1.append("text", "Ololo1");
			comment1.append("rating", 0);
			
			BasicDBObject comment2 = new BasicDBObject();
			comment2.append("cid", 2);
			comment2.append("text", "Ololo1");
			comment2.append("rating", 0);
			
			BasicDBObject comment3 = new BasicDBObject();
			comment3.append("cid", 3);
			comment3.append("text", "Ololo1");
			comment3.append("rating", 3);
			

			comments.put("comment",comment1);
			comments.put("comment",comment2);
			comments.put("comment",comment3);

			page.put("comments", comments);
//page.put("comments", comments);
//page.comments("page_id", i);

			coll.insert(page);
		} 


		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());


	}
	
	
	
	
	
	public static void doUpdateCommentsDocument() {
		
		DBCollection coll = db.getCollection("testColl");

		Date myDate1 = new Date();
		Timestamp timeStampDate1 = new Timestamp(myDate1.getTime());
		System.out.println(timeStampDate1);
		

		List obj;

		for (int i=2;i<3;i++) {
			BasicDBObject query = new BasicDBObject();
			query.put("page_id", i);
			
			
			BasicDBObject comments = new BasicDBObject();
			BasicDBObject comment1 = new BasicDBObject();
			comment1.append("cid", 4);
			comment1.append("text", "Ololo4");
			comment1.append("rating", 0);

			BasicDBObject comment2 = new BasicDBObject();
			comment2.append("cid", 5);
			comment2.append("text", "Ololo5");
			comment2.append("rating", 0);

			BasicDBObject comment3 = new BasicDBObject();
			comment3.append("cid", 6);
			comment3.append("text", "Ololo6");
			comment3.append("rating", 0);

			comments.put("c0004",comment1);
			comments.put("c0005",comment2);
			comments.put("c0006",comment3);

//page.put("comments", comments);
//page.comments("page_id", i);
			BasicDBObject upd = new BasicDBObject();
			upd.append("$push", new BasicDBObject().append("comments", comment1));
			
			coll.update(
					query,
					comments,
	        		true, 
	        		false);
		
		} 


		Date myDate2 = new Date();
		Timestamp timeStampDate2 = new Timestamp(myDate2.getTime());
		System.out.println(timeStampDate2);
		System.out.println(timeStampDate2.getTime()-timeStampDate1.getTime());
		
			
		
	}
	
}
