package my.client.compos;

import my.client.common.ClientFactory;
import my.client.compos2.MyComposite2Place;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Widget;

public class MyCompositeActivity extends AbstractActivity implements
		IMyCompositeView.Presenter {


	private ClientFactory clientFactory;
    private String name;

	
    public MyCompositeActivity(MyCompositePlace place, ClientFactory clientFactory) {
        this.name = place.getPlaceName();
        this.clientFactory = clientFactory;
    }


	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		MyCompositeView myComposedView = new MyCompositeView();
		myComposedView.setName("MyCompositeView");
		myComposedView.setPresenter(this);
		panel.setWidget(myComposedView.asWidget());

		
	}



	@Override
	public void goToCompos2New() {
		System.out.println("MyCompositeActivity action goToCompos2 ");
		clientFactory.getPlaceController().goTo(new MyComposite2Place("composplace2/234"));

	}
	
	@Override
	public void goToCompos2(Place place) {
		System.out.println("MyCompositeActivity action goToCompos2 ");
		clientFactory.getPlaceController().goTo(new MyComposite2Place(name));

	}


	@Override
	public void someStaff() {
		// TODO Auto-generated method stub
		System.out.println("MyCompositeActivity action someStaff ");
	}

}
