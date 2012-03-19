package my.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import my.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Searchdemo implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	public TextBox osCommerceUrlInput = new TextBox();
	
	public FlowPanel flowSearch = new FlowPanel();
	FlowPanel flowSearchSuggest = new FlowPanel();
	public TextBox osCommerceUrlInputFrom = new TextBox();
	public TextBox osCommerceUrlInputTo = new TextBox();
	public TextBox searchBox = new TextBox();
	public Label osCommerceFrom = new Label("products from");
	public Label osCommerceTo = new Label("to");
	public Button crawlButton = new Button("Crawl the pages");
	
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);
	private final SearchServiceAsync searchService = GWT
			.create(SearchService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		RootPanel.get().add(osCommerceUrlInput);
		osCommerceUrlInput.setText("http://topdjstore.com");
		
		RootPanel.get().add(osCommerceFrom);
		RootPanel.get().add(osCommerceUrlInputFrom);
		RootPanel.get().add(osCommerceTo);
		RootPanel.get().add(osCommerceUrlInputTo);
		RootPanel.get().add(crawlButton);
		

		RootPanel.get().add(flowSearch);
		flowSearch.add(searchBox);
//		flowSearch.add(flowSearchSuggest);

    	//panel.getElement().getStyle().setProperty("position", "absolute");
		flowSearch.setSize("500px", "500px");
		flowSearch.getElement().getStyle().setProperty("border", "1px solid red");
		flowSearch.getElement().setId("flowSearch");

		flowSearchSuggest.setSize("450px", "450px");
		flowSearchSuggest.getElement().getStyle().setProperty("border", "1px solid green");
		flowSearchSuggest.getElement().getStyle().setProperty("position", "absolute");
    	flowSearchSuggest.getElement().getStyle().setProperty("left", "50px");
    	flowSearch.add(flowSearchSuggest);

		
		//RootPanel.get().add(searchBox);

		

		
		//public Label  = new Label("?product=");

		osCommerceUrlInput.getElement().getStyle().setProperty("cssFloat", "left");
		osCommerceUrlInputFrom.getElement().getStyle().setProperty("cssFloat", "left");
		osCommerceUrlInputTo.getElement().getStyle().setProperty("cssFloat", "left");
		osCommerceFrom.getElement().getStyle().setProperty("cssFloat", "left");
		osCommerceTo.getElement().getStyle().setProperty("cssFloat", "left");
		//osCommerceFrom.getElement().getStyle().setProperty("cssFloat", "left");

		osCommerceUrlInputFrom.setWidth("30PX");
		osCommerceUrlInputTo.setWidth("30PX");
		//panel.getElement().getStyle().setProperty("border", "1px solid red");
		
		
		
		
		
		final Button sendButton = new Button("Send");
		final TextBox nameField = new TextBox();
		nameField.setText("GWT User");
		final Label errorLabel = new Label();

		
		
		
		
		// We can add style names to widgets
		sendButton.addStyleName("sendButton");

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel.get("nameFieldContainer").add(nameField);
		RootPanel.get("sendButtonContainer").add(sendButton);
		RootPanel.get("errorLabelContainer").add(errorLabel);

	
		
		
		
		// Focus the cursor on the name field when the app loads
		nameField.setFocus(true);
		nameField.selectAll();

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				sendButton.setEnabled(true);
				sendButton.setFocus(true);
			}
		});

		
		
		
		
		
		/////////////////////////CrawlHandler//////////////////////
		class CrawlHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public int osFrom;
			public int osTo;
			public int curProduct;
			
			public void onClick(ClickEvent event) {
				System.out.println("Crawl");
				
				osFrom = Integer.parseInt(osCommerceUrlInputFrom.getText());
				osTo = Integer.parseInt(osCommerceUrlInputTo.getText());
				curProduct = osFrom;
				System.out.println(osFrom);
				System.out.println(osTo);

	
				
				sendNameToServer();
			}
			
			public void doNext() {
				if (curProduct <osTo) {
					curProduct++;
					sendNameToServer();
				}
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				
				//ArrayList<String> urls = new ArrayList();
				
				//for (int i = osFrom;i<=osTo;i++) {
					//int curProduct = i;
					String urlToParse = osCommerceUrlInput.getText() + "/" + "index.php?route=product/product&product_id=" + curProduct;  
					System.out.println(urlToParse);
					//urls.add(urlToParse);
					
					greetingService.greetServer(urlToParse,
							new AsyncCallback<String>() {
								public void onFailure(Throwable caught) {
									
								}

								public void onSuccess(String result) {
									System.out.println(result);
									
									HTMLPanel resultPanel = new HTMLPanel (result);
									//Label resultLabel = new Label(result);
									//RootPanel.get().add(resultLabel);
									RootPanel.get().add(resultPanel);
									//RootPanel.get().add(crawlButton);
									
									doNext();
									//if (curProduct<=osTo) {
										//curProduct++;
									//}
									
								}
							});
					
					
					
			
							}
		}
		

		
		//////////////////////////Search handler/////////////////
		
		class SearchHandler implements ClickHandler, KeyUpHandler {

			public String curSearch = "";
			
			public void onClick(ClickEvent event) {
				
				System.out.println("Crawl");
	
				
				//sendSearchToServer();
			}
			

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				
				curSearch = searchBox.getText();
				//System.out.println(curSearch);
				//System.out.println("dds");
				if (curSearch.length()>1) {
					sendSearchToServer();
				}
				else {
					flowSearchSuggest.clear();
				}
				/*
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendSearchToServer();
				}*/
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void populateResults(Map result) {
				//System.out.println(result);
				//RootPanel.get("flowSearch").clear();
				flowSearchSuggest.clear();
				ArrayList titles = (ArrayList) result.get("titles");
				//System.out.println(titles);
				
				if (titles.size()>0) {
					Label titleLabel = new Label("Founded in Titles");
					titleLabel.getElement().getStyle().setBackgroundColor("#F2FFAB");
					flowSearchSuggest.add(titleLabel);
				}
				
				
				for(int i=0; i<titles.size(); i++) {
					//sum += ((Integer) ia[i]).intValue();
					System.out.println(titles.get(i));
					Map curTitle= (Map) titles.get(i);
					String titleText = (String) curTitle.get("text");
					String titleUrl = (String) curTitle.get("url");
					String titleImage = (String) curTitle.get("image");
					
					System.out.println(titleText);
					System.out.println(titleUrl);
					System.out.println(titleImage);

					ResultRow row = new ResultRow(titleText, titleUrl, titleImage);
					row.setStyleName("rowSearch");
					flowSearchSuggest.add(row);

				} 
				
				
				ArrayList descs = (ArrayList) result.get("descs");
				
				if (descs.size()>0) {
					Label descLabel = new Label("Founded in Description");
					descLabel.getElement().getStyle().setBackgroundColor("#F2FFAB");
					flowSearchSuggest.add(descLabel);
				}
				
				
				for(int i=0; i<descs.size(); i++) {
					//sum += ((Integer) ia[i]).intValue();
					System.out.println(descs.get(i));
					Map curTitle= (Map) descs.get(i);
					String titleText = (String) curTitle.get("text");
					String titleUrl = (String) curTitle.get("url");
					String titleImage = (String) curTitle.get("image");
					
					System.out.println(titleText);
					System.out.println(titleUrl);
					System.out.println(titleImage);

					
					ResultRow row = new ResultRow(titleText, titleUrl, titleImage);
					row.setStyleName("rowSearch");
					flowSearchSuggest.add(row);

				} 

			}
			
			
			private void sendSearchToServer() {
				
				
					
				searchService.searchServer(curSearch, osCommerceUrlInput.getText(),
							new AsyncCallback<Map>() {
								public void onFailure(Throwable caught) {
									
								}

								/*
								public void onSuccess(String result) {
									System.out.println(result);
																	
								}*/

								@Override
								public void onSuccess(Map result) {
									populateResults(result);
									
									// TODO Auto-generated method stub
									
								}
							});
					
					
					
			
							}
		}

		
		
		
		
		
		
		CrawlHandler crawlHandler = new CrawlHandler();
		crawlButton.addClickHandler(crawlHandler);

		SearchHandler searchHandler = new SearchHandler();
		searchBox.addClickHandler(searchHandler);
		searchBox.addKeyUpHandler(searchHandler);
		
		
		
		
		
		
		
		
		
		
		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				errorLabel.setText("");
				String textToServer = nameField.getText();
				if (!FieldVerifier.isValidName(textToServer)) {
					errorLabel.setText("Please enter at least four characters");
					return;
				}

				// Then, we send the input to the server.
				sendButton.setEnabled(false);
				textToServerLabel.setText(textToServer);
				serverResponseLabel.setText("");
				greetingService.greetServer(textToServer,
						new AsyncCallback<String>() {
							public void onFailure(Throwable caught) {
								// Show the RPC error message to the user
								dialogBox
										.setText("Remote Procedure Call - Failure");
								serverResponseLabel
										.addStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(SERVER_ERROR);
								dialogBox.center();
								closeButton.setFocus(true);
							}

							public void onSuccess(String result) {
								dialogBox.setText("Remote Procedure Call");
								serverResponseLabel
										.removeStyleName("serverResponseLabelError");
								serverResponseLabel.setHTML(result);
								dialogBox.center();
								closeButton.setFocus(true);
							}
						});
			}
		}

		// Add a handler to send the name to the server
		MyHandler handler = new MyHandler();
		sendButton.addClickHandler(handler);
		nameField.addKeyUpHandler(handler);
	}
}
