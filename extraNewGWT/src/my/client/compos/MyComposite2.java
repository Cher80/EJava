package my.client.compos;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;

public class MyComposite2 extends Composite implements IMyCompositeEventHandler {
	
	private VerticalPanel panel = new VerticalPanel();
	private Button myButt1 = new Button("OloloButt2");
	
	public MyComposite2() {
		panel.add(myButt1);
		
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
	public void onComposed(ComposedEvent event) {
		// TODO Auto-generated method stub
		myButt1.setText("BlyaMessaga!");
		//System.out.println(event.myVar);
	}
	
	
}
