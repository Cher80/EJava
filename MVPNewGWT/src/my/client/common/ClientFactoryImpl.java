package my.client.common;

import com.google.gwt.place.shared.PlaceController;

import my.client.compos.MyCompositeView;
import my.client.compos2.MyComposite2View;

public class ClientFactoryImpl implements ClientFactory {
	
	 private final SimpleEventBusSingleton eventBus = new SimpleEventBusSingleton();
	 private final PlaceController placeController = new PlaceController(eventBus);
	 private final MyCompositeView myCompositeView = new MyCompositeView();
	 private final MyComposite2View myComposite2View = new MyComposite2View();
	 //private final GoodbyeView goodbyeView = new GoodbyeViewImpl();


	@Override
	public SimpleEventBusSingleton getEventBus() {
		// TODO Auto-generated method stub
		return eventBus;
	}

	@Override
	public MyCompositeView getMyCompositeView() {
		// TODO Auto-generated method stub
		return myCompositeView;
	}
	
	@Override
	public MyComposite2View getMyComposite2View() {
		// TODO Auto-generated method stub
		return myComposite2View;
	}

	
	public PlaceController getPlaceController() {
		// TODO Auto-generated method stub
		return placeController;
	}
}
