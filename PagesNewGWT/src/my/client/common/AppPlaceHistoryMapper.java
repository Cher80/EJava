package my.client.common;

import my.client.compos.MyCompositePlace;
import my.client.compos2.MyComposite2Place;
import my.client.menu.MenuPlace;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

@WithTokenizers({MyCompositePlace.Tokenizer.class, MyComposite2Place.Tokenizer.class, MenuPlace.Tokenizer.class})
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {

}