/**
 * <h1>The Monster.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * @author Euxiniar
 *
 */
public abstract class Monster extends MobileElement implements IMonster {
	private int behaviour  = 2;
	private int counter = 0;
	private boolean rotationDirection = false;
	
	public int getBehaviour() {
		return behaviour;
	}

	public void setBehaviour(int behaviour) {
		this.behaviour = behaviour;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public boolean isRotationDirection() {
		return rotationDirection;
	}

	public void setRotationDirection(boolean rotationDirection) {
		this.rotationDirection = rotationDirection;
	}

	public Monster(char symbol, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, Position position) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
		this.setDirection(Direction.DOWN);
	}
	
	public Monster(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, Position position) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position);
		this.setDirection(Direction.DOWN);
	}
}
