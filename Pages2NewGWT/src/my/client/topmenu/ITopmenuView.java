package my.client.topmenu;

import com.google.gwt.user.client.ui.IsWidget;

public interface ITopmenuView extends IsWidget {
	void setName(String composName);
    void setPresenter(Presenter presenter);

    public interface Presenter {
    	public void letsGoBack();
    }


}
