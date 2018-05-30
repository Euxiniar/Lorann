/**
 * <h1>The Macadam.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The BallBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Macadam extends MotionlessElement {
    
    /**
     * Instantiates a new VerticalBone.
     */
	Macadam(Position position) {
    	super(' ', 2, 6, Permeability.BLOCKING, position);
    	this.setAlive(false);
    }
}