/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package my.client.common;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.gwt.place.shared.PlaceChangeRequestEvent;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.Window.ClosingEvent;
import com.google.gwt.user.client.Window.ClosingHandler;

import java.util.logging.Logger;

/**
 * In charge of the user's location in the app.
 */
public class MyPlaceController extends PlaceController {

  public MyPlaceController(EventBus eventBus) {
		super(eventBus);
		// TODO Auto-generated constructor stub
	}



  /**
   * Request a change to a new place. It is not a given that we'll actually get
   * there. First a {@link PlaceChangeRequestEvent} will be posted to the
   * event bus. If any receivers post a warning message to that event, it will
   * be presented to the user via {@link Delegate#confirm(String)} (which is
   * typically a call to {@link Window#confirm(String)}). If she cancels, the
   * current location will not change. Otherwise, the location changes and a
   * {@link PlaceChangeEvent} is posted announcing the new place.
   */
  public void goTo(Place newPlace) {
	  
	  super.goTo(newPlace);
  }


}