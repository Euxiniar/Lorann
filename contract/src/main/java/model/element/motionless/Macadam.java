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
     * Instantiates a new Macadam.
     * @param position
     * 			the position.
     */
	Macadam(Position position) {
    	super(' ', 1, 3, Permeability.PENETRABLE, position);
    	this.setAlive(false);
    }
}