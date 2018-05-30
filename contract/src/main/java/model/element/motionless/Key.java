package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

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
	Key(Position position) {
    	super('K', 0, 7, Permeability.GRABABLE, position);
    }
}