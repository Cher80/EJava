package my.client.common;

import java.util.Iterator;
import java.util.Stack;

import my.client.forum.ForumActivity;
import my.client.forum.ForumView;
import my.client.helpers.HavePlace;
import my.client.helpers.HavePresenter;
import my.client.helpers.HaveView;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class HistoryKeeper {
	
	private Stack <Activity>activityStack =  new Stack<Activity>();
	private ClientFactory clientFactory;
	public HistoryKeeper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public Activity checkIsVisited(Place newPlace) {
		//
//		String newToken = ((ForumView) widget).getPresenter().getName();
		String newToken =	clientFactory.getHistoryMapper().getToken(newPlace);
    	System.out.println("checkIsVisited iterator newToken = " + newToken);

		Iterator<Activity> it = activityStack.iterator();
	    while(it.hasNext()){
	    	
	    	Activity curActivity = (Activity) it.next();
	    	Place oldPlace = ((HavePlace) curActivity).getPlace();
			String oldToken =	clientFactory.getHistoryMapper().getToken(oldPlace);
	    	
	    	System.out.println("checkIsVisited iterator oldToken = " + oldToken);
	    	if (newToken.equals(oldToken)) {
		    	System.out.println("Sovpadenie!");
		    	return curActivity;
	    	}

	      }
	    return null;  
	}
	
	
	
	
	public void popWidget(Widget widget) {
		//activityStack.pop();
		Iterator<Activity> it = activityStack.iterator();
//		int historyLengh = activityStack.size();
//		int i = 0;
	   
		while(it.hasNext()){
	    	
	    	Activity curActivity = it.next();
	    	Widget curWidget = ((HaveView)curActivity).getView().asWidget();
	    	if (widget.equals(curWidget)) {
	    		System.out.println("popWidget sovpalo!");
	    		it.remove();
	    		return;
	    	}
	    	//this.activityStack.peek()
	    	//Place oldPlace = ((HavePlace) curActivity).getPlace();
			//String oldToken =	clientFactory.getHistoryMapper().getToken(oldPlace);
	    	//System.out.println("getHistoryWidget!");
	    	

	      }
		
		
	}
	
	public void pushNewActivity(ForumActivity newWidget) {

		activityStack.push(newWidget);
	}
	
	public Stack <Widget> getWidgetsToMove() {
		Stack <Widget>widgetsStack =  new Stack<Widget>();
		Iterator<Activity> it = activityStack.iterator();
	    while(it.hasNext()){
	    	Activity curActivity = (Activity) it.next();
	    	Widget curWidget = ((HaveView)curActivity).getView().asWidget();
	    	System.out.println("getWidgetsToMove!" + curWidget.getAbsoluteLeft());
	    	widgetsStack.push(curWidget);
	    }
	    
		return widgetsStack;
		//activityStack.push(newWidget);
	}
	
	
	public Boolean isNeedToRemove (Widget movedWidget, Widget currShowedWidget) {
	
		Iterator<Activity> it = activityStack.iterator();
		int historyLengh = activityStack.size();
		int i = 0;
		int currShowedWidgetPosition = 0;
		while(it.hasNext()){
	    	
	    	Activity curActivity = it.next();
	    	i++;
	    	Widget curWidget = ((HaveView)curActivity).getView().asWidget();
	    	if (currShowedWidget.equals(curWidget)) {
	    		//System.out.println("currShowedWidgetPosition =" + i);
	    		currShowedWidgetPosition = i;
	    	}
	      }
		
		Iterator<Activity> it2 = activityStack.iterator();
		int ii = 0;
		int movedWidgetPosition = 0;
		while(it2.hasNext()){
	    	
	    	Activity curActivity = it2.next();
	    	ii++;
	    	Widget curWidget = ((HaveView)curActivity).getView().asWidget();
	    	if (movedWidget.equals(curWidget)) {
	    		movedWidgetPosition = ii;
	    		System.out.println("movedWidget =" + ii);

	    	}
	      }
		
		
		if (movedWidgetPosition > currShowedWidgetPosition) {
			System.out.println("movedWidget need to remove =" + movedWidgetPosition + "currShowedWidgetPosition =" + currShowedWidgetPosition);
			return true;
		} else {
			return false;
		}
		
	}
	
	public Boolean isHistoryWidget (Widget widget) {
		
		Iterator<Activity> it = activityStack.iterator();
		int historyLengh = activityStack.size();
		int i = 0;
	   
		while(it.hasNext()){
	    	
	    	Activity curActivity = it.next();
	    	i++;
	    	Widget curWidget = ((HaveView)curActivity).getView().asWidget();
	    	if (widget.equals(curWidget) && i!=historyLengh) {
	    		System.out.println("getHistoryWidget sovpalo!");
	    		return true;
	    	}
	    	//Place oldPlace = ((HavePlace) curActivity).getPlace();
			//String oldToken =	clientFactory.getHistoryMapper().getToken(oldPlace);
	    	System.out.println("getHistoryWidget!");
	    	

	      }
	     
		return false;
		//return widgets;
	}
	
	/*
	public void pushToHistory(Widget w) {
		Widget widget = Widget.asWidgetOrNull(w);
		
		if (widget != null) {

		  	  
		   	  String newToken = ((ForumView) widget).getPresenter().getName();
		      System.out.println("newToken = " + newToken);
			  
		      widgetsStack.push(widget);
		      
		      int offsetDir = -300;
		      Boolean findedInHistory = false;
		      Iterator it = widgetsStack.iterator();
		      while(it.hasNext() && !findedInHistory){
			    	 // if (!isFirst) {
			    	  Widget curWidget = (Widget) it.next();
				   	  String oldToken = ((HavePresenter) curWidget).getPresenter().getName();
				   	  System.out.println("oldToken = " + oldToken);
				   	  if (newToken.equals(oldToken)) {
				   		  System.out.println("Sovpadenie tokenov");
				   		  //System.out.println("Sovpadenie tokenov");
				    	  System.out.println("widget.getElement().getOffsetLeft() = " + widget.getElement().getOffsetLeft());
				    	  System.out.println("curWidget.getElement().getOffsetLeft() = " + curWidget.getElement().getOffsetLeft());
				    	  
				    	  //int positionOne = Window.getClientWidth()/2 - 150;
				    	  //offsetDir = positionOne - curWidget.getElement().getOffsetLeft();
				    	  findedInHistory = true;
				   	  }
		      }
		      
			   
			   
		}
		*/
			   
			   
			   
}

