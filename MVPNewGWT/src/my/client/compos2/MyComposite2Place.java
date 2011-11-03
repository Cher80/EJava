package my.client.compos2;

import my.client.compos.MyCompositePlace;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class MyComposite2Place extends Place {
	
	private String myComposite2Name;

    public MyComposite2Place(String token) {
        this.myComposite2Name = token;
    }

    public String getMyComposite2Name() {
        return myComposite2Name;
    }

    public static class Tokenizer implements PlaceTokenizer<MyComposite2Place> {
        @Override
        public String getToken(MyComposite2Place place) {
            return place.getMyComposite2Name();
        }

        @Override
        public MyComposite2Place getPlace(String token) {
            return new MyComposite2Place(token);
        }
    }

}
