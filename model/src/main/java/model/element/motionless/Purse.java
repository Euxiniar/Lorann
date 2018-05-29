package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The Purse Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Purse extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	Purse(BufferedImage spriteSheet) {
    	super('P', spriteSheet, 0, 8, Permeability.GRABABLE);
    }
}