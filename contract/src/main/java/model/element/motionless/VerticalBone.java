package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The HorizontalBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class VerticalBone extends MotionlessElement {
    
	/**
     * Instantiates a new VerticalBone.
     * @param position
     * 			the position.
     */
    public VerticalBone(Position position) {
    	super('|', 1, 6, Permeability.BLOCKING, position);
    }
}