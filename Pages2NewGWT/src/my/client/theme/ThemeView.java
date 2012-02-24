package my.client.theme;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;

public class ThemeView extends Composite implements ThemeViewInterface {

	private Presenter presenter;
    private String themeName;
    private FlowPanel flowPanel = new FlowPanel();
    
    public ThemeView() {
    	System.out.println("ThemeView constructor");
    	Label label = new Label("ThemeViewLabel");
    	Button myButt1 = new Button("OloloButt2");
		//label.setWidth("100px");
		//label.setStyleName("demo-label");
    	flowPanel.add(label);
    	flowPanel.add(myButt1);
		//commentsPanel.add(commentPanel);
		
    	initWidget(flowPanel);
    }
    
    
	@Override
	public void setThemeName(String themeName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPresenter(Presenter presenter) {
		// TODO Auto-generated method stub
		this.presenter = presenter;
	}



}
