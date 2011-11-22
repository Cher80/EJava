package my.client.compos;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface IMyCompositeView extends IsWidget {
	void setName(String composName);
    void setPresenter(Presenter presenter);

    public interface Presenter {
        void goToCompos2(Place place);
        public void goToCompos2New();
        void someStaff();
		void doEditReload();
		void doEditHistory();
		
    }


}
