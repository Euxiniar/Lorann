package GameFrame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;

import view.EventPerformer;
	
	public class GameFrame extends JFrame implements KeyListener {
		
		//----------------------------Key Boolean------------------------------------------
		
		public boolean boolZ = false;
		public boolean boolD = false;
		public boolean boolS = false;
		public boolean boolQ = false;
		
		//-----------------------------eventPerformer---------------------------------------
		//modify later
		IEventPerformer eventPerformer = new EventPerformer(null, boolD, boolD, boolD, boolD);
		
		
		//D---------------------------detect the key in use and start eventPerform--------------
		
		public GameFrame(String title, IEventPerformer eventPerformer, IGraphicsBuilder graphicsBuilder, Observable observable) {
			
		}
		
		
		@Override
		public void keyPressed(final KeyEvent keyEvent) {
			int key = keyEvent.getKeyCode();
			if (key == KeyEvent.VK_Z)
				boolZ = true;
			if (key == KeyEvent.VK_D)
				boolD = true;
			if (key == KeyEvent.VK_S)
				boolS = true;
			if (key == KeyEvent.VK_Q)
				boolQ = true;
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
