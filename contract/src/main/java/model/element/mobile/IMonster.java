package model.element.mobile;

import model.element.IElement;

/**
 * <h1>The IMonster Interface.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public interface IMonster extends IElement {
	/**
	 * Sets the IMonster direction.
	 * @param direction
	 * 				the direction.
	 */
	void setDirection(Direction direction);
	/**
	 * Gets the IMonster Behaviour.
	 * @return the behaviour.
	 */
	Behaviour getBehaviour();
	/**
	 * Sets the IMonster behaviour.
	 * @param behaviour
	 * 				the behaviour.
	 */
	void setBehaviour(Behaviour behaviour);
	/**
	 * Gets the counter.
	 * @return the counter.
	 */
	int getCounter();
	void setCounter(int counter);
	boolean isRotationDirection();
	void setRotationDirection(boolean rotationDirection);
	Direction getDirection();
}
