package model.element.mobile;

import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The Monster.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */

public abstract class Monster extends MobileElement implements IMonster {
	/**
	 * The behaviour of the Monster.
	 */
	private Behaviour behaviour  = Behaviour.NORMAL;
	
	private int counter = 0;
	/**
	 * The variable to know if the monster has to change his direction.
	 */
	private boolean rotationDirection = false;
	
	/**
	 * Creates a monster.
	 * @param symbol
	 * 			the symbol.
	 * @param xSpritePos
	 * 			the x position on the SpriteSheet.
	 * @param ySpritePos
	 * 			the y position on the spriteSheet.
	 * @param nbSprites
	 * 			the number of sprites.
	 * @param permeability
	 * 			the permeability of the monster.
	 * @param position
	 * 			the position of the monster on the map.
	 * @param behaviour
	 * 			the behaviour of the monster.
	 */
	public Monster(char symbol, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, Position position, Behaviour behaviour) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
		this.setDirection(Direction.DOWN);
		this.setBehaviour(behaviour);
	}
	
	/**
	 * Creates a monster with only one sprite.
	 * @param symbol
	 * 			the symbol.
	 * @param xSpritePos
	 * 			the x position on the SpriteSheet.
	 * @param ySpritePos
	 * 			the y position on the spriteSheet.
	 * @param permeability
	 * 			the permeability of the monster.
	 * @param position
	 * 			the position of the monster on the map.
	 * @param behaviour
	 * 			the behaviour of the monster.
	 */
	public Monster(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, Position position, Behaviour behaviour) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position, behaviour);
		this.setDirection(Direction.DOWN);
	}
	
	/**
	 * Gets the behaviour.
	 * @return the behaviour.
	 */
	public Behaviour getBehaviour() {
		return this.behaviour;
	}

	/**
	 * Sets the behaviour.
	 * @param behaviour
	 * 		the behaviour.
	 */
	public void setBehaviour(Behaviour behaviour) {
		this.behaviour = behaviour;
	}
	
	/**
	 * Gets the counter.
	 * @return the counter.
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * Sets the counter.
	 * @param counter
	 * 			the counter.
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}

	/**
	 * Allow to know if the Monster need to change his rotation.
	 * @return the rotationDirection boolean.
	 */
	public boolean isRotationDirection() {
		return rotationDirection;
	}

	/** 
	 * Sets the boolean rotationDirection.
	 * @param rotationDirection
	 * 			the rotationDIrection.
	 */
	public void setRotationDirection(boolean rotationDirection) {
		this.rotationDirection = rotationDirection;
	}
}
