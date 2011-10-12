package my.client.compos;

import com.google.gwt.event.shared.EventHandler;

public interface IMyCompositeEventHandler extends EventHandler {
	void onComposed(ComposedEvent event);

	//void onEvent(ComposedEvent composedEvent); 
}
