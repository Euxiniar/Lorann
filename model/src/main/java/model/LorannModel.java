/**
 * <h1>The LorannModel.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model;

import java.util.ArrayList;
import java.util.Observable;

import model.element.Map;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Euxiniar
 *
 */
@SuppressWarnings("deprecation")
public class LorannModel extends Observable implements ILorannModel{
	
	Map map;
	Player player;
	Spell spell;
	ArrayList<IMonster> monsters;
	
	LorannModel() {
		
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#getMap()
	 */
	@Override
	public Map getMap() {
		return map;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#setMap(model.element.Map)
	 */
	@Override
	public void setMap(Map map) {
		this.map = map;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#getPlayer()
	 */
	@Override
	public Player getPlayer() {
		return player;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#setPlayer(model.element.mobile.Player)
	 */
	@Override
	public void setPlayer(Player player) {
		this.player = player;
		
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#getSpell()
	 */
	@Override
	public Spell getSpell() {
		return spell;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#setSpell(model.element.mobile.Spell)
	 */
	@Override
	public void setSpell(Spell spell) {
		this.spell = spell;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#getMonsters()
	 */
	@Override
	public ArrayList<IMonster> getMonsters() {
		return monsters;
	}

	/* (non-Javadoc)
	 * @see model.ILorannModel#addMonster(model.element.mobile.IMonster)
	 */
	@Override
	public void addMonster(IMonster monster) {
		monsters.add(monster);
	}
	
	@Override
	public void setMobilesHavesMoved() {
		this.setChanged();
		this.notifyObservers();
	}
}
