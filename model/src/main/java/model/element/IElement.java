package model.element;

import java.awt.image.BufferedImage;

/**
 * <h1>The Element Interface.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public interface IElement {
	Sprite getSelectedSprite();
	Permeability getPermeability();
	BufferedImage getImage();
}
