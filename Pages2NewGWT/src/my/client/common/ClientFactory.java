package my.client.common;

import com.google.gwt.place.shared.PlaceController;

import my.client.compos.MyCompositeView;
import my.client.compos2.MyComposite2View;

public interface ClientFactory {
	SimpleEventBusSingleton getEventBus();
	public PlaceController getPlaceController();
	public HistoryKeeper getHistoryKeeper();
    MyCompositeView getMyCompositeView();
    MyComposite2View getMyComposite2View();
	public AppPlaceHistoryMapper getHistoryMapper();
    //GoodbyeView getGoodbyeView();


}
