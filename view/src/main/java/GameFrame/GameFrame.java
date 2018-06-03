package GameFrame;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
	
@SuppressWarnings("deprecation")
/**
 * <h1>The GameFrame.java Class.</h1>
 *
 * @author Charles Agostini / Anatole Couasnon
 * @version 1.0
 */
public class GameFrame extends JFrame implements KeyListener, Runnable {
	
	/**
	 * the serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	//----------------------------Key Boolean------------------------------------------

	/**
	 * all the boolean order
	 */
	private static boolean boolZ = false;
	private static boolean boolD = false;
	private static boolean boolS = false;
	private static boolean boolQ = false;
	
	private static boolean boolUP = false;
	private static boolean boolRIGHT = false;
	private static boolean boolDOWN = false;
	private static boolean boolLEFT = false;
	
	/**
	 * a array witch contain all the orders bools
	 */
	private static boolean[] tabBool = {boolZ,boolD,boolS,boolQ,boolUP,boolRIGHT,boolDOWN,boolLEFT};
	
	//-----------------------------eventPerformer---------------------------------------
	//modify later
	/**
	 * the observable
	 */
	Observable observable;
	/**
	 * *the graphicsBuilder
	 */
	IGraphicsBuilder graphicsBuilder;
	/**
	 * the title of the frame
	 */
	String title;
	
	//D---------------------------detect the key in use and start eventPerform--------------
	/**
	 * Constructor of GameFrame
	 * @param title
	 * set the title of the Frame in the object GameFrame
	 * @param graphicsBuilder
	 * set the graphicsBuilder in the object GameFrame
	 * @param observable
	 * set the observable  in the object GameFrame
	 */
	public GameFrame(final String title, final IGraphicsBuilder graphicsBuilder, final Observable observable){
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
	/**
	 * get the order bools
	 * @return
	 * the orders bools
	 */
	public boolean[] getBools() {
		return tabBool;
	}
	/**
	 * reset the orders bools
	 */
	public void resetBools() {
		for (int i = 0; i < tabBool.length; i++) {
			tabBool[i] = false;
		}
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