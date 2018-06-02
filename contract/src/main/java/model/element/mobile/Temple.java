/**
 * <h1>The Temple.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

class Temple extends Monster{

	public Temple(Position position) {
    	super('3', 0, 3, 1, Permeability.KILLER, position, Behaviour.SILLY);
	}
}
