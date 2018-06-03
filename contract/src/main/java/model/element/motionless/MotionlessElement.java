package model.element.motionless;

import model.element.Element;
import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class MotionlessElement extends Element {

	/**
	 * Create a new Motionless Element.
	 * @param symbol
	 * 			the symbol
	 * @param xImagePos
	 * 			the x image position on the spriteSheet.
	 * @param yImagePos
	 * 			the y image position on the spriteSheet.
	 * @param nbSprites
	 * 			the number of sprites.
	 * @param permeability
	 * 			the element permeability.
	 * @param position
	 * 			the element position.
	 */
    MotionlessElement(char symbol, int xImagePos, int yImagePos, int nbSprites, Permeability permeability, Position position) {
        super(symbol, xImagePos, yImagePos, nbSprites, permeability, position);
    }
    
    /**
	 * Create a new Motionless Element, with only one sprite.
	 * @param symbol
	 * 			the symbol
	 * @param xImagePos
	 * 			the x image position on the spriteSheet.
	 * @param yImagePos
	 * 			the y image position on the spriteSheet.
	 * @param permeability
	 * 			the element permeability.
	 * @param position
	 * 			the element position.
	 */
    MotionlessElement(char symbol, int xImagePos, int yImagePos, Permeability permeability, Position position) {
        this(symbol, xImagePos, yImagePos, 1, permeability, position);
    }
}