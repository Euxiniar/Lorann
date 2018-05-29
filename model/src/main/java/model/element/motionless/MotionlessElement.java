package model.element.motionless;

import java.awt.image.BufferedImage;

import model.element.Element;
import model.element.Permeability;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class MotionlessElement extends Element {

    /**
     * Instantiates a new motionless element.
     *
     * @param sprite
     *            the sprite
     * @param permeability
     *            the permeability
     */
    MotionlessElement(char character, BufferedImage spriteSheet, int xImagePos, int yImagePos, int nbSprites, Permeability permeability) {
        super(character, spriteSheet, xImagePos, yImagePos, nbSprites, permeability);
    }
    
    MotionlessElement(char character, BufferedImage spriteSheet, int xImagePos, int yImagePos, Permeability permeability) {
        this(character, spriteSheet, xImagePos, yImagePos, 1, permeability);
    }

}