package my.client.compos;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MyCompositePlace extends Place {
	
	private String myCompositeName;

    public MyCompositePlace(String token) {
        this.myCompositeName = token;
    }

    public String getMyCompositeName() {
        return myCompositeName;
    }

    public static class Tokenizer implements PlaceTokenizer<MyCompositePlace> {
        @Override
        public String getToken(MyCompositePlace place) {
            return place.getMyCompositeName();
        }

        @Override
        public MyCompositePlace getPlace(String token) {
            return new MyCompositePlace(token);
        }
    }


}
