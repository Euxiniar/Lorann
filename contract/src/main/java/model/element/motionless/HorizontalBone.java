package model.element.motionless;


import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The HorizontalBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class HorizontalBone extends MotionlessElement {
    
	/**
     * Instantiates a new HorizontalBone.
     * @param position
     * 			the position.
     */
	HorizontalBone(Position position) {
    	super('-', 0, 6, Permeability.BLOCKING, position);
    }
}