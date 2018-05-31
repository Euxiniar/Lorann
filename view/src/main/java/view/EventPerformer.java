package view;

import controller.IOrderPerformer;
import controller.Order;
import controller.UserOrder;

public class EventPerformer implements IEventPerformer{
	
	//-----------------------------Boolean to know witch key is in use---------------------
	
	private IOrderPerformer orderPerformer;
		
	public UserOrder keyToOrder(boolean boolZ ,boolean boolD ,boolean boolS,boolean boolQ,boolean boolUP ,boolean boolRIGHT ,boolean boolDOWN,boolean boolLEFT) {
		UserOrder order = null;
		if (boolZ && boolD) {
			order = new UserOrder(Order.UPRIGHT);
		}
		else if (boolZ && boolQ) {
			order = new UserOrder(Order.UPLEFT);
		}
		else if (boolS && boolD) {
			order = new UserOrder(Order.DOWNRIGHT);
		}
		else if (boolS && boolQ) {
			order = new UserOrder(Order.DOWNLEFT);
		}
		else if (boolZ) {
			order = new UserOrder(Order.UP);
		}
		else if (boolD) {
			order = new UserOrder(Order.RIGHT);
		}
		else if (boolS) {
			order = new UserOrder(Order.DOWN);
		}
		else if (boolD) {
			order = new UserOrder(Order.LEFT);
		}
		return order;
	}
	
	public EventPerformer (IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	@Override
	public void eventPerform(boolean boolZ ,boolean boolD ,boolean boolS,boolean boolQ,boolean boolUP ,boolean boolRIGHT ,boolean boolDOWN,boolean boolLEFT) {
		final UserOrder userOrder = this.keyToOrder( boolZ , boolD , boolS, boolQ, boolUP , boolRIGHT , boolDOWN, boolLEFT);
		if (userOrder != null) {
			this.orderPerformer.orderPerform(userOrder);
		}
		
	}
		
		//-----------------------------Spell start double key ----------------------

}