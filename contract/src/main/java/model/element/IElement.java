package model.element;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * <h1>The Element Interface.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public interface IElement {
	/**
	 * Gets the sprite array.
	 * @return the sprite array.
	 */
	ArrayList<Sprite> getSpriteArray();
	/**
	 * Gets the sprite array size.
	 * @return the sprite array size.
	 */
	int getSpriteArraySize();
	/**
	 * Gets the element permeability.
	 * @return the permeability.
	 */
	Permeability getPermeability();
	/**
	 * Sets the permeability.
	 * @param permeability
	 * 			the permeability.
	 */
	void setPermeability(Permeability permeability);
	/**
	 * Gets the selected Image to draw.
	 * @return the selected image.
	 */
	BufferedImage getSelectedImage();
	/**
	 * Gets the element symbol.
	 * @return the element symbol.
	 */
	char getSymbol();
	/**
	 * Gets the selected sprite value.
	 * @return the selected sprite value.
	 */
	int getSelectedSpriteValue();
	/**
	 * Sets the selected sprite value.
	 * @param value
	 * 			the value.
	 */
	void setSelectedSpriteValue(int value);
	/**
	 * Gets the alive element state.
	 * @return the alive element state.
	 */
	boolean getIsAlive();
	/**
	 * Sets the alive element state.
	 * @param isAlive
	 * 			the alive element state.
	 */
	void setAlive(boolean isAlive);
	/**
	 * @deprecated Sets the position with coordinates.
	 * @param x
	 * 			the x position.
	 * @param y
	 * 			the y position.
	 */
	void setPosition(int x, int y);
	/**
	 * Sets position with a position object.
	 * @param position
	 * 			the position object.
	 */
	void setPosition(Position position);
	/**
	 * Gets the position object.
	 * @return the position object.
	 */
	Position getPosition();
}
