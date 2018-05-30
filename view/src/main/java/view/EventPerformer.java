package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import GameFrame.IEventPerformer;
import controller.IOrderPerformer;
import controller.Order;
import controller.UserOrder;

public class EventPerformer implements IEventPerformer{
	
	//-----------------------------Boolean to know witch key is in use---------------------
	
	
		
	public void keyToOrder(boolean boolZ ,boolean boolD ,boolean boolS,boolean boolQ,boolean boolUP ,boolean boolRIGHT ,boolean boolDOWN,boolean boolLEFT) {
		if (boolZ && boolD) {
			UserOrder order = new UserOrder(Order.UPRIGHT);
		}
		else if (boolZ && boolQ) {
			UserOrder order = new UserOrder(Order.UPLEFT);
		}
		else if (boolS && boolD) {
			UserOrder order = new UserOrder(Order.DOWNRIGHT);
		}
		else if (boolS && boolQ) {
			UserOrder order = new UserOrder(Order.DOWNLEFT);
		}
		else if (boolZ) {
			UserOrder order = new UserOrder(Order.UP);
		}
		else if (boolD) {
			UserOrder order = new UserOrder(Order.RIGHT);
		}
		else if (boolS) {
			UserOrder order = new UserOrder(Order.DOWN);
		}
		else if (boolD) {
			UserOrder order = new UserOrder(Order.LEFT);
		}
		
		}
	
	public EventPerformer (IOrderPerformer orderPerformer) {
		
	}

	@Override
	public void eventPerform(boolean boolZ ,boolean boolD ,boolean boolS,boolean boolQ,boolean boolUP ,boolean boolRIGHT ,boolean boolDOWN,boolean boolLEFT) {
		keyToOrder( boolZ , boolD , boolS, boolQ, boolUP , boolRIGHT , boolDOWN, boolLEFT);
		
		
	}
		
		//-----------------------------Spell start double key ----------------------

}