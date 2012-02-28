package my.client.common;

import java.util.Iterator;
import java.util.Stack;

import my.client.forum.ForumActivity;
import my.client.forum.ForumView;
import my.client.helpers.HavePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

public class HistoryKeeper {
	private Stack <Widget>widgetsStack =  new Stack<Widget>();
	private Stack <ForumActivity>activityStack =  new Stack<ForumActivity>();
	private ClientFactory clientFactory;
	public HistoryKeeper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	public ForumActivity checkIsVisited(Place newPlace) {
		//
//		String newToken = ((ForumView) widget).getPresenter().getName();
		String newToken =	clientFactory.getHistoryMapper().getToken(newPlace);
    	System.out.println("checkIsVisited iterator newToken = " + newToken);

		Iterator<ForumActivity> it = activityStack.iterator();
	    while(it.hasNext()){
	    	
	    	ForumActivity curActivity = (ForumActivity) it.next();
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
	
	public void pushNewActivity(ForumActivity newWidget) {
		activityStack.push(newWidget);
	}
	
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
				   	  String oldToken = ((ForumView) curWidget).getPresenter().getName();
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
			   
			   
			   
	}
}
