/**
 * <h1>The Spell.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import java.awt.image.BufferedImage;

import model.element.Permeability;

public class Spell extends MobileElement{

	public Spell(BufferedImage spriteSheet, int xPos, int yPos) {
    	super('S', spriteSheet, 0, 5, 5, Permeability.KILLER, xPos, yPos);
	}
}
