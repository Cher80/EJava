package my.client.common;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MyFlowPanel extends FlowPanel implements AcceptsOneWidget {

	public MyFlowPanel() {
		System.out.println("MyFlowPanel construct");
	  }
	
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		System.out.println("MyFlowPanel setWidget = " + w);

		Widget widget = Widget.asWidgetOrNull(w);
		   if (widget != null) {
		      this.add(widget);
		   }
		   
		   System.out.println("getWidgetCount = " + this.getWidgetCount());
		   
	}

}
