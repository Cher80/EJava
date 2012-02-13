/*
 * Copyright 2008 Google Inc.
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

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.HasOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Element;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Base class for panels that contain only one widget.
 */
public class PanelForView extends Panel implements HasOneWidget {
	 Widget currntWidget;
  Widget widget;
  Widget widgetOld;
  ArrayList<Widget> widgetsAll = new ArrayList<Widget>();

  /**
   * Creates an empty panel that uses a DIV for its contents.
   */
  public PanelForView() {
    this(DOM.createDiv());
  }

  /**
   * Create a panel with the specified child widget.
   *
   * @param child the child to add to the panel
   */
  public PanelForView(Widget child) {
    this();
    setWidget(child);
  }

  /**
   * Creates an empty panel that uses the specified browser element for its
   * contents.
   *
   * @param elem the browser element to use
   */
  protected PanelForView(Element elem) {
    setElement(elem);
  }
 
  /**
   * Adds a widget to this panel.
   *
   * @param w the child widget to be added
   */
  @Override
  public void add(Widget w) {
    // Can't add() more than one widget to a SimplePanel.
    if (getWidget() != null) {
      throw new IllegalStateException("SimplePanel can only contain one child widget");
    }
    setWidget(w);
  }

  /**
   * Gets the panel's child widget.
   *
   * @return the child widget, or <code>null</code> if none is present
   */
  public Widget getWidget() {
    return widget;
  }

  public Iterator<Widget> iterator() {
    // Return a simple iterator that enumerates the 0 or 1 elements in this
    // panel.
    return new Iterator<Widget>() {
      boolean hasElement = widget != null;
      Widget returned = null;

      public boolean hasNext() {
        return hasElement;
      }

      public Widget next() {
        if (!hasElement || (widget == null)) {
          throw new NoSuchElementException();
        }
        hasElement = false;
        return (returned = widget);
      }

      public void remove() {
        if (returned != null) {
        	PanelForView.this.remove(returned);
        }
      }
    };
  }

  @Override
  public boolean remove(Widget w) {
    // Validate.
    if (widget != w) {
      return false;
    }

    // Orphan.
    try {
      orphan(w);
    } finally {
      // Physical detach.
      getContainerElement().removeChild(w.getElement());
 
      // Logical detach.
      widget = null;
    }
    return true;
  }
 
  public void setWidget(IsWidget w) {
    setWidget(asWidgetOrNull(w));
  }

  /**
   * Sets this panel's widget. Any existing child widget will be removed.
   *
   * @param w the panel's new widget, or <code>null</code> to clear the panel
   */
  
  
  public void setWidget(Widget w) {
    // Validate
    
	  widgetsAll.add(w);
	  
	  int curWidgetsStack = widgetsAll.size();;
	  System.out.println("w = " + w);
	  System.out.println("curWidgetsStack = " + curWidgetsStack);
	  
	  
	  // Validate
	  /*
	    if (w == widget) {
	      return;
	    }
	    */

	    // Detach new child.
	    if (w != null) {
	      w.removeFromParent();
	    }

	    // Remove old child.
	    if (widget != null) {
	      remove(widget);
	    }

	    // Logical attach.
	    widget = w;

	    if (w != null) {
	      // Physical attach.
	      DOM.appendChild(getContainerElement(), widget.getElement());

	      adopt(w);
	    }

  }

  /**
   * Override this method to specify that an element other than the root element
   * be the container for the panel's child widget. This can be useful when you
   * want to create a simple panel that decorates its contents.
   *
   * Note that this method continues to return the
   * {@link com.google.gwt.user.client.Element} class defined in the
   * <code>User</code> module to maintain backwards compatibility.
   *
   * @return the element to be used as the panel's container
   */
  protected com.google.gwt.user.client.Element getContainerElement() {
    return getElement();
  }
}



/*
package my.client.common;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;

public class PanelForView extends SimplePanel implements AcceptsOneWidget {

	
	Widget myWidget = null;
	@Override
	public void setWidget(IsWidget w) {
		// TODO Auto-generated method stub
		
		
		   // Validate
	    if (w == myWidget) {
	      return;
	    }

	    // Detach new child.
	    if (w != null) {
	      w.removeFromParent();
	    }

	    // Remove old child.
	    if (myWidget != null) {
	      remove(myWidget);
	    }

	    // Logical attach.
	    myWidget = w;

	    if (w != null) {
	      // Physical attach.
	      DOM.appendChild(getContainerElement(), myWidget.getElement());

	      adopt(w);
	    }

		
		
		if (myWidget != w)
        {
            if (myWidget != null)
            {
                remove(myWidget);
            }

            if (w != null)
            {
                add(w);
            }

            myWidget = w;
        }
        
	}

}
*/
