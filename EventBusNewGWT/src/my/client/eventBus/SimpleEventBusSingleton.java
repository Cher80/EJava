package my.client.eventBus;

import com.google.gwt.event.shared.SimpleEventBus;

public class SimpleEventBusSingleton extends SimpleEventBus {
	
	private static SimpleEventBusSingleton instance;
	
	public SimpleEventBusSingleton() {
		System.out.println("SimpleEventBusSingleton created"); 
	}
	
	public static synchronized SimpleEventBusSingleton getInstance() {
        if (instance == null)
            instance = new SimpleEventBusSingleton();
        System.out.println("Using created SimpleEventBusSingleton"); 
        return instance;
    }
	
	
}
