package my.client.topmenu;

//import my.client.compos.MyCompositePlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class TopmenuPlace extends Place {
	
	private String placeName;

    public TopmenuPlace(String token) {
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }

    @Prefix("topmenu")
    public static class Tokenizer implements PlaceTokenizer<TopmenuPlace> {
        @Override
        public String getToken(TopmenuPlace place) {
            return place.getPlaceName();
        }

        @Override
        public TopmenuPlace getPlace(String token) {
        	System.out.println("TopmenuPlace getPlace token = " + token);
        	
        	return new TopmenuPlace(token);
        	
        	
        }
    }

}
