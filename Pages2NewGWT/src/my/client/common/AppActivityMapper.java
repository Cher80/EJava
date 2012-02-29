package my.client.common;

import java.util.Stack;

import my.client.compos.MyCompositeActivity;
import my.client.compos.MyCompositePlace;
import my.client.compos2.MyComposite2Activity;
import my.client.compos2.MyComposite2Place;
import my.client.forum.ForumActivity;
import my.client.forum.ForumPlace;
import my.client.helpers.HavePlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.Widget;

public class AppActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public AppActivityMapper(ClientFactory clientFactory) {
        super();
        
        this.clientFactory = clientFactory;
    }

	@Override
	public Activity getActivity(Place place) {
		// TODO Auto-generated method stub
		if (place instanceof MyCompositePlace)
            return new MyCompositeActivity((MyCompositePlace) place, clientFactory);
		else if (place instanceof MyComposite2Place)
            return new MyComposite2Activity((MyComposite2Place) place, clientFactory);
		else if (place instanceof ForumPlace) {
			//clientFactory.
			//mapper.getToken(new MyPlace(stateVar1,
					//stateVar2
			//String token =	clientFactory.getHistoryMapper().getToken(place);
			//System.out.println("AppActivityMapper =" + token);
			
			ForumActivity toReturnActivity = (ForumActivity) clientFactory.getHistoryKeeper().checkIsVisited(place);
			if (toReturnActivity == null) {
				toReturnActivity = new ForumActivity((ForumPlace) place, clientFactory);
				clientFactory.getHistoryKeeper().pushNewActivity((ForumActivity)toReturnActivity);
			}
			else {
				Stack <Widget>widgetsStack =  clientFactory.getHistoryKeeper().getWidgetsToMove();
			}
			
			Place oldPlace = ((HavePlace) toReturnActivity).getPlace();
			String oldToken =	clientFactory.getHistoryMapper().getToken(oldPlace);	    	
	    	System.out.println("toReturnActivity oldToken = " + oldToken);
			
	    	//
			//ForumActivity toReturnActivity = new ForumActivity((ForumPlace) place, clientFactory);
			return toReturnActivity;
		}
        return null;
		
	}

}
