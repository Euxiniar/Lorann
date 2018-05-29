package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The HorizontalBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class HorizontalBone extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	HorizontalBone(BufferedImage spriteSheet) {
    	super('-', spriteSheet, 0, 6, Permeability.BLOCKING);
    }
}