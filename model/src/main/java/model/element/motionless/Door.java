package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The Door Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Door extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	Door(BufferedImage spriteSheet) {
    	super('D', spriteSheet, 0, 9, 2, Permeability.KILLER);
    }
}