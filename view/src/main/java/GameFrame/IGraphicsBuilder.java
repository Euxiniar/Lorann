package GameFrame;

import java.awt.Graphics;

/**
 * <h1>The IGraphicsBuilder.java Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
public interface IGraphicsBuilder {
	/**
	 * Draw All the components.
	 * @param graphics
	 * 		the graphics.
	 */
	public void applyModelToGraphic(Graphics graphics);

}
