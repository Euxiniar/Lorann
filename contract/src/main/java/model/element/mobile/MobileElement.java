/**
 * <h1>The Mobile.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Element;
import model.element.Permeability;
import model.element.Position;

public abstract class MobileElement extends Element {

	Direction direction;
	
	/**
	 * @param character
	 * @param spriteSheet
	 * @param xPos
	 * @param yPos
	 * @param nbSprites
	 * @param permeability
	 */
	public MobileElement(char symbol, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, Position position) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
	}
	
	public MobileElement(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, int xPos, int yPos, Position position) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position);
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
}
