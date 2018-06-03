package model;

import java.util.ArrayList;

import model.element.Map;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * <h1>The ILorannModel Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public interface ILorannModel {
	/**
	 * Gets the map.
	 * @return the map.
	 */
	Map getMap();
	/**
	 * Sets the map.
	 * @param map
	 * 			the map.
	 */
	void setMap(Map map);
	/**
	 * Gets the player.
	 * @return the player.
	 */
	Player getPlayer();
	/**
	 * Sets the player.
	 * @param player
	 * 			the player.
	 */
	void setPlayer(Player player);
	/**
	 * Gets the spell.
	 * @return the spell.
	 */
	Spell getSpell();
	/**
	 * Sets the spell.
	 * @param spell
	 * 			the spell.
	 */
	void setSpell(Spell spell);
	/**
	 * Gets the monsters.
	 * @return the monsters.
	 * @see model.element.mobile.IMonster
	 */
	ArrayList<IMonster> getMonsters();
	/**
	 * Add a monster.
	 * @param monster
	 * 			the monster.
	 */
	void addMonster(IMonster monster);
	
	/**
	 * Call the view observer.
	 * @see view.ILorannView
	 */
	public void setMobilesHavesMoved();
}
