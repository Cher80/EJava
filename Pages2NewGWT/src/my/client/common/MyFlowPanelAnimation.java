package my.client.common;

import my.client.common.MyFlowPanel;

import com.google.gwt.animation.client.Animation;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.dom.client.Style;
public class MyFlowPanelAnimation extends Animation {


	private MyFlowPanel flowPanel;
	private int startX;
    private int startY;
    private int finalX;
    private int finalY;
    
	 public MyFlowPanelAnimation(MyFlowPanel flowPanel)
	   {
	   
	        this.flowPanel = flowPanel;
	   }
	 
	 public void scrollTo(int x, int y, int x2, int y2, int milliseconds)
	    {
	        this.finalX = x;
	        this.finalY = y;
	 
	        this.startX = x2;
	        this.startY = y2;
	 
	        run(milliseconds);
	    }
	 
	@Override
	protected void onUpdate(double progress) {
		// TODO Auto-generated method stub
		double positionX = startX + (progress * (this.finalX - startX));
        double positionY = startY + (progress * (this.finalY - startY));
   	 	System.out.println("onUpdate X = " + positionX);

        //this.widget.getElement().
       // this.widget.getElement().getStyle().setLeft(positionX, Style.Unit.PX);
        //this.widget.getElement().getStyle().setTop(positionY, Style.Unit.PX);
   	 	flowPanel.getElement().getStyle().setProperty("left",positionX + "PX");
	}
	
	@Override
    protected void onComplete()
    {
        super.onComplete();
        //flowPanel.doClearance(this.widget);
        //this.element.getStyle().setLeft(this.finalX, Style.Unit.PX);
        //this.element.getStyle().setTop(this.finalY, Style.Unit.PX);
    }

}
