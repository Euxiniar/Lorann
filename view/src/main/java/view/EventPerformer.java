package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import GameFrame.IEventPerformer;

public class EventPerformer implements IEventPerformer{
	
	//-----------------------------Boolean to know witch key is in use---------------------
	
	boolean boolZ = false;
	boolean boolD = false;
	boolean boolS = false;
	boolean boolQ = false;
	
	boolean boolUP    = false;
	boolean boolRIGHT = false;
	boolean boolDOWN  = false;
	boolean boolLEFT  = false;
	
	boolean[] boolsKeys = {boolZ,boolD,boolS,boolQ,boolUP,boolRIGHT,boolDOWN,boolLEFT};
	int[] allKeys = {KeyEvent.VK_Z,KeyEvent.VK_D,KeyEvent.VK_S,KeyEvent.VK_Q,KeyEvent.VK_UP,KeyEvent.VK_RIGHT,KeyEvent.VK_DOWN,KeyEvent.VK_LEFT};
	Enum[] enumOrder = {Order.UP,Order.RIGHT,Order.DOWN,Order.LEFT};
	
	public void eventPerform(int key) {
			TrueKeyInUse(key);
		}
	
	public void TrueKeyInUse(int key) {
		for(int i = 0;i < this.boolsKeys.length;i++) {
			if (key == allKeys[i])
				boolsKeys[i] = true;
		}
		
	public void KeyToOrder() {
	//-------------------------------Player move double key --------------------
		if (boolQ && boolZ) {
			userOrder = new UserOrder(Order.UPLEFT);
		}
		if (boolQ && boolS) {
			userOrder = new UserOrder(Order.DOWNLEFT);
		}
		if (boolD && boolZ) {
			userOrder = new UserOrder(Order.UPRIGHT);
		}
		if (boolD && boolS) {
			userOrder = new UserOrder(Order.DOWNLEFT);
		}
		
		for(int i = 0;i < this.boolsKeys.length / 2 ;i++) {
			if (boolsKeys[i])
				userOrder = new UserOrder(enumOrder[i])
		}
		
		//-----------------------------Spell start double key ----------------------
		//add if testLance !
		if (boolUP && boolLEFT) {
			//spawn spell direction[Direction.UPLEFT);
		}
		if (boolUP && boolRIGHT) {
			//spawn spell direction[Direction.DOWNLEFT);
		}
		if (boolDOWN && boolLEFT) {
			//spawn spell direction[Direction.UPRIGHT);
		}
		if (boolDOWN && boolRIGHT) {
			//spawn spell direction[Direction.DOWNRIGHT);
		}
		
		for(int i = this.boolsKeys.length / 2;i < this.boolsKeys.length;i++) {
			if (boolsKeys[i]) {
				//spawn spell direction[enumOrder[i]]
			}
		}
	}
}