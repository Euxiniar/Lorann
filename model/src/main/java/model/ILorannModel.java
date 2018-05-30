/**
 * <h1>The ILorannModel.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model;

import java.util.ArrayList;

import model.element.Map;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Euxiniar
 *
 */
public interface ILorannModel {
	Map getMap();
	void setMap(Map map);
	Player getPlayer();
	void setPlayer(Player player);
	Spell getSpell();
	void setSpell(Spell spell);
	ArrayList<IMonster> getMonsters();
	void addMonster(IMonster monster);
	public void setMobilesHavesMoved();
}


