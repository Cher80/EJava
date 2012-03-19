package my.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.store.SimpleFSDirectory;
import org.apache.lucene.util.Version;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import my.client.GreetingService;
import my.shared.FieldVerifier;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	public String greetServer(String input) throws IllegalArgumentException {
		String toReturn = "pp";
		

		

		
//		doc.add(Field.Text("path", "www.venividi.ru");
		
		//IndexWriter.MaxFieldLength(int limit) 
		//Directory dir;// = new FSDirectory(new File(indexDir), null);
		//IndexWriter writer = new IndexWriter(dir,analyzer);
		//3
		//new StandardAnalyzer(), true,
		//IndexWriter.MaxFieldLength.UNLIMITED);

		
		
		//String toReturn;
		Document doc = null;
		try {
			doc = Jsoup.connect(input).get();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return toReturn = "ERROR! can't get URL";
			
		}
		
		//Document doc = Jsoup.parse(html);
		//Element link = doc.select("a").first();
		//td class="pagedescription"
		//Elements pngs = doc.select("div.pageHeading");
		
		URI uri = null;
		try {
			uri = new URI(input);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String host = uri.getHost();
		if (host.length() == 0) {
			host = "Host not founded";
		}

		System.out.println("Host =" + host);

				
		String title = doc.select("h1").text().toLowerCase();
		System.out.println("Product title = " + title);
		if (title.length() == 0) {
			title = "Title not founded, possible custom OpenCart skin";
		}
		
		String image = doc.select("div.image").select("img[src]").attr("src").toLowerCase();
		System.out.println("Product image = " + image);
		if (image.length() == 0) {
			image = "Image not founded, no image or possible custom OpenCart skin";
		}
		
		String desc = doc.select("div#tab-description").text().toLowerCase();
		System.out.println("Product desc = " + desc);
		if (desc.length() == 0) {
			desc = "Descriprition not founded, no description or possible custom OpenCart skin";
		}
		
		String desc2 = doc.select("div.description").text().toLowerCase();
		System.out.println("Product desc2 = " + desc2);
		if (desc2.length() == 0) {
			desc2 = "Descriprition2 not founded, no description2 or possible custom OpenCart skin";
		}		

		saveToLucene(doc,input, host, title, image, desc, desc2);
		
		
		toReturn = "<br/br/><b>Saved to lucene: OK</b><br/>" +
		"<b>Product URL:</b> " + input + "<br/>" +
		"<b>Product host:</b> " + host + "<br/>" +
		"<b>Product title:</b> " + title + "<br/>" +
		"<b>Product image:</b> " + image + "<br/>" +
		"<b>Product Text Description:</b> " + desc + "<br/>" +
		"<b>Product Bullet Fileds Description:</b> " + desc2 + "<br/>";
		
		//String title = doc.title();
		//toReturn = title;
		
		/*
		// Verify that the input is valid. 
		if (!FieldVerifier.isValidName(input)) {
			// If the input is not valid, throw an IllegalArgumentException back to
			// the client.
			throw new IllegalArgumentException(
					"Name must be at least 4 characters long");
		}

		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");

		// Escape data from the client to avoid cross-site script vulnerabilities.
		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		*/
		return toReturn;
	}
	
	
	public void saveToLucene(org.jsoup.nodes.Document jSoupDoc, String url, String host, String title, String image, String desc, String desc2) {
		//String toReturn;
		
//		Indexer indexer = new Indexer(indexDir);

		String indexDir = "/lucene/" + host; //Dir where Lucene index lives
		//String dataDir = "/home/cher80/test-files";  //Sub dir where www index live

		Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_35);
		//boolean recreateIndexIfExists = true;
		Directory dir = null;
		try {
			dir = new SimpleFSDirectory(new File(indexDir), null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("cant create dir");
		}
		//Directory index = new RAMDirectory();
		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_35, analyzer);
		IndexWriter w = null;
		
		try {
			w = new IndexWriter(dir, config);
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LockObtainFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String title = jSoupDoc.title();
		//System.out.println("Lucene seems OK " + title);
		
		
		
		org.apache.lucene.document.Document doc = new org.apache.lucene.document.Document();
		doc.add(new Field("title", title,Field.Store.YES, Field.Index.ANALYZED));
		doc.add(new Field("image", image,Field.Store.YES, Field.Index.ANALYZED));
		doc.add(new Field("desc", desc,Field.Store.YES, Field.Index.ANALYZED));
		doc.add(new Field("desc2", desc2,Field.Store.YES, Field.Index.ANALYZED));
		doc.add(new Field("path", url,Field.Store.YES, Field.Index.NOT_ANALYZED));

		try {
			w.updateDocument(new Term("path", url),doc);
		} catch (CorruptIndexException e1) { 
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		/*
		 try {
			w.addDocument(doc);
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 */
		try {
			w.close();
		} catch (CorruptIndexException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;")
				.replaceAll(">", "&gt;");
	}
}
