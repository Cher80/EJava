package my.client;

//import my.client.MyComposite;
import my.client.common.AppActivityMapper;
import my.client.common.AppPlaceHistoryMapper;
import my.client.common.ClientFactory;
import my.client.common.MyActivityManager;
import my.client.common.MyFlowPanel;
import my.client.common.MySimpleLayoutPanel;
import my.client.common.PanelForView;
import my.client.compos.ComposedEvent;
import my.client.compos.MyComposite;
import my.client.compos.MyCompositePlace;
import my.client.compos2.MyComposite2;
import my.client.compos.MyCompositeEventHandler;
import my.client.compos.MyCompositeEventHandler2;
import my.client.forum.ForumPlace;
import my.client.topmenu.TopmenuView;
import my.shared.FieldVerifier;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
//import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExtraNewGWT implements EntryPoint {
	
	private Place defaultPlace = new ForumPlace("34");
	private PanelForView appWidNew = new PanelForView();
    private SimplePanel appWidget = new SimplePanel();
    private SimplePanel appWidgetOld = new SimplePanel();
    private FlowPanel menuWidgetPanel = new FlowPanel();
    
    //private MySimpleLayoutPanel appWidNewNew = new MySimpleLayoutPanel();
    private MyFlowPanel appWidNewNew = new MyFlowPanel();
    private FlowPanel container = new FlowPanel();
    

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		//Label label = new Label("TopMenu");
		//menuWidgetPanel.add(label);
		menuWidgetPanel.setStyleName("topMenu");
		
		RootPanel.get().add(menuWidgetPanel);
		//RootLayoutPanel.get().add(menuWidgetPanel);
		//container.getElement().getStyle().setProperty("width", "300px");
		//container.getElement().getStyle().setProperty("overflow", "scroll");
		//container.getElement().getStyle().setProperty("border", "1px solid green");
		//appWidNewNew.getElement().getStyle().setProperty("width", "1300px");
		
		//appWidNewNew.getElement().getStyle().setProperty("display", "inline-block");
		
		
		/*
		FlowPanel goBackContainer = new FlowPanel();
		goBackContainer.setStyleName("goBackContainer");
		RootPanel.get().add(goBackContainer);
		*/
		Button BackButt = new Button("BackButt");
		menuWidgetPanel.add(BackButt);
		
		//myEventBus.addHandler(ComposedEvent.TYPE, new MyCompositeEventHandler2());
		//SimpleEventBusSingleton.getInstance().addHandler(ComposedEvent.TYPE, this);
		
		BackButt.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				History.back();
			}
		});
		
		
		container.setStyleName("mainContainer");
		RootPanel.get().add(container);
		//layoutContainer.add(container);
		
		container.add(appWidNewNew);
		
		FlowPanel clearBothPanel = new FlowPanel();
		clearBothPanel.setStyleName("clearBothPanel");
		container.add(clearBothPanel);
		
		//RootPanel.get().add(appWidget);
		//RootPanel.get().add(menuWidget);
		//RootPanel.get().add(appWidNew);
		
		
		//Button myButt1 = new Button("Goback!");
		//container.add(myButt1);
		//RootPanel.get().add(myButt1);
		//TopmenuView myTopmenuView = new TopmenuView();
		//menuWidget.add(myTopmenuView);
		
		ClientFactory clientFactory = GWT.create(my.client.common.ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        MyActivityManager activityManager = new MyActivityManager(activityMapper, eventBus, clientFactory);
        activityManager.setDisplay(appWidNewNew);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper = clientFactory.getHistoryMapper();
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        System.out.println("goto defaultPlace");
        historyHandler.register(placeController, eventBus, defaultPlace);

        
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();

		
		
	}
}
