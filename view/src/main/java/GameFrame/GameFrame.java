package GameFrame;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.EventPerformer;
import view.IEventPerformer;
	
@SuppressWarnings("deprecation")
//public class GameFrame extends JFrame implements KeyListener {
//	
//		//----------------------------Key Boolean------------------------------------------
//	
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	private boolean boolZ = false;
//	private boolean boolD = false;
//	private boolean boolS = false;
//	private boolean boolQ = false;
//	
//	private boolean boolUP = false;
//	private boolean boolRIGHT = false;
//	private boolean boolDOWN = false;
//	private boolean boolLEFT = false;
//	
//	//-----------------------------eventPerformer---------------------------------------
//	//modify later
//	IEventPerformer eventPerformer;;
//	
//	
//	//D---------------------------detect the key in use and start eventPerform--------------
//	
//	public GameFrame(final String title, final IEventPerformer eventPerformer, final IGraphicsBuilder graphicsBuilder, final Observable observable)
//			throws HeadlessException {
//		this.eventPerformer = eventPerformer;
//	
//		this.setTitle(title);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		this.setResizable(false);
//		this.addKeyListener(this);
//		this.setVisible(true);
//	
//		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
//		this.setContentPane(gamePanel);
//		this.setSize(1000,800);
//		this.setLocationRelativeTo(null);
//		observable.addObserver(gamePanel);
//	
//		this.setVisible(true);
//	}
//	
//	
//	@Override
//	public void keyPressed(final KeyEvent keyEvent) {
//		int key = keyEvent.getKeyCode();
//		if (key == KeyEvent.VK_Z)
//			boolZ = true;
//		if (key == KeyEvent.VK_D)
//			boolD = true;
//		if (key == KeyEvent.VK_S)
//			boolS = true;
//		if (key == KeyEvent.VK_Q)
//			boolQ = true;
//		
//		if (key == KeyEvent.VK_UP)
//			boolUP = true;
//		if (key == KeyEvent.VK_RIGHT)
//			boolRIGHT = true;
//		if (key == KeyEvent.VK_DOWN)
//			boolDOWN = true;
//		if (key == KeyEvent.VK_LEFT)
//			boolLEFT = true;
//		
//		eventPerformer.eventPerform(boolZ, boolD, boolS, boolQ, boolUP, boolRIGHT, boolDOWN, boolLEFT);
//	}
//	
//	@Override
//	public void keyReleased(final KeyEvent keyEvent) {
//		// TODO Auto-generated method stub
//		int key = keyEvent.getKeyCode();
//		if (key == KeyEvent.VK_Z)
//			boolZ = false;
//		if (key == KeyEvent.VK_D)
//			boolD = false;
//		if (key == KeyEvent.VK_S)
//			boolS = false;
//		if (key == KeyEvent.VK_Q)
//			boolQ = false;
//		
//		if (key == KeyEvent.VK_UP)
//			boolUP = false;
//		if (key == KeyEvent.VK_RIGHT)
//			boolRIGHT = false;
//		if (key == KeyEvent.VK_DOWN)
//			boolDOWN = false;
//		if (key == KeyEvent.VK_LEFT)
//			boolLEFT = false;
//	}
//	
//	@Override
//	public void keyTyped(final KeyEvent keyEvent) {
//		// TODO Auto-generated method stub
//	
//	}
//}

public class GameFrame extends JFrame implements KeyListener, Runnable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//----------------------------Key Boolean------------------------------------------

/**
 * 
 */

	private static boolean boolZ = false;
	private static boolean boolD = false;
	private static boolean boolS = false;
	private static boolean boolQ = false;
	
	private static boolean boolUP = false;
	private static boolean boolRIGHT = false;
	private static boolean boolDOWN = false;
	private static boolean boolLEFT = false;
	
	private static boolean[] tabBool = {boolZ,boolD,boolS,boolQ,boolUP,boolRIGHT,boolDOWN,boolLEFT};
	
	EventPerformer eventPerformer;
	//-----------------------------eventPerformer---------------------------------------
	//modify later
	
	Observable observable;
	IGraphicsBuilder graphicsBuilder;
	String title;
	
	//D---------------------------detect the key in use and start eventPerform--------------
	
	public GameFrame(final String title, final IGraphicsBuilder graphicsBuilder, final Observable observable)
			throws HeadlessException {
		this.observable = observable;
		this.graphicsBuilder = graphicsBuilder;
		this.title = title;
		
		this.addKeyListener(this);
		SwingUtilities.invokeLater(this);
		
		
		
		//this.eventPerformer = new EventPerformer();
	}
	
	
	@Override
	public void keyPressed(final KeyEvent keyEvent) {
		int key = keyEvent.getKeyCode();
		if (key == KeyEvent.VK_Z)
			tabBool[0] = true;
		if (key == KeyEvent.VK_D)
			tabBool[1] = true;
		if (key == KeyEvent.VK_S)
			tabBool[2] = true;
		if (key == KeyEvent.VK_Q)
			tabBool[3] = true;
		
		if (key == KeyEvent.VK_UP)
			tabBool[4] = true;
		if (key == KeyEvent.VK_RIGHT)
			tabBool[5] = true;
		if (key == KeyEvent.VK_DOWN)
			tabBool[6] = true;
		if (key == KeyEvent.VK_LEFT)
			tabBool[7] = true;
		
	}
	
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
		int key = keyEvent.getKeyCode();
		if (key == KeyEvent.VK_Z)
			tabBool[0] = false;
		if (key == KeyEvent.VK_D)
			tabBool[1] = false;
		if (key == KeyEvent.VK_S)
			tabBool[2] = false;
		if (key == KeyEvent.VK_Q)
			tabBool[3] = false;
		
		if (key == KeyEvent.VK_UP)
			tabBool[4] = false;
		if (key == KeyEvent.VK_RIGHT)
			tabBool[5] = false;
		if (key == KeyEvent.VK_DOWN)
			tabBool[6] = false;
		if (key == KeyEvent.VK_LEFT)
			tabBool[7] = false;
	}
	
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// TODO Auto-generated method stub
	
	}

	public synchronized boolean[] getBools() {
		return tabBool;
	}


	@Override
	public void run() {
		this.setTitle(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setBackground(Color.BLACK);
		
		final GamePanel gamePanel = new GamePanel(graphicsBuilder);
		this.setContentPane(gamePanel);
		this.setSize(1015,800);
		this.setLocationRelativeTo(null);
		observable.addObserver(gamePanel);
		this.setVisible(true);
		
	}
}