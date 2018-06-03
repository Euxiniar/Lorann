package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Crocrodil Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
class Crocrodil extends Monster {

	/**
	 * Creates a Crocrodil.
	 * @param position
	 * 			the position.
	 */
	public Crocrodil(Position position) {
    	super('4', 0, 4, 1, Permeability.KILLER, position, Behaviour.SILLY);
	}
}
