package my.client.forum;

import my.client.common.ClientFactory;
import my.client.compos2.MyComposite2View;
import my.client.helpers.HaveClientFactory;
import my.client.helpers.HavePlace;
import my.client.helpers.HaveView;


import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Composite;

public class ForumActivity extends AbstractActivity implements ForumViewInterface.Presenter, HavePlace, HaveView, HaveClientFactory {
	
	private ClientFactory clientFactory;
    private String name;
    private int forumId;
    private ForumPlace place;
    private Composite activityView;
    
    public ForumActivity(ForumPlace place, ClientFactory clientFactory) {
    	//place.toke
    	//place.getPlaceName()
    	//ForumPlace.Tokenizer.getToken(place);
    	this.place = place;
        this.setName(place.getPlaceName()); 
        int forumId = Integer.parseInt( place.getPlaceName() );
        this.setForumId(forumId);
        System.out.println("place.getPlaceName() = " + place.getPlaceName());
		System.out.println("ForumActivity.forumId = " + forumId);
        this.clientFactory = clientFactory;
    } 
    
//    public getClientFactory()
    
    
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
        System.out.println("ForumActivity start");

		ForumView myForumView = new ForumView();
		//myForumView.setName("myForumView");
		myForumView.setPresenter(this);
		myForumView.populate();
		this.activityView = myForumView;
		//myForumView.setButtonName(this.forumNumber);
		panel.setWidget(myForumView.asWidget());

	}

	@Override
	public void someStaff() {
		// TODO Auto-generated method stub
		
	}



	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getName() {
		//ForumPlace.Tokenizer.
		return "ForumPref:" + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ForumPlace getPlace() {
		return place;
	}

	@Override
	public Composite getView() {
		return activityView;
	}

	@Override
	public ClientFactory getClientFactory() {
		// TODO Auto-generated method stub
		return clientFactory;
	}

	

	

}
