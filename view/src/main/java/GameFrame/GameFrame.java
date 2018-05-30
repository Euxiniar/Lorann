package GameFrame;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;


import view.EventPerformer;
	
	public class GameFrame extends JFrame implements KeyListener {
		
		//----------------------------Key Boolean------------------------------------------
		
		private boolean boolZ = false;
		private boolean boolD = false;
		private boolean boolS = false;
		private boolean boolQ = false;
		
		private boolean boolUP = false;
		private boolean boolRIGHT = false;
		private boolean boolDOWN = false;
		private boolean boolLEFT = false;
		
		//-----------------------------eventPerformer---------------------------------------
		//modify later
		IEventPerformer eventPerformer;;
		
		
		//D---------------------------detect the key in use and start eventPerform--------------
		
		public GameFrame(final String title, final IEventPerformer eventPerformer, final IGraphicsBuilder graphicsBuilder, final Observable observable)
				throws HeadlessException {
			this.eventPerformer = eventPerformer;

			this.setTitle(title);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
			this.addKeyListener(this);
			this.setVisible(true);

			final GamePanel gamePanel = new GamePanel(graphicsBuilder);
			this.setContentPane(gamePanel);
			this.setSize(1000,800);
			this.setLocationRelativeTo(null);
			observable.addObserver(gamePanel);

			this.setVisible(true);
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
			
			if (key == KeyEvent.VK_UP)
				boolUP = true;
			if (key == KeyEvent.VK_RIGHT)
				boolRIGHT = true;
			if (key == KeyEvent.VK_DOWN)
				boolDOWN = true;
			if (key == KeyEvent.VK_LEFT)
				boolLEFT = true;
			
			eventPerformer.eventPerform(boolZ, boolD, boolS, boolQ, boolUP, boolRIGHT, boolDOWN, boolLEFT);
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
			
			if (key == KeyEvent.VK_UP)
				boolUP = false;
			if (key == KeyEvent.VK_RIGHT)
				boolRIGHT = false;
			if (key == KeyEvent.VK_DOWN)
				boolDOWN = false;
			if (key == KeyEvent.VK_LEFT)
				boolLEFT = false;
		}
	
		@Override
		public void keyTyped(final KeyEvent keyEvent) {
			// TODO Auto-generated method stub
	
		}
}
