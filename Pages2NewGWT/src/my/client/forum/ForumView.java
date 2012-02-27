package my.client.forum;

import my.client.common.ClientFactoryImpl;
import my.client.compos2.IMyComposite2View.Presenter;
import my.client.theme.ThemeActivity;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SimplePanel;

public class ForumView extends Composite implements ForumViewInterface{
	
	private ScrollPanel panel = new ScrollPanel();
	private Presenter presenter;
    private String name;
    private Button myButt1 = new Button("ForumView");
    private FlowPanel commentsPanel = new FlowPanel();
    
    public ForumView() {
    	System.out.println("ForumView constructor");
		//panel.getElement().getStyle().setProperty("cssFloat", "left");
		//panel.getElement().getStyle().setProperty("border", "1px solid red");
		//panel.add(myButt1);
		
    	//panel.getElement().getStyle().setProperty("border", "3px solid red");
    	
    	
    	
    	//ScrollPanel panel = new ScrollPanel();
    	panel.getElement().getStyle().setProperty("position", "absolute");
    	panel.setSize("200px", "100px");
    	panel.getElement().getStyle().setProperty("border", "1px solid green");
    	panel.getElement().getStyle().setProperty("cssFloat", "left");
    	panel.getElement().getStyle().setProperty("left", "200px");
    	
    	
    	
    	for (int i=0;i<30;i++) {
    		
    		//ThemeActivity myThemeActivity = new ThemeActivity ();
    		//myThemeActivity.start(panel, (new ClientFactoryImpl()).getEventBus());
    		/*
    		SimplePanel commentPanel = new SimplePanel();
    		//commentPanel.setSize("200px", "120px");
    		//commentPanel.addStyleName("demo-panel");

    		Label label = new Label("Label");
    		//label.setWidth("100px");
    		//label.setStyleName("demo-label");
    		commentPanel.add(label);
    		commentsPanel.add(commentPanel);
    		//panel.*/
    	}
    	
    	panel.add(commentsPanel);
		//myEventBus.addHandler(ComposedEvent.TYPE, new MyCompositeEventHandler2());
		//SimpleEventBusSingleton.getInstance().addHandler(ComposedEvent.TYPE, this);
		
		myButt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//MyButt1.setText("FromPCCliknul!");
				//myButt1.setText("Cliknul!");
				//myButt1.setText("OereCliknul!");
				//myButt1.setText("VfrOereCliknul!");
				//myButt1.setText("BiBiVfrOereCliknul!");
				//myButt1.setText("MacBiBiVfrOereCliknul!");
				myButt1.setText("ForumViewCliknul!");
				//presenter.goToCompos1New();
				//ComposedEvent myEvent = new ComposedEvent(654);
				//myEvent.dispatch(new MyCompositeEventHandler());
			}
		});
		
		initWidget(panel);
	}
    
    
    public void populate() {
    	for (int i=0;i<30;i++) {
    		
    		ThemeActivity myThemeActivity = new ThemeActivity (commentsPanel, presenter.getClientFactory());
    		myThemeActivity.setForumId(i);
    		//myThemeActivity.start(panel, presenter.getClientFactory().getEventBus());
    		/*
    		SimplePanel commentPanel = new SimplePanel();
    		//commentPanel.setSize("200px", "120px");
    		//commentPanel.addStyleName("demo-panel");

    		Label label = new Label("Label");
    		//label.setWidth("100px");
    		//label.setStyleName("demo-label");
    		commentPanel.add(label);
    		commentsPanel.add(commentPanel);
    		//panel.*/
    	}
    }
    
    
    @Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
		//this.forumNumber
	}

	@Override
	public void setName(String composName) {
		// TODO Auto-generated method stub
		
	}

}
