package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The Key Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Key extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	Key(BufferedImage spriteSheet) {
    	super('K', spriteSheet, 0, 7, Permeability.GRABABLE);
    }
}