package my.client.theme;



import my.client.common.ClientFactory;
import my.client.compos.MyCompositePlace;
import my.client.forum.ForumPlace;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ThemeActivity implements ThemeViewInterface.Presenter{
	private int forumId;
	private ClientFactory clientFactory;
	
	public ThemeActivity(Panel panel, ClientFactory clientFactory, int forumId) {
		//System.out.println("ThemeActivity constructor");
		// TODO Auto-generated constructor stub
		this.clientFactory = clientFactory;
		this.forumId = forumId;
		ThemeView myThemeView = new ThemeView();
		//System.out.println("ThemeActivity constructor1");
		//myForumView.setName("myForumView");
		myThemeView.setPresenter(this);
		myThemeView.populate();
		//myThemeView.setForumid
		//System.out.println("ThemeActivity constructor2");
		//myForumView.setButtonName(this.forumNumber);
		panel.add(myThemeView);
		//System.out.println("ThemeActivity constructor3");
	}


	
	public void start(Panel panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}
	
	public void gotoForum() {
		//String forumIdStr = (String)forumId;
		clientFactory.getPlaceController().goTo(new ForumPlace(Integer.toString(forumId)));
	}



	public int getForumId() {
		return forumId;
	}



	public void setForumId(int forumId) {
		this.forumId = forumId;
		System.out.println("theme setForumId = " + this.forumId);
	}

}
