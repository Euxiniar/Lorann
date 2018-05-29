/**
 * <h1>The Monster.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * @author Euxiniar
 *
 */
public abstract class Monster extends MobileElement {
	public Monster(char character, BufferedImage spriteSheet, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, int xPos, int yPos) {
		super(character, spriteSheet, xSpritePos, ySpritePos, nbSprites, permeability, xPos, yPos);
		this.setPosition(xPos, yPos);
	}
	
	public Monster(char character, BufferedImage spriteSheet, int xSpritePos, int ySpritePos,
			Permeability permeability, int xPos, int yPos) {
		this(character, spriteSheet, xSpritePos, ySpritePos, 1, permeability, xPos, yPos);
	}
}
