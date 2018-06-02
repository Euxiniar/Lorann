/**
 * <h1>The Crocrodil.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

class Crocrodil extends Monster {

	public Crocrodil(Position position) {
    	super('4', 0, 4, 1, Permeability.KILLER, position, Behaviour.SILLY);
	}
}
