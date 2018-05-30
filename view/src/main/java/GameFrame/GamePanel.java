package GameFrame;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;


import javax.swing.JPanel;

public class GamePanel extends JPanel implements Observer{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final IGraphicsBuilder	graphicsBuilder;

	public GamePanel(IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	public void update(Observable observable, Object arg) {
		this.repaint();
	}
	
	public void PaintComponent(Graphics g) {
		this.graphicsBuilder.applyModelToGraphic(g, this);
	}



}
