package my.client.theme;



import my.client.common.ClientFactory;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ThemeActivity implements ThemeViewInterface.Presenter{

	public ThemeActivity(Panel panel, ClientFactory clientFactory) {
		System.out.println("ThemeActivity constructor");
		// TODO Auto-generated constructor stub
		ThemeView myThemeView = new ThemeView();
		System.out.println("ThemeActivity constructor1");
		//myForumView.setName("myForumView");
		myThemeView.setPresenter(this);
		System.out.println("ThemeActivity constructor2");
		//myForumView.setButtonName(this.forumNumber);
		panel.add(myThemeView);
		System.out.println("ThemeActivity constructor3");
	}


	
	public void start(Panel panel, EventBus eventBus) {
		// TODO Auto-generated method stub
		
	}

}
