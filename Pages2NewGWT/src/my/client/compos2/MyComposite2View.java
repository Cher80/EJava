package my.client.compos2;

import my.client.common.SimpleEventBusSingleton;
import my.client.compos.ComposedEvent;
import my.client.compos.IMyCompositeView.Presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyComposite2View extends Composite implements IMyComposite2View {

	
	private FlowPanel panel = new FlowPanel();
	private Button myButt1 = new Button("OloloButt2");
	private Presenter presenter;
    private String name;
	
	public MyComposite2View() {
		panel.getElement().getStyle().setProperty("float", "left");
		panel.getElement().getStyle().setProperty("border", "1px solid red");
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
				presenter.goToCompos1New();
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
		myButt1.setText("name2!");

	}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
		//this.forumNumber
	}

	public void setButtonName(String forumNumber) {
		myButt1.setText("name2!forumNumber + " + forumNumber);
		
	}

}
