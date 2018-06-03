package model.element.motionless;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Door Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Door extends MotionlessElement {
    
    /**
     * Instantiates a new Door.
     * @param position
     * 			the position.
     */
	public Door(Position position) {
    	super('D', 0, 9, 2, Permeability.KILLER, position);
    }
	
}