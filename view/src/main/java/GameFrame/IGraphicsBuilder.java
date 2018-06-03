package GameFrame;
/**
 * <h1>The IGraphicsBuilder.java Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
import java.awt.Graphics;

public interface IGraphicsBuilder {
	/**
	 * draw All the components
	 * @param graphics
	 */
	public void applyModelToGraphic(Graphics graphics);

}
