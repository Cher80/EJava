package my.client.compos;

public class MyCompositeEventHandler2 implements IMyCompositeEventHandler {

	@Override
	public void onComposed(ComposedEvent event) {
		// TODO Auto-generated method stub
		System.out.println(event.myVar + 5);
	}

}
