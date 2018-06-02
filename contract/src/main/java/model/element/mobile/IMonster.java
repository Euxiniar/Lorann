/**
 * <h1>The IMonster.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.IElement;

public interface IMonster extends IElement {
	void setDirection(Direction direction);
	Behaviour getBehaviour();
	void setBehaviour(Behaviour behaviour);
	int getCounter();
	void setCounter(int counter);
	boolean isRotationDirection();
	void setRotationDirection(boolean rotationDirection);
	Direction getDirection();
}
