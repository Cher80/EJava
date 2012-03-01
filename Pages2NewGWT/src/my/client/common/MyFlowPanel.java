package my.client.common;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import my.client.forum.ForumAnimation;
import my.client.forum.ForumView;
import my.client.helpers.HavePresenter;
import my.client.helpers.HaveClientFactory;



import com.google.gwt.activity.shared.Activity;
import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

public class MyFlowPanel extends FlowPanel implements AcceptsOneWidget {

	private Widget currentWidget;
	private int widgets_count = 0;
	private HashMap<String,Widget> widgetsStack=new HashMap<String, Widget>();
	private Stack <Widget>widgetsStack2 =  new Stack<Widget>();
	
	public MyFlowPanel() {
		System.out.println("MyFlowPanel construct");
		
		this.setStyleName("MyFlowPanel");
		/*
		Button myButt1 = new Button("Goback!");
		this.add(myButt1);
		*/
	  }

	
	
	public void doClearance(Widget widget) {
		System.out.println("doClearance");
		
	    System.out.println("widget.getElement().getOffsetLeft() = " + widget.getElement().getOffsetLeft());
	    	 
		
	  	Activity curActivity = ((HavePresenter)widget).getPresenter();
	  	HistoryKeeper historyKeeper = ((HaveClientFactory)curActivity).getClientFactory().getHistoryKeeper();
	  	Boolean isNeedToRemove = ((HaveClientFactory)curActivity).getClientFactory().getHistoryKeeper().isNeedToRemove(widget,currentWidget);
	  	if (isNeedToRemove) {
	  		this.remove(widget);
		  	historyKeeper.popWidget(widget);
		  	

	  	}
	}
	
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		System.out.println("MyFlowPanel setWidget = " + w);
		
		
		
		
		Widget widget = Widget.asWidgetOrNull(w);
		
		if (widget != null) {
			Activity curActivity2 = ((HavePresenter)w).getPresenter();

			
			this.currentWidget = widget;
			
			int offsetDir = -300;
	    	 
	    	 
		    	  

			//int positionOne = Window.getClientWidth()/2 - 150;
		 	//System.out.println("positionOne = " + positionOne);
   	  		//widget.getElement().getStyle().setProperty("left", positionOne + "px");
   	  		
			// int positionOne = Window.getClientWidth()/2 - 150;
			int windowCenter = Window.getClientWidth()/2;
			System.out.println("FloatPanel width" + this.getOffsetWidth());  
			
			int positionOne = 		 Window.getClientWidth()/2 - 150;
			//int windowCenter = Window.getClientWidth()/2;

			
			//int windowCenter = this.getOffsetWidth()/2;
			
   	  		Activity curActivity = ((HavePresenter)widget).getPresenter();
   	  		HistoryKeeper historyKeeper = ((HaveClientFactory)curActivity).getClientFactory().getHistoryKeeper();
   	  		Boolean isHistoryWidget = ((HaveClientFactory)curActivity).getClientFactory().getHistoryKeeper().isHistoryWidget(widget);
   			
   			
   			if (!isHistoryWidget) {
   				this.add(widget);
 //  				int widgetWidth = widget.getElement().getOffsetWidth();

   				int widgetWidth = widget.getElement().getOffsetWidth();
   				int initialPosition = widgetWidth + (windowCenter - widgetWidth/2);
   				System.out.println("windowCenter " + windowCenter); 

   				System.out.println("widgetWidth " + widgetWidth); 

   				System.out.println("initialPosition " + initialPosition); 
   				widget.getElement().getStyle().setProperty("left", initialPosition + "px");
   				
   				//System.out.println("width = " + currentWidget.getElement().getOffsetWidth());
   				
   				
   			}
   			else {
   				offsetDir = positionOne - widget.getElement().getOffsetLeft();
   			}
   			
   			widgetsStack2 = historyKeeper.getWidgetsToMove();
   			Iterator it = widgetsStack2.iterator();
   		      
   		      while(it.hasNext()){
   		    	 // if (!isFirst) {
   		    	  Widget curWidget = (Widget) it.next();
   		    	  //isFirst = true;
   		    	  System.out.println("animation Iterator");
   		    	  
   		    	  //curWidget.getElement().getStyle().setProperty("left", -(widgets_count * 30) + "px");
   		    	  ForumAnimation animation = new ForumAnimation(curWidget, this);
   		    	  //System.out.println("curWidget.getElement().getAbsoluteLeft = " + curWidget.getElement().getAbsoluteLeft());

   		    	  //System.out.println("curWidget.getElement().getStyle().getLeft() = " + curWidget.getElement().getStyle().getLeft());
   		    	 System.out.println("curWidget.getElement().getOffsetLeft() = " + curWidget.getElement().getOffsetLeft());
   		    	  //System.out.println("curWidget.getElement().getOffsetTop() = " + curWidget.getElement().getOffsetTop());
   		    	  
   		    	  
   		    	  
   		    	  //int widgetLeft = curWidget.getElement().getStyle().getLeft();
   		    	  int widgetLeft = curWidget.getElement().getOffsetLeft();
   		    	  int widgetTop = curWidget.getElement().getOffsetTop();
   		    	  //widget.getElement().getStyle().setProperty("top","33PX");
   		    	  animation.scrollTo(widgetLeft + offsetDir, widgetTop, 2000);
   				
   		      }
   		   
   		      /*
   		   FlowPanel clearBothPanel = new FlowPanel();
   		   clearBothPanel.setStyleName("clearBothPanel");
   		   this.add(clearBothPanel);
   			*/
		
		}
		
	
		
		
		
		
		

