package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Spell Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Spell extends MobileElement{

	/**
	 * Creates a Spell.
	 * @param position
	 * 			the position.
	 */
	public Spell(Position position) {
    	super('S', 0, 5, 5, Permeability.KILLER, position);
    	this.setAlive(false);
	}
}
