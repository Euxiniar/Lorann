package GameFrame;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JPanel;

@SuppressWarnings("deprecation")
public class GamePanel extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IGraphicsBuilder	graphicsBuilder;

	public GamePanel(IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	@Override
	public void update(Observable observable, Object arg) {
		System.out.println("repaint");
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.graphicsBuilder.applyModelToGraphic(g, this);
	}
}
