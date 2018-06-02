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
	private int score = 0;
	private boolean isPlayerhasMoved = false;

	public Player(Position position) {
    	super('*', 0, 0, 8, Permeability.BLOCKING, position);
	}
	
	public boolean isPlayerhasMoved() {
		return isPlayerhasMoved;
	}

	public void setPlayerhasMoved(boolean isPlayerhasMoved) {
		this.isPlayerhasMoved = isPlayerhasMoved;
	}

	public int getLife() {
		return this.life;
	}

	public void setLife(int life) {
		this.life = life;
	}
	public void addLife(int nbrLife) {
		this.life += nbrLife;
	}

	public void removeLife(int nbrLife) {
		this.life -= nbrLife;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int nbrScore) {
		this.score = nbrScore;
	}

	public void incrementScore() {
    	this.setScore(this.getScore() + 750);
	}
	
	public void resetScore() {
    	this.setScore(0);
	}
}
