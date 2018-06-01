/**
 * <h1>The Spell.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

public class Spell extends MobileElement{

	public Spell(Position position) {
    	super('S', 0, 5, 5, Permeability.KILLER, position);
    	this.setAlive(false);
	}
}
