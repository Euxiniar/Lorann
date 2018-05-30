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
	ArrayList<Sprite> getSpriteArray();
	int getSpriteArraySize();
	Permeability getPermeability();
	BufferedImage getSelectedImage();
	char getSymbol();
	int getSelectedSpriteValue();
	void setSelectedSpriteValue(int value);
	boolean getIsAlive();
	void setAlive(boolean isAlive);
	void setPosition(int x, int y);
	void setPosition(Position position);
	Position getPosition();
}
