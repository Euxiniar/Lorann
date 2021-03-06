package view.gameFrame;

import java.awt.Graphics;

import java.util.Observable;
import java.util.Observer;


import javax.swing.JPanel;

/**
 * <h1>The GamePanel.java Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class GamePanel extends JPanel implements Observer{
	/**
	 * set the serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * the object graphicsBuilder
	 */
	private final IGraphicsBuilder	graphicsBuilder;
	
	
	/**
	 * the constructor, set the graphicsBuilder
	 * @param graphicsBuilder
	 * 				the graphics builder.
	 */
	public GamePanel(IGraphicsBuilder graphicsBuilder) {
		this.graphicsBuilder = graphicsBuilder;
	}

	@Override
	public void update(Observable observable, Object arg) {
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		this.graphicsBuilder.applyModelToGraphic(g);
	}
}
