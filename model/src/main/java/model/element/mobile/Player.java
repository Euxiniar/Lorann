/**
 * <h1>The Player.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

public class Player extends MobileElement{

	public Player(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('*', spriteSheet, 0, 0, 8, Permeability.BLOCKING, xPos, yPos);
	}
}
