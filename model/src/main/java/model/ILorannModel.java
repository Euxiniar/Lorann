<<<<<<< HEAD
/**
 * <h1>The ILorannModel.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model;

import java.util.ArrayList;
import java.util.Map;

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
}
=======
/**
 * <h1>The ILorannModel.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observer;

import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Euxiniar
 *
 */
public interface ILorannModel extends Observer {
	Map getMap();
	void setMap(Map map);
	Player getPlayer();
	void setPlayer(Player player);
	Spell getSpell();
	void setSpell(Spell spell);
	ArrayList<IMonster> getMonsters();
	void addMonster(IMonster monster);
}
>>>>>>> parent of af7de76... Revert "reupdate"
