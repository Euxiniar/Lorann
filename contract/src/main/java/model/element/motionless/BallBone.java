package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The BallBone Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class BallBone extends MotionlessElement {
    
    /**
     * Instantiates a new BallBone.
     * @param position
     * 			the position.
     */
	public BallBone(Position position) {
    	super('O', 2, 6, Permeability.BLOCKING, position);
    }
}