package my.client.eventBus;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.GwtEvent.Type;

public class EnevtBusSingleton extends EventBus {

	private static EnevtBusSingleton instance; 
	//@Override
	public EnevtBusSingleton()
	 	{
		System.out.println("EnevtBusSingleton created"); 
		// TODO Auto-generated method stub
		//return null;
	}
	
	public static synchronized EnevtBusSingleton getInstance() {
        if (instance == null)
            instance = new EnevtBusSingleton();
        System.out.println("Using created EnevtBusSingleton"); 
        return instance;
    } 
	
	@Override
	public <H extends EventHandler> HandlerRegistration addHandler(
			Type<H> type, H handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <H extends EventHandler> HandlerRegistration addHandlerToSource(
			Type<H> type, Object source, H handler) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fireEvent(GwtEvent<?> event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void fireEventFromSource(GwtEvent<?> event, Object source) {
		// TODO Auto-generated method stub

	}

}
