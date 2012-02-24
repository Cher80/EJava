package my.client.common;

import my.client.compos.MyCompositeActivity;
import my.client.compos.MyCompositePlace;
import my.client.compos2.MyComposite2Activity;
import my.client.compos2.MyComposite2Place;
import my.client.forum.ForumActivity;
import my.client.forum.ForumPlace;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;

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
		else if (place instanceof ForumPlace)
            return new ForumActivity((ForumPlace) place, clientFactory);
        return null;

		
		
	}

}
