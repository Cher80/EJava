package my.client.compos2;

import my.client.common.ClientFactory;
import my.client.compos.MyCompositePlace;
import my.client.compos.MyCompositeView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class MyComposite2Activity extends AbstractActivity implements IMyComposite2View.Presenter{

	private ClientFactory clientFactory;
    private String name;
    
    public MyComposite2Activity(MyComposite2Place place, ClientFactory clientFactory) {
        this.name = place.getMyComposite2Name();
        this.clientFactory = clientFactory;
    }
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		MyComposite2View myComposed2View = new MyComposite2View();
		myComposed2View.setName("MyCompositeView");
		myComposed2View.setPresenter(this);
		panel.setWidget(myComposed2View.asWidget());

	}

	@Override
	public void goToCompos1(Place place) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void someStaff() {
		// TODO Auto-generated method stub
		
	}

}
