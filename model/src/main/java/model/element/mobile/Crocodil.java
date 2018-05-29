/**
 * <h1>The Crocodil.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

public class Crocodil extends MobileElement{

	public Crocodil(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('4', spriteSheet, 0, 4, 1, Permeability.KILLER, xPos, yPos);
	}
}
