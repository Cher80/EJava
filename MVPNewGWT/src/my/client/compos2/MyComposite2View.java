package my.client.compos2;

import my.client.common.SimpleEventBusSingleton;
import my.client.compos.ComposedEvent;
import my.client.compos.IMyCompositeView.Presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyComposite2View extends Composite implements IMyComposite2View {

	
	private VerticalPanel panel = new VerticalPanel();
	private Button myButt1 = new Button("OloloButt2");
	private Presenter presenter;
    private String name;
	
	public MyComposite2View() {
		panel.add(myButt1);
		
		//myEventBus.addHandler(ComposedEvent.TYPE, new MyCompositeEventHandler2());
		//SimpleEventBusSingleton.getInstance().addHandler(ComposedEvent.TYPE, this);
		
		myButt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//MyButt1.setText("FromPCCliknul!");
				//myButt1.setText("Cliknul!");
				//myButt1.setText("OereCliknul!");
				//myButt1.setText("VfrOereCliknul!");
				//myButt1.setText("BiBiVfrOereCliknul!");
				//myButt1.setText("MacBiBiVfrOereCliknul!");
				myButt1.setText("MacMacBiBiVfrOereCliknul!");
				
				//ComposedEvent myEvent = new ComposedEvent(654);
				//myEvent.dispatch(new MyCompositeEventHandler());
			}
		});
		
		initWidget(panel);
	}
	
	@Override
	public void setName(String composName) {
		// TODO Auto-generated method stub
		this.name = composName;
		myButt1.setText("name!");

	}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
	}

}
