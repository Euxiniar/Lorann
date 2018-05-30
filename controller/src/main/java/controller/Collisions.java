/**
 * 
 */
package controller;

import model.ILorannModel;
import model.element.IElement;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Snargol
 *
 */
public class Collisions {

	//------------------Test position of a player or a spell with all the others Movable Entity
	public static boolean testCaseMob(IElement element) {
		return false;
		
//		for (IElement e2 : listeEntity) {
//			if (e1.getPosition().getX() == e2.getPosition().getX() && e1.getPosition().getY() == e2.getPosition().getY()) {
//				return true;
//			}
//		}
//		
//		return false;
	}
	//-------------------Test player position with spell position
	public static boolean testCaseSpell(Player player, Spell spell) {
		
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
	public static boolean testCaseDoor(IElement IElement) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()][IElement.getPosition().getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.ENDER
	public static boolean testCaseDoorOpen(IElement IElement) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()][IElement.getPosition().getX()].getPermeability() == Permeability.ENDER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.KILLER
	public static boolean testCaseDoorClose(IElement IElement) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()][IElement.getPosition().getX()].getPermeability() == Permeability.KILLER) {
			return true;
		}
		return false;
	}	
	//--------------------Test next case Object for IElement------------------------------------------- 
	public static boolean testNextCaseObjectGrabable(IElement IElement, Position nextPosition) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()+nextPosition.getY()][IElement.getPosition().getX() +nextPosition.getX()].getPermeability() == Permeability.GRABABLE) {
			return true;
		}
		return false;
	}
	//---------------------Test next case Spell for IElement------------------------------------------
	public static boolean testNextCaseSpell(IElement IElement, Position position,Spell spell) {
		
		if (IElement.getPosition().getX()+position.getX() == spell.getPosition().getX() && IElement.getPosition().getY() + position.getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//---------------------Test next case Wall for IElement-------------------------------------------
	public static boolean testNextCaseWall(IElement IElement, Position nextPosition) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()+nextPosition.getY()][IElement.getPosition().getX() +nextPosition.getX()].getPermeability() == Permeability.BLOCKING) {
			return true;
		}
		return false;
	}
	//----------------------test next case Door for IElement------------------------------------------
	public static boolean testNextCaseDoor(IElement IElement, Position nextPosition) {
		
		if (ControllerFacade.map[IElement.getPosition().getY()+nextPosition.getY()][IElement.getPosition().getX() +nextPosition.getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	
	public Collisions(ILorannModel lorannmodel) {
		
	}
	
}
