package my.client.compos;

import com.google.gwt.event.shared.GwtEvent;

public class ComposedEvent extends GwtEvent<IMyCompositeEventHandler> {

	public static Type<IMyCompositeEventHandler> TYPE = new Type<IMyCompositeEventHandler>();
	public int myVar;
	
    public ComposedEvent(int myVar) {
        super();
        this.myVar = myVar;
    }

	
	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<IMyCompositeEventHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(IMyCompositeEventHandler handler) {
		// TODO Auto-generated method stub
		handler.onComposed(this);
	}

}
