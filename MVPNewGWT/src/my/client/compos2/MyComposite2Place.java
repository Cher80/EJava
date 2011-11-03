package my.client.compos2;

import my.client.compos.MyCompositePlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MyComposite2Place extends Place {
	
	private String placeName;

    public MyComposite2Place(String token) {
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }

    public static class Tokenizer implements PlaceTokenizer<MyComposite2Place> {
        @Override
        public String getToken(MyComposite2Place place) {
            return place.getPlaceName();
        }

        @Override
        public MyComposite2Place getPlace(String token) {
            return new MyComposite2Place(token);
        }
    }

}
