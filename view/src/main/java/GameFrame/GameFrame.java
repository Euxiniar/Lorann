package GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import view.EventPerformer;
	
	public class GameFrame extends JFrame implements KeyListener {
		
		
		//-----------------------------eventPerformer---------------------------------------
		IEventPerformer eventPerformer = new EventPerformer();
		
		
		//D---------------------------detect the key in use and start eventPerform--------------
		@Override
		public void keyPressed(final KeyEvent keyEvent) {
			//stock boolean in model
			int key = keyEvent.getKeyCode();
			
			eventPerformer.eventPerform(key);
		}
	
		@Override
		public void keyReleased(final KeyEvent keyEvent) {
			// TODO Auto-generated method stub
			int key = keyEvent.getKeyCode();
			if (key == KeyEvent.VK_Z)
				boolZ = false;
			if (key == KeyEvent.VK_D)
				boolD = false;
			if (key == KeyEvent.VK_S)
				boolS = false;
			if (key == KeyEvent.VK_Q)
				boolQ = false;
		}
	
		@Override
		public void keyTyped(final KeyEvent keyEvent) {
			// TODO Auto-generated method stub
	
		}
}
