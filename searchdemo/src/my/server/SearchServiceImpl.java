package my.server;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.FilterIndexReader;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.Fragmenter;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;

import my.client.SearchService;

//import com.google.gwt.dev.util.collect.HashMap;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/** 
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class SearchServiceImpl extends RemoteServiceServlet implements
		SearchService {


	public List<Map> searchInFiled(String filed, String search, String url) {
		String toReturn =null; 
		List list = new ArrayList();
		URI uri = null;
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String host = uri.getHost();
		
		String indexDir = "/lucene/" + host;
		System.out.println(indexDir);
		
		Directory dir = null;
		try {
			dir = new SimpleFSDirectory(new File(indexDir), null);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("cant create dir");
		}
		
		
		IndexSearcher indexSearcher = null;
		try {
			indexSearcher = new IndexSearcher(FilterIndexReader.open(dir));
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		PrefixQuery prefixQuery = new PrefixQuery(new Term(filed,search));
		TopDocs topDocs = null;
		try {
			topDocs = indexSearcher.search(prefixQuery, 10);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //5
		
		System.out.println("Found " + topDocs.totalHits);

	
		for(int i=0;i<topDocs.scoreDocs.length;i++) {
			ScoreDoc scoreDoc = topDocs.scoreDocs[i];
			
			
			Document doc = null;
			try {
				doc = indexSearcher.doc(scoreDoc.doc);
			} catch (CorruptIndexException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

//			System.out.println(doc.get(filed));
			
			
			String str = doc.get(filed);
			String strreplace = "<b>" + search + "</b>";
			String resultBolded = str.replaceAll(search, strreplace);
			System.out.println(resultBolded);	
			


	        // adding or set elements in Map by put method key and value pair
			Map<Object,String> mp=new HashMap<Object, String>();

			mp.put("url", url);
	        mp.put("image", doc.get("image"));
	        mp.put("text", resultBolded);	
	        list.add(mp);
			} 
		
		try {
			indexSearcher.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return list;	
		
	}


	
	
	
	
	
	
	
	
	
	public Map<String, List> searchServer(String search, String url) throws IllegalArgumentException {
		String toReturn = search;
		System.out.println("hoho");
		
		List titleList = searchInFiled("title",search, url);
		List descList = searchInFiled("desc",search, url);
		
		Map<String, List> mp=new HashMap<String,List>();
		//mp.put("desc", "qq");
		//mp.put("title", "zz");

		
		mp.put("descs", descList);
		mp.put("titles", titleList);
		//searchInFiled("desc2",search, url);
//		searchInFiled("desc",search, url);
		return mp;
	}
	
	

}
