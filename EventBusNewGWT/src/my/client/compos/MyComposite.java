package my.client.compos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyComposite extends Composite implements HasHandlers{
	
	private VerticalPanel panel = new VerticalPanel();
	private Button myButt1 = new Button("OloloButt");
	private HandlerManager handlerManager;
	
	public MyComposite() {
		handlerManager = new HandlerManager(this);
		panel.add(myButt1);
		
		
		
		myButt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				myButt1.setText("Cliknul!");
				ComposedEvent myEvent = new ComposedEvent(654);
				fireEvent(myEvent);
				//myEvent.dispatch(new MyCompositeEventHandler());
				//myEvent.dispatch();
			}
		});
		
		initWidget(panel);
	}
	
	@Override
    public void fireEvent(GwtEvent<?> event) {
        handlerManager.fireEvent(event);
    }
	
	public HandlerRegistration addMessageReceivedEventHandler(
			IMyCompositeEventHandler handler) {
        return handlerManager.addHandler(ComposedEvent.TYPE, handler);
    }
	
	
}