/**
 * <h1>The IMonster.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.IElement;

/**
 * @author Euxiniar
 *
 */
public interface IMonster extends IElement {
	void setDirection(Direction direction);
	Direction getDirection();
}
