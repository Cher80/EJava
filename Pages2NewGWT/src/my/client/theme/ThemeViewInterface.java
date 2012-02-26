package my.client.theme;

import com.google.gwt.user.client.ui.IsWidget;

public interface ThemeViewInterface extends IsWidget {
	
	public void setThemeName(String themeName);
    public void setPresenter(Presenter presenter);
    //void setButtonName(String forumNumber);
	
	public interface Presenter {

		void gotoForum(int i);
		//public void goToCompos1New();
        //void goToCompos1(Place place);
        //void setThemeNa,e();
    }

}
