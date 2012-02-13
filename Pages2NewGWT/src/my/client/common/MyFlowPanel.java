package my.client.common;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MyFlowPanel extends FlowPanel implements AcceptsOneWidget {

	private int widgets_count = 0;
	public MyFlowPanel() {
		System.out.println("MyFlowPanel construct");
	  }
	
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		System.out.println("MyFlowPanel setWidget = " + w);
		widgets_count = widgets_count +1;
		this.getElement().getStyle().setProperty("border", "3px solid red");
		// = this.getElement().getStyle().getProperty("left");
		// int leftx = (int)this.getElement().getStyle().getProperty("left");
		this.getElement().getStyle().setProperty("position", "relative");
		
		this.getElement().getStyle().setProperty("left", -(widgets_count * 30) + "px");
		//this.getElement().getStyle().setProperty("left", "-100px");
		//((Widget) this).
		
		Widget widget = Widget.asWidgetOrNull(w);
		   if (widget != null) {
		      this.add(widget);
		   }
		   
		   System.out.println("getWidgetCount = " + this.getWidgetCount());
		   
	}

}
