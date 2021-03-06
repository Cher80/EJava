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
    private String forumNumber;
    
    public MyComposite2Activity(MyComposite2Place place, ClientFactory clientFactory) {
        this.name = place.getPlaceName();
        
        /* delimiter */
        String delimiter = "/";
        /* given string will be split by the argument delimiter provided. */
        String[] temp;
        temp = name.split(delimiter);
        /* print substrings */
        for(int i =0; i < temp.length ; i++)
        System.out.println("MyComposite2Activity split token = " + temp[i]);
        this.forumNumber = temp[1];
        
        this.clientFactory = clientFactory;
    }
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		MyComposite2View myComposed2View = new MyComposite2View();
		myComposed2View.setName("MyCompositeView");
		myComposed2View.setPresenter(this);
		myComposed2View.setButtonName(this.forumNumber);
		panel.setWidget(myComposed2View.asWidget());

	}

	@Override
	public void goToCompos1New() {
		System.out.println("MyComposite2Activity action goToCompos1 ");
		clientFactory.getPlaceController().goTo(new MyCompositePlace("composplace1"));

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
