package my.client.forum;

import my.client.common.ClientFactory;
import my.client.compos2.MyComposite2View;


import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;

public class ForumActivity extends AbstractActivity implements ForumViewInterface.Presenter {
	
	private ClientFactory clientFactory;
    private String name;
    
    public ForumActivity(ForumPlace place, ClientFactory clientFactory) {
        this.name = place.getPlaceName(); 
		System.out.println("ForumActivity =" + name);
        this.clientFactory = clientFactory;
    } 
    
//    public getClientFactory()
    
    
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		ForumView myForumView = new ForumView();
		//myForumView.setName("myForumView");
		myForumView.setPresenter(this);
		myForumView.populate();
		//myForumView.setButtonName(this.forumNumber);
		panel.setWidget(myForumView.asWidget());

	}

	@Override
	public void someStaff() {
		// TODO Auto-generated method stub
		
	}

	public ClientFactory getClientFactory() {
		return clientFactory;
	}

	

}
