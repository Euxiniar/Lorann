/**
 * <h1>The Player.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

public class Player extends MobileElement{

	public Player(Position position) {
    	super('*', 0, 0, 8, Permeability.BLOCKING, position);
	}
}
