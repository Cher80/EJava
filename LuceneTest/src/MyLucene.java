import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.UnknownHostException;

import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.CachingTokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spans.SpanScorer;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;




public class MyLucene {
	
	public static void main(String [ ] args) throws CorruptIndexException, IOException, ParseException  
	{
		System.out.println("hoho");
		Find();
	}
	
	public static void Find() throws CorruptIndexException, IOException, ParseException {
		System.out.println("Find");

		String indexDir = "/lucene/barringtonpottery.com"; //Dir where Lucene index lives
		
		Directory dir = null;
		try {
			dir = new SimpleFSDirectory(new File(indexDir), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cant create dir");
		}
		
		
		IndexSearcher indexSearcher = new IndexSearcher(FilterIndexReader.open(dir));

		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);

		//QueryParser parser = new QueryParser(Version.LUCENE_35, "content", analyzer); //4
		
		//Query query = parser.parse("papad");
		PrefixQuery prefixQuery = new PrefixQuery(new Term("desc","want"));
		
		//TermQuery query = new TermQuery(new Term("field", "fox"));
		
/*
		QueryScorer queryScorer = new QueryScorer(prefixQuery);
		SimpleSpanFragmenter simpleSpanFragmenter = new SimpleSpanFragmenter(queryScorer);
		Highlighter highlighter = new Highlighter(queryScorer);
		highlighter.setTextFragmenter(simpleSpanFragmenter);
	*/	
		/*
		try {
			highlighter.getBestFragment(analyzer, "desc", "six");
		} catch (InvalidTokenOffsetsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

		
		
		TopDocs topDocs = indexSearcher.search(prefixQuery, 10); //5
		System.out.println("Found " + topDocs.totalHits);

		
		for(int i=0;i<topDocs.scoreDocs.length;i++) {
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			Document doc = indexSearcher.doc(scoreDoc.doc);
			System.out.println(doc.get("path"));
			System.out.println(doc.get("title"));
			System.out.println(doc.get("desc"));
			
			TermQuery query = new TermQuery(new Term("desc", "want"));
			TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(doc.get("desc")));

			QueryScorer scorer = new QueryScorer(query);

			Fragmenter fragmenter = new SimpleSpanFragmenter(scorer, 40);
			Highlighter highlighter = new Highlighter(scorer);
			highlighter.setTextFragmenter(fragmenter);
			//SpanScorer scorer = new SpanScorer(query, "field",new CachingTokenFilter(tokenStream));

			
			/*
			try {
				highlighter.getBestFragment(analyzer, "desc", "six");
			} catch (InvalidTokenOffsetsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			
			String result = null;
			 try {
				 result =
						    highlighter.getBestFragments(
						    tokenStream,
						    doc.get("desc"),
						    2,
						    "...");
			} catch (InvalidTokenOffsetsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(result);
			 
			/*
			TokenStream tokenStream = analyzer.tokenStream("desc", new StringReader(doc.get("desc")));
			SpanScorer scorer = new SpanScorer(prefixQuery, "desc", 	new CachingTokenFilter(tokenStream));
					Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);
					Highlighter highlighter = new Highlighter(scorer);
					highlighter.setTextFragmenter(fragmenter);
					//assertEquals("The quick brown <B>fox</B> jumps over th
					highlighter.getBestFragment(tokenStream, text);
				*/
			}
		indexSearcher.close();


		/*
		ScoreDoc[] scoreDosArray = topDocs.scoreDocs;	
		   for(ScoreDoc scoredoc: scoreDosArray){
		      //Retrieve the matched document and show relevant details
		      Document doc = indexSearcher.doc(scoredoc.doc);
		      System.out.println("path: "+doc.;

		      //System.out.println("\nSender: "+doc.getField("sender").stringValue());
		      //System.out.println("Subject: "+doc.getField("subject").stringValue());
		      //System.out.println("Email file location: "+doc.getField("emailDoc").stringValue());	
		   }*/

	}


}
