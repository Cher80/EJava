package my.client.theme;

import com.google.gwt.user.client.ui.IsWidget;

public interface ThemeViewInterface extends IsWidget {
	
	public void setThemeName(String themeName);
    public void setPresenter(Presenter presenter);
    //void setButtonName(String forumNumber);
	
	public interface Presenter {

		void gotoForum();
		public int getForumId();
		public void setForumId(int forumId);
		//public void goToCompos1New();
        //void goToCompos1(Place place);
        //void setThemeNa,e();
		void makeRPC();
    }

}
