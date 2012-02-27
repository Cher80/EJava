package my.client.common;

import com.google.gwt.place.shared.PlaceController;

import my.client.compos.MyCompositeView;
import my.client.compos2.MyComposite2View;

public interface ClientFactory {
	SimpleEventBusSingleton getEventBus();
	public PlaceController getPlaceController();
    MyCompositeView getMyCompositeView();
    MyComposite2View getMyComposite2View();
    //GoodbyeView getGoodbyeView();


}
