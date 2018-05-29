/**
 * 
 */
package controller;

import java.util.ArrayList;

import model.element.Permeability;
import model.element.mobile.MobileElement;
import model.element.mobile.Player;
import model.element.mobile.Position;
import model.element.mobile.Spell;
import model.element.motionless.MotionlessElement;

/**
 * @author Snargol
 *
 */
public class Collisions {

	//------------------Test position of a player or a spell with all the others Movable Entity
	public static boolean testCaseMob(MobileElement e1, ArrayList<MobileElement> listeEntity) {
		
		for (MobileElement e2 : listeEntity) {
			if (e1.getPosition().getX() == e2.getPosition().getX() && e1.getPosition().getY() == e2.getPosition().getY()) {
				return true;
			}
		}
		
		return false;
	}
	//-------------------Test player position with spell position
	public static boolean testCaseSpell(Player p, Spell s) {
		
		if (p.getPosition().getX() == s.getPosition().getX() && p.getPosition().getY() == s.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//-------------------Test player with element permeability.GRABABLE of the case
	public static boolean testCaseObject(Player p, MotionlessElement[][] map) {
		
		if (map[p.getPosition().getY()][p.getPosition().getX()].getPermeability() == Permeability.GRABABLE){
			return true;
		}
		
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.KILLER
	public static boolean testCaseDoorClose(MobileElement mobileElement, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getPermeability() == Permeability.KILLER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.ENDER
	public static boolean testCaseDoorOpen(MobileElement mobileElement, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getPermeability() == Permeability.ENDER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door 
	public static boolean testCaseDoor(MobileElement mobileElement, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	
	
	//--------------------Test next case Object for MobileElement------------------------------------------- 
	public static boolean testNextCaseObject(MobileElement mobileElement, Position nextPosition, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getPermeability() == Permeability.GRABABLE) {
			return true;
		}
		return false;
	}
	//---------------------Test next case Spell for MobileElement------------------------------------------
	public static boolean testNextCaseSpell(MobileElement mobileElement, Position position,Spell spell) {
		
		if (mobileElement.getPosition().getX()+position.getX() == spell.getPosition().getX() && mobileElement.getPosition().getY() + position.getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//---------------------Test next case Wall for MobileElement-------------------------------------------
	public static boolean testNextCaseWall(MobileElement mobileElement, Position nextPosition, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getPermeability() == Permeability.BLOCKING) {
			return true;
		}
		return false;
	}
	//----------------------test next case Door for MobileElement------------------------------------------
	public static boolean testNextCaseDoor(MobileElement mobileElement, Position nextPosition, MotionlessElement[][] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	
}
