package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Krannox Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */

public class Krannox extends Monster{

	/**
	 * Creates a Krannox.
	 * @param position
	 * 			the position.
	 */
	public Krannox(Position position) {
    	super('2', 0, 2, 7, Permeability.KILLER, position, Behaviour.NORMAL);
	}
}
