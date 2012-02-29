package my.client.forum;




import my.client.common.ClientFactory;
import my.client.forum.ForumViewInterface.Presenter;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.IsWidget;

public interface ForumViewInterface extends IsWidget {
	
	public void setName(String composName);
    public void setPresenter(Presenter presenter);
    public void populate();
    
    //void setButtonName(String forumNumber);
	
	public interface Presenter {
	
		//public void goToCompos1New();
        //void goToCompos1(Place place);
		
        void someStaff();
        
		int getForumId();
		String getName();
		public ForumPlace getPlace();
		
    }

	

}
