/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.ILorannModel;
import model.element.IElement;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Snargol / Vicente
 *
 */
public class Collisions {
	

	//------------------Test position of a player or a spell with all the others Movable Entity
	public static boolean testMonsterOnTheCaseThenKill(IElement element1, ArrayList<IMonster> monsters) {
		for(int i=0; i <= monsters.size(); i++) {
			//if it is a player
			if (element1.getPermeability() == Permeability.BLOCKING && element1.getPosition().getX() == ((IMonster)monsters.get(i)).getPosition().getX() && element1.getPosition().getY() == ((IMonster)monsters.get(i)).getPosition().getY()) {
				((Player) element1).getLife();
				((Player) element1).removeLife(1);
				element1.setAlive(false);
				return true;
			}
			//if it is a spell
			else if(element1.getPermeability() == Permeability.KILLER && element1.getPosition().getX() == ((IMonster)monsters.get(i)).getPosition().getX() && element1.getPosition().getY() == ((IMonster)monsters.get(i)).getPosition().getY()) {
				((IMonster)monsters.get(i)).setAlive(false);
				return true;
			}
		}
		return false;
	}
	//-------------------Test player position with spell position
	public static boolean testCasePlayer(Player player, Spell spell) {
		
		if (player.getPosition().getX() == spell.getPosition().getX() && player.getPosition().getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//-------------------Test player with element permeability.GRABABLE of the case
	public static boolean testCaseObject(Player player) {
		
		if (ControllerFacade.map[player.getPosition().getY()][player.getPosition().getX()].getPermeability() == Permeability.GRABABLE){
			return true;
		}
		
		return false;
	}
	//-------------------Test player position with motionLessElement Door 
	public static boolean testCaseDoor(IElement element) {
		
		if (ControllerFacade.map[element.getPosition().getY()][element.getPosition().getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.ENDER
	public static boolean testCaseDoorOpen(IElement element) {
		
		if (ControllerFacade.map[element.getPosition().getY()][element.getPosition().getX()].getPermeability() == Permeability.ENDER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.KILLER
	public static boolean testCaseDoorClose(IElement element) {
		
		if (ControllerFacade.map[element.getPosition().getY()][element.getPosition().getX()].getPermeability() == Permeability.KILLER) {
			return true;
		}
		return false;
	}	
	//--------------------Test next case Object for IElement------------------------------------------- 
	public static boolean testNextCaseObjectGrabable(IElement element, Position nextPosition) {
		
		if (ControllerFacade.map[element.getPosition().getY()+nextPosition.getY()][element.getPosition().getX() +nextPosition.getX()].getPermeability() == Permeability.GRABABLE) {
			return true;
		}
		return false;
	}
	//---------------------Test next case Spell for IElement------------------------------------------
	public static boolean testNextCaseSpell(IElement element, Position position,Spell spell) {
		
		if (element.getPosition().getX()+position.getX() == spell.getPosition().getX() && element.getPosition().getY() + position.getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//---------------------Test next case Wall for IElement-------------------------------------------
	public static boolean testNextCaseWall(IElement element, Position nextPosition, ILorannModel lorannModel) {
		if (lorannModel.getMap().getOnTheMap(nextPosition.getY(),nextPosition.getY()).getPermeability() == Permeability.BLOCKING) {
			return true;
		}
		return false;
	}
	//----------------------test next case Door for IElement------------------------------------------
	public static boolean testNextCaseDoor(IElement element, Position nextPosition) {
		
		if (ControllerFacade.map[element.getPosition().getY()+nextPosition.getY()][element.getPosition().getX() +nextPosition.getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	
	public Collisions(ILorannModel lorannmodel) {
		
	}
	
}
