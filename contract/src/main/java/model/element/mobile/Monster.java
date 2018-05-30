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
	public Monster(char symbol, int xSpritePos, int ySpritePos, int nbSprites,
			Permeability permeability, Position position) {
		super(symbol, xSpritePos, ySpritePos, nbSprites, permeability, position);
	}
	
	public Monster(char symbol, int xSpritePos, int ySpritePos,
			Permeability permeability, Position position) {
		this(symbol, xSpritePos, ySpritePos, 1, permeability, position);
	}
}
