/**
 * <h1>The Skeleton.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;


public class Skeleton extends Monster{

	public Skeleton(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('1', spriteSheet, 0, 1, 8, Permeability.KILLER, xPos, yPos);
	}
}
