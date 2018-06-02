package GameFrame;
/**
 * <h1>The IGraphicsBuilder.java Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
import java.awt.Graphics;
import java.awt.image.ImageObserver;

public interface IGraphicsBuilder {
	public void applyModelToGraphic(Graphics graphics, ImageObserver observer);

}
