package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

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
	Purse(Position position) {
    	super('P', 0, 8, Permeability.GRABABLE, position);
    }
}