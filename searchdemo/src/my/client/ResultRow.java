package my.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.FocusPanel;
import com.google.gwt.user.client.ui.HTMLPanel;

public class ResultRow extends Composite {
	
	private FocusPanel focusPanel = new FocusPanel();
	
	public ResultRow(String text, String url, String image) {
		String html = "<img src=" + image + ">" + text;
		HTMLPanel content = new HTMLPanel(html);
		focusPanel.add(content);
		focusPanel.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				Window.open("http://www.google.com/", "_blank", "");

			}
		});
		//flowPanel.addC
		//= new HTMLPanel();
		
		initWidget(focusPanel);
	}

}
