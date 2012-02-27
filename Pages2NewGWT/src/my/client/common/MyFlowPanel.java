package my.client.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import my.client.forum.ForumAnimation;



import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MyFlowPanel extends FlowPanel implements AcceptsOneWidget {

	private int widgets_count = 0;
	private HashMap<String,Widget> widgetsStack=new HashMap<String, Widget>();
	private Stack <Widget>widgetsStack2 =  new Stack<Widget>();
	
	public MyFlowPanel() {
		System.out.println("MyFlowPanel construct");
		/*
		Button myButt1 = new Button("Goback!");
		this.add(myButt1);
		*/
	  }
	
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		System.out.println("MyFlowPanel setWidget = " + w);
		widgets_count = widgets_count +1;
		
		
		
		
		Widget widget = Widget.asWidgetOrNull(w);
		
		
		
		
        // adding or set elements in Map by put method key and value pair
		//widgetsStack.put("vid", widget);
//        mp.put(new Integer(1), "One");
 //       mp.put(new Integer(3), "Three");
  //      mp.put(new Integer(4), "Four");

        //Get Map in Set interface to get key and value
        //Set s=widgetsStack.entrySet();


        //java.util.Iterator it=s.iterator();

        /*
        while(it.hasNext())
        {
        	 System.out.println("Iterator");
        	 it.next();
        	
            // key=value separator this by Map.Entry to get key and value
            Map.Entry m =(Map.Entry)it.next();

            // getKey is used to get key of Map
            int key=(Integer)m.getKey();

            // getValue is used to get value of key in Map
            String value=(String)m.getValue();

            System.out.println("Key :"+key+"  Value :"+value);
        }*/
        
		
		
		/*
		widget.getElement().getStyle().setProperty("border", "3px solid red");
		widget.getElement().getStyle().setProperty("position", "relative");		
		widget.getElement().getStyle().setProperty("left", -(widgets_count * 30) + "px");
		*/
		
		
		   if (widget != null) {
			   
			   widget.getElement().getStyle().setProperty("left", "0px");
			   this.add(widget);
			   
			   widgetsStack2.push(widget);
		    //Set s=widgetsStack.entrySet();
		      Iterator it = widgetsStack2.iterator();
		      /*
		      Widget curWidget = (Widget) it.next();
		      int widgetLeft = curWidget.getElement().getOffsetLeft();
	    	  int widgetTop = curWidget.getElement().getOffsetTop();
	    	  ForumAnimation animation = new ForumAnimation(curWidget);
	    	  animation.scrollTo(widgetLeft + 50, widgetTop, 2000);
	    	  */
		     // Boolean isFirst = false; 
		      
		      while(it.hasNext()){
		    	 // if (!isFirst) {
		    	  Widget curWidget = (Widget) it.next();
		    	  //isFirst = true;
		    	  System.out.println("Iterator");
		    	  //curWidget.getElement().getStyle().setProperty("left", -(widgets_count * 30) + "px");
		    	  ForumAnimation animation = new ForumAnimation(curWidget);
		    	  System.out.println("curWidget.getElement().getAbsoluteLeft = " + curWidget.getElement().getAbsoluteLeft());

		    	  System.out.println("curWidget.getElement().getStyle().getLeft() = " + curWidget.getElement().getStyle().getLeft());
		    	  System.out.println("curWidget.getElement().getOffsetLeft() = " + curWidget.getElement().getOffsetLeft());
		    	  //System.out.println("curWidget.getElement().getOffsetTop() = " + curWidget.getElement().getOffsetTop());

		    	  //int widgetLeft = curWidget.getElement().getStyle().getLeft();
		    	  int widgetLeft = curWidget.getElement().getOffsetLeft();
		    	  int widgetTop = curWidget.getElement().getOffsetTop();
		    	  animation.scrollTo(widgetLeft + 200, widgetTop, 2000);
		    	 // }
		      }
		     
		      
		     
		   }
		   
		   
		   System.out.println("getWidgetCount = " + this.getWidgetCount());
		   System.out.println("widgetsStack2 = " + this.widgetsStack2.size());
		   
	}

}