		/*
		
		
		   if (widget != null) {

		  	  
			   //clientFactory.getHistoryKeeper().pushNewActivity
			   
		   	  String newToken = ((ForumView) widget).getPresenter().getName();
		      System.out.println("newToken = " + newToken);
			  
		      int offsetDir = -300;
		      Boolean findedInHistory = false;
		      Iterator it2 = widgetsStack2.iterator();
		      while(it2.hasNext() && !findedInHistory){
			    	 // if (!isFirst) {
			    	  Widget curWidget = (Widget) it2.next();
				   	  String oldToken = ((ForumView) curWidget).getPresenter().getName();
				   	  System.out.println("oldToken = " + oldToken);
				   	  if (newToken.equals(oldToken)) {
				   		  System.out.println("Sovpadenie tokenov");
				   		  //System.out.println("Sovpadenie tokenov");
				    	  System.out.println("widget.getElement().getOffsetLeft() = " + widget.getElement().getOffsetLeft());
				    	  System.out.println("curWidget.getElement().getOffsetLeft() = " + curWidget.getElement().getOffsetLeft());
				    	  
				    	  int positionOne = Window.getClientWidth()/2 - 150;
				    	  offsetDir = positionOne - curWidget.getElement().getOffsetLeft();
				    	  findedInHistory = true;
				   	  }
		      }
		      if (!findedInHistory) {
		    	  int positionOne = Window.getClientWidth()/2 - 150;
		    	  System.out.println("positionOne = " + positionOne);
		    	  widget.getElement().getStyle().setProperty("left", positionOne + "px");
				  this.add(widget);
		      }
		      
			   
			   
			   
			   
			   
			  widgetsStack2.push(widget);
			  
		      Iterator it = widgetsStack2.iterator();
		      
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
		    	  animation.scrollTo(widgetLeft + offsetDir, widgetTop, 2000);
		    	 // }
		      }
		     
		      
		     
		   }
		   
		   
		   System.out.println("getWidgetCount = " + this.getWidgetCount());
		   System.out.println("widgetsStack2 = " + this.widgetsStack2.size());
		   */
		   
	}

}
