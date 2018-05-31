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
	private int life = 11;

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	public void addLife(int nbrLife) {
		this.life = life + nbrLife;
	}

	public void removeLife(int nbrLife) {
		this.life = life - nbrLife;
	}

	public Player(Position position) {
    	super('*', 0, 0, 8, Permeability.BLOCKING, position);
	}
}
