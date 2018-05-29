/**
 * <h1>The Mobile.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Direction;
import model.element.Element;
import model.element.Permeability;

abstract class MobileElement extends Element {

	Position position;
	Direction defaultDirection;
	
	/**
	 * @param character
	 * @param spriteSheet
	 * @param xPos
	 * @param yPos
	 * @param nbSprites
	 * @param permeability
	 */
	public MobileElement(char character, BufferedImage spriteSheet, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, int xPos, int yPos) {
		super(character, spriteSheet, xSpritePos, ySpritePos, nbSprites, permeability);
		this.setPosition(xPos, yPos);
	}
	
	public MobileElement(char character, BufferedImage spriteSheet, int xSpritePos, int ySpritePos,
			Permeability permeability, int xPos, int yPos) {
		this(character, spriteSheet, xSpritePos, ySpritePos, 1, permeability, xPos, yPos);
	}
	
	public void move(Direction direction) {
		switch(direction) {
		case UP:
			position.setPosition(position.getX(), position.getY() + 1);
		case DOWN:
			position.setPosition(position.getX(), position.getY() - 1);
		case LEFT:
			position.setPosition(position.getX() - 1, position.getY());
		case RIGHT:
			position.setPosition(position.getX() + 1, position.getY());
		case UPLEFT:
			position.setPosition(position.getX() - 1, position.getY() + 1);
		case UPRIGHT:
			position.setPosition(position.getX() + 1, position.getY() + 1);
		case DOWNLEFT:
			position.setPosition(position.getX() - 1, position.getY() - 1);
		case DOWNRIGHT:
			position.setPosition(position.getX() + 1, position.getY() - 1);
		default:
			break;
		}
	}
	
	public void move() {
		this.move(this.defaultDirection);
	}
	
	public void setDefaultDirection(Direction direction) {
		this.defaultDirection = direction;
	}
	
	public void setPosition(int x, int y) {
		position.setPosition(x, y);
	}
}
