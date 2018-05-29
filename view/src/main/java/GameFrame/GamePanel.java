package GameFrame;

import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		if (true) { //modify later
			player.update(System.currentTimeMillis());
			
			g.drawImage(Lorann.sprite, x, y, widthEntity ,heightEntity , null);
		}
		if (true) { //modify later
			Monster1.update(System.currentTimeMillis());
			
			g.drawImage(Monster1.sprite, monster.getX(), monster.getY(), widthEntity ,heightEntity , null);
		}

		if (Spell.spellLance) {//modify later
			Spell.update(System.currentTimeMillis());
			
			g.drawImage(Spell.sprite, spell.getX(), spell.getY(), widthEntity ,heightEntity , null);
		}
		
		repaint();

	}
}
