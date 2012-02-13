package my.client.common;

//import com.google.appengine.tools.util.Option.Style;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.Widget;

public class MySimpleLayoutPanel extends LayoutPanel implements AcceptsOneWidget {

	public MySimpleLayoutPanel() {
		System.out.println("MySimpleLayoutPanel");
	  }
	
	
	

	
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		System.out.println("MySimpleLayoutPanel setWidget = " + w);
		//this.clear();
		 //this.clear();
		   Widget widget = Widget.asWidgetOrNull(w);
		   if (widget != null) {
		      this.add(widget);
		   }  
		
		
		   if (this.getWidgetCount()>1) { 
			   for (int i=0;i<this.getWidgetCount()-1;i++) {
				   System.out.println("wigets = " + i);
			   		//this.setWidgetTopHeight(this.getWidget(i), this.getWidget(i).getAbsoluteTop(), Unit.PX, 100, Unit.PX);
			   		this.forceLayout();
			   		//this.setWidgetTopHeight(this.getWidget(i), this.getWidget(i).getAbsoluteTop() + 100, Unit.PX, 100, Unit.PX);
					
		   		}
		   }
		   
		   
		   
		   if (this.getWidgetCount()>1) { 
			   for (int i=0;i<this.getWidgetCount()-1;i++) {
				   System.out.println("wigets2 = " + i);
			   		this.setWidgetTopHeight(this.getWidget(i), 0, Unit.PX,  this.getWidget(i).getAbsoluteTop() + 100, Unit.PX);
			   		
			   		//this.forceLayout();
		   		}
			   
		   }
		   //this.animate(1500);
		   
		
		   
		   
		   /*
		   Widget widget = Widget.asWidgetOrNull(w);
		   if (widget != null) {
		      this.add(widget);
		   }
		
		//this.clear();
		//Widget widget = Widget.asWidgetOrNull(w);
		//this.add(widget);
		/*
		   Widget widget = Widget.asWidgetOrNull(w);
		   if (widget != null) {
		      this.add(widget);
		  }*/
	}

}
