/**
 * <h1>The Krannox.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

public class Krannox extends Monster{

	public Krannox(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('2', spriteSheet, 0, 2, 7, Permeability.KILLER, xPos, yPos);
	}
}
