package my.client.compos;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MyCompositePlace extends Place {
	
	private String placeName;

    public MyCompositePlace(String token) {
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }

    public static class Tokenizer implements PlaceTokenizer<MyCompositePlace> {
        @Override
        public String getToken(MyCompositePlace place) {
            return place.getPlaceName();
        }

        @Override
        public MyCompositePlace getPlace(String token) {
            return new MyCompositePlace(token);
        }
    }


}
