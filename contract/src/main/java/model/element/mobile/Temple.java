package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Temple Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Temple extends Monster{

	/**
	 * Creates a Crocrodil.
	 * @param position
	 * 			the position.
	 */
	public Temple(Position position) {
    	super('3', 0, 3, 1, Permeability.KILLER, position, Behaviour.SILLY);
	}
}
