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
	private Behaviour behaviour  = Behaviour.NORMAL;
	private int counter = 0;
	private boolean rotationDirection = false;
	
	public Behaviour getBehaviour() {
		return this.behaviour;
	}

	public void setBehaviour(Behaviour behaviour) {
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
			Permeability permeability, Position position, Behaviour behaviour) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
		this.setDirection(Direction.DOWN);
		this.setBehaviour(behaviour);
	}
	
	public Monster(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, Position position, Behaviour behaviour) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position, behaviour);
		this.setDirection(Direction.DOWN);
	}
}
