/**
 * <h1>The MobileElement.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Element;
import model.element.Permeability;
import model.element.Position;

public abstract class MobileElement extends Element {

	/**
	 * The element direction.
	 */
	Direction direction = Direction.STATIC;
	
/**
 * Create a Mobile element.
 * @param symbol
 * 			the element symbol.
 * @param xSpritePos
 * 			the x position on the spriteSheet of the sprite.
 * @param ySpritePos
 * 			the y position on the spriteSheet of the sprite.
 * @param nbSprites
 * 			the number of sprites.
 * @param permeability
 * 			the element permeability.
 * @param position
 * 			the position of the element.
 */
	public MobileElement(char symbol, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, Position position) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
	}
	
	/**
	 * Create a Mobile element, with only one sprite.
	 * @param symbol
	 * 			the element symbol.
	 * @param xSpritePos
	 * 			the x position on the spriteSheet of the sprite.
	 * @param ySpritePos
	 * 			the y position on the spriteSheet of the sprite.
	 * @param permeability
	 * 			the element permeability.
	 * @param position
	 * 			the position of the element.
	 */
	public MobileElement(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, int xPos, int yPos, Position position) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position);
	}
	
	/**
	 * Sets the direction of the element.
	 * @param direction
	 * 				the direction.
	 */
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	/**
	 * Gets the direction.
	 * @return the direction.
	 */
	public Direction getDirection() {
		return this.direction;
	}
}
