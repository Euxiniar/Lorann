package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Player Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Player extends MobileElement{
	/**
	 * The lifes of the player.
	 */
	private int life = 11;
	/**
	 * The score of the player.
	 */
	private int score = 0;
	/**
	 * the boolean state of the player to know if the player has moved.
	 */
	private boolean isPlayerhasMoved = false;
	/**
	 * Variable to know if the player has succeed the level.
	 */
	private boolean hasSucceedLvl = false;
	
	/**
	 * Creates a player.
	 * @param position
	 * 				the position.
	 */
	public Player(Position position) {
    	super('*', 0, 0, 8, Permeability.BLOCKING, position);
	}
	
	/**
	 * Gets the move player status.
	 * @return the variable isPlayerHasMoved.
	 */
	public boolean isPlayerhasMoved() {
		return isPlayerhasMoved;
	}

	/**
	 * Sets the player has moved.
	 * @param isPlayerhasMoved
	 * 			the player move status.
	 */
	public void setPlayerhasMoved(boolean isPlayerhasMoved) {
		this.isPlayerhasMoved = isPlayerhasMoved;
	}
	
	/**
	 * Gets the player life.
	 * @return the player life.
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * Sets the player's life.
	 * @param life
	 */
	public void setLife(int life) {
		this.life = life;
	}
	
	/**
	 * Add life to the player.
	 * @param nbrLife
	 * 			the number of lifes.
	 */
	public void addLife(int nbrLife) {
		this.life += nbrLife;
	}

	/**
	 * remove some life.
	 * @param nbrLife
	 * 			the number of life to remove.
	 */
	public void removeLife(int nbrLife) {
		this.life -= nbrLife;
	}
	
	/**
	 * Gets the score.
	 * @return the score.
	 */
	public int getScore() {
		return score;
	}
	
	/**
	 * Sets the score.
	 * @param nbrScore
	 * 			the number of points.
	 */
	public void setScore(int nbrScore) {
		this.score = nbrScore;
	}

	/**
	 * Increment the score.
	 */
	public void incrementScore() {
    	this.setScore(this.getScore() + 750);
	}
	
	/**
	 * Reset the score.
	 */
	public void resetScore() {
    	this.setScore(0);
	}
	
	/**
	 * Set player has succed level.
	 * @param hasSucceedLvl
	 * 				Do the player has succeed the level.
	 */
	public void setHasSucceedLvl(boolean hasSucceedLvl) {
		this.hasSucceedLvl = hasSucceedLvl;
	}
	
	/**
	 * Gets the value HasSucceedLvl.
	 * @return the player success.
	 */
	public boolean getHasSucceedLvl() {
		return  this.hasSucceedLvl;
	}
}
