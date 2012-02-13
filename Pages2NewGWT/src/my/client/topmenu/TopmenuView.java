package my.client.topmenu;

import my.client.common.SimpleEventBusSingleton;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class TopmenuView extends Composite implements ITopmenuView {

	private VerticalPanel panel = new VerticalPanel();
	private Button myButt1 = new Button("TopmenuView");
	private Button myButt2 = new Button("GoBack");
	private Presenter presenter;
    private String name;

	//private HandlerManager handlerManager;
	
	public TopmenuView() {
		//handlerManager = new HandlerManager(this);
		panel.add(myButt1);
		panel.add(myButt2);
		
		
		
		myButt1.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				System.out.println("topmenu");
			}
		});
		
		myButt2.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				//System.out.println("MyCompositeView myButt1.onClick");
				System.out.println("999 topmenu goBack");
				presenter.letsGoBack();
				//this.pre
				
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
