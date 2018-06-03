package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Skeleton Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Skeleton extends Monster{
	
	/**
	 * Creates a Skeleton.
	 * @param position
	 * 			the position.
	 */
	public Skeleton(Position position) {
    	super('1', 0, 1, 8, Permeability.KILLER, position, Behaviour.SMART);
	}
}
