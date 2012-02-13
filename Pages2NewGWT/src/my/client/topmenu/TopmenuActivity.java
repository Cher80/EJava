package my.client.topmenu;

import my.client.common.ClientFactory;
import my.client.topmenu.TopmenuPlace;
import my.client.topmenu.TopmenuView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class TopmenuActivity extends AbstractActivity implements ITopmenuView.Presenter{

	private ClientFactory clientFactory;
    private String name;
    private String forumNumber;
    
    public TopmenuActivity(TopmenuPlace place, ClientFactory clientFactory) {
        this.name = place.getPlaceName();
        
        
        
        this.clientFactory = clientFactory;
    }
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		TopmenuView myTopmenuView = new TopmenuView();
		myTopmenuView.setName("myTopmenuView");
		myTopmenuView.setPresenter(this);
		//myTopmenuView.setButtonName(99);
		panel.setWidget(myTopmenuView.asWidget());

	}
	
	@Override
	public void letsGoBack() {
		System.out.println("topmenu goBack");
	}
	
	

	

}
