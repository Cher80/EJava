package my.client.compos;

import my.client.common.SimpleEventBusSingleton;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyCompositeView extends Composite implements IMyCompositeView {

	private FlowPanel panel = new FlowPanel();
	private Button myButt1 = new Button("OloloButt");
	private Presenter presenter;
    private String name;

	//private HandlerManager handlerManager;
	
	public MyCompositeView() {
		panel.getElement().getStyle().setProperty("float", "left");
		panel.getElement().getStyle().setProperty("border", "1px solid red");
		
		//handlerManager = new HandlerManager(this);
		panel.add(myButt1);
		
		
		
		myButt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("MyCompositeView myButt1.onClick");
				presenter.someStaff();
				presenter.goToCompos2New();
				//myButt1.setText("Cliknul!");
				//ComposedEvent myEvent = new ComposedEvent(154);
				//SimpleEventBusSingleton.getInstance().fireEvent(myEvent);
				
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
