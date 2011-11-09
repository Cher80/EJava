package my.client.compos2;

import my.client.compos.MyCompositePlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class MyComposite2Place extends Place {
	
	private String placeName;

    public MyComposite2Place(String token) {
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }

    @Prefix("Composite2Pref")
    public static class Tokenizer implements PlaceTokenizer<MyComposite2Place> {
        @Override
        public String getToken(MyComposite2Place place) {
            return place.getPlaceName();
        }

        @Override
        public MyComposite2Place getPlace(String token) {
        	System.out.println("MyComposite2Place getPlace token = " + token);
        	if (token.startsWith("composplace2")) {
        		return new MyComposite2Place(token);
        	       // parse what follows "foo/" and return a FooPlace
        	}
        	return new MyComposite2Place(token);
        	
        	
        }
    }

}
