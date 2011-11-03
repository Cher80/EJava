package my.client.compos2;

import my.client.compos.IMyCompositeView.Presenter;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface IMyComposite2View extends IsWidget {
	
	void setName(String composName);
    void setPresenter(Presenter presenter);
	
	public interface Presenter {
        void goToCompos1(Place place);
        void someStaff();
    }

}
