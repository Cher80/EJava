package my.client.forum;



import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

public class ForumPlace extends Place {

	
	private String placeName;

    public ForumPlace(String token) {
    	System.out.println("ForumPlace constructor");
        this.placeName = token;
    }

    public String getPlaceName() {
        return placeName;
    }

    @Prefix("ForumPref")
    public static class Tokenizer implements PlaceTokenizer<ForumPlace> {
        @Override
        public String getToken(ForumPlace place) {
            return place.getPlaceName();
        }

        @Override
        public ForumPlace getPlace(String token) {
        	//System.out.println("MyComposite2Place getPlace token = " + token);
      	return new ForumPlace(token);

        }
    }
}
