package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The BallBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class BallBone extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	BallBone(BufferedImage spriteSheet) {
    	super('O', spriteSheet, 2, 6, Permeability.BLOCKING);
    }
}