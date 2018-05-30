/**
 * <h1>The Skeleton.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;


class Skeleton extends Monster{

	public Skeleton(Position position) {
    	super('1', 0, 1, 8, Permeability.KILLER, position);
	}
}
