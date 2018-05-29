/**
 * <h1>The Temple.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

public class Temple extends MobileElement{

	public Temple(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('3', spriteSheet, 0, 3, 1, Permeability.KILLER, xPos, yPos);
	}

}
