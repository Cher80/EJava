package my.client.forum;




import my.client.common.ClientFactory;

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
        public ClientFactory getClientFactory();
    }

}
