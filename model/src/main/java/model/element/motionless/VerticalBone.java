package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Permeability;

/**
 * <h1>The HorizontalBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class VerticalBone extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
    VerticalBone(BufferedImage spriteSheet) {
    	super('|', spriteSheet, 1, 6, Permeability.BLOCKING);
    }
}