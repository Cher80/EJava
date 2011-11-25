package my.client;

//import my.client.MyComposite;
import my.client.common.AppActivityMapper;
import my.client.common.AppPlaceHistoryMapper;
import my.client.common.ClientFactory;
import my.client.compos.ComposedEvent;
import my.client.compos.MyComposite;
import my.client.compos.MyCompositePlace;
import my.client.compos2.MyComposite2;
import my.client.compos.MyCompositeEventHandler;
import my.client.compos.MyCompositeEventHandler2;
import my.client.menu.MenuActivityMapper;
import my.client.menuTop.MenuTop;
import my.shared.FieldVerifier;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ExtraNewGWT implements EntryPoint {
	
	private Place defaultPlace = new MyCompositePlace("composplace1!");
    private SimplePanel appWidget = new SimplePanel();
    private SimplePanel menuWidget = new SimplePanel();
    private SimplePanel menuTopPanel = new SimplePanel();


	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		RootPanel.get().add(menuTopPanel);
		menuTopPanel.add(new MenuTop());
		
		 RootPanel.get().add(appWidget);
	        RootPanel.get().add(menuWidget);
		
		ClientFactory clientFactory = GWT.create(my.client.common.ClientFactory.class);
        EventBus eventBus = clientFactory.getEventBus();
        PlaceController placeController = clientFactory.getPlaceController();

        // Start ActivityManager for the main widget with our ActivityMapper Menu!
        ActivityMapper menuActivityMapper = new MenuActivityMapper(clientFactory);
        ActivityManager menuActivityManager = new ActivityManager(menuActivityMapper, eventBus);
        menuActivityManager.setDisplay(menuWidget);
        
        
        // Start ActivityManager for the main widget with our ActivityMapper
        ActivityMapper activityMapper = new AppActivityMapper(clientFactory);
        ActivityManager activityManager = new ActivityManager(activityMapper, eventBus);
        activityManager.setDisplay(appWidget);

        // Start PlaceHistoryHandler with our PlaceHistoryMapper
        AppPlaceHistoryMapper historyMapper= GWT.create(AppPlaceHistoryMapper.class);
        PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
        historyHandler.register(placeController, eventBus, defaultPlace);

       
        // Goes to the place represented on URL else default place
        historyHandler.handleCurrentHistory();

		
		
	}
}
