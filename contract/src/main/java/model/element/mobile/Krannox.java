/**
 * <h1>The Krannox.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

class Krannox extends Monster{

	public Krannox(Position position) {
    	super('2', 0, 2, 7, Permeability.KILLER, position, Behaviour.NORMAL);
	}
}
