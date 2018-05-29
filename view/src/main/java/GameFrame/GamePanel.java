package GameFrame;

import java.awt.Graphics;

import javax.swing.JPanel;

import model.element.mobile.MobileElement;
import model.element.motionless.MotionlessElement;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		
//		MotionlessElement[] motionlessElementsPermanent;
//		MotionlessElement[] motionlessElementsGrabable;
//		MobileElement[] mobilesElements;
		
		//faire constructeur
		
		//Draw all the elements of the 3 arrays
		for (MotionlessElement element : motionlessElementsPermanent) {
			g.drawImage(element.sprite, element.getPosition().getX()*widthEntity, element.getPosition().getY()*heightEntity, widthEntity ,heightEntity , null);
		}
		for (MotionlessElement element : motionlessElementsGrabable) {
			g.drawImage(element.sprite, element.getPosition().getX()*widthEntity, element.getPosition().getY()*heightEntity, widthEntity ,heightEntity , null);
		}
		for (MotionlessElement element : mobilesElements) {
			g.drawImage(element.sprite, element.getPosition().getX()*widthEntity, element.getPosition().getY()*heightEntity, widthEntity ,heightEntity , null);
		}
		
		
		repaint();

	}
}
