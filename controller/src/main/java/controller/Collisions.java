/**
 * 
 */
package controller;

/**
 * @author Snargol
 *
 */
public class Collisions {

	//------------------Test position of a player or a spell with all the others Movable Entity
	public static boolean TestCaseMob(MobileElement e1, ArrayList<MobileElement> listeEntity) {
		
		for (MobileElement e2 : listeEntity) {
			if (e1.getPosition().getX() == e2.getPosition().getX() && e1.getPosition().getY() == e2.getPosition().getY()) {
				return true;
			}
		}
		
		return false;
	}
	//-------------------Test player position with spell position
	public static boolean TestCaseSpell(Player p, Spell s) {
		
		if (p.getPosition().getX() == s.getPosition().getX() && p.getPosition().getY() == s.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//-------------------Test player with element permeability.GRABABLE of the case
	public static boolean TestCaseObject(Player p, MotionLessElement[] map) {
		
		if (map[p.getPosition().getY()][p.getPosition().getX()].getPermeability() == GRABABLE){
			return true;
		}
		
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.KILLER
	public static boolean TestCaseDoorClose(MobileElement mobileElement, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getPermeability() == permeability.KILLER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door with permeability.ENDER
	public static boolean TestCaseDoorOpen(MobileElement mobileElement, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getPermeability() == permeability.ENDER) {
			return true;
		}
		return false;
	}
	//-------------------Test player position with motionLessElement Door 
	public static boolean TestCaseDoor(MobileElement mobileElement, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()][mobileElement.getPosition().getX()].getSymbol == "D") {
			return true;
		}
		return false;
	}
	
	
	//--------------------Test next case Object for MobileElement------------------------------------------- 
	public static boolean TestNextCaseObject(MobileElement mobileElement, Position nextPosition, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getPermeability() == permeability.GRABABLE) {
			return true;
		}
		return false;
	}
	//---------------------Test next case Spell for MobileElement------------------------------------------
	public static boolean TestNextCaseSpell(MobileElement mobileElement, Position position,Spell spell) {
		
		if (mobileElement.getPosition().getX()+position.getX() == spell.getPosition().getX() && mobileElement.getPosition().getY() + position.getY == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	//---------------------Test next case Wall for MobileElement-------------------------------------------
	public static boolean TestNextCaseWall(MobileElement mobileElement, Position nextPosition, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getPermeability() == permeability.BLOCKING) {
			return true;
		}
		return false;
	}
	//----------------------test next case Door for MobileElement------------------------------------------
	public static boolean TestNextCaseDoor(MobileElement mobileElement, Position nextPosition, MotionLessElement[] map) {
		
		if (map[mobileElement.getPosition().getY()+nextPosition.getY()][mobileElement.getPosition().getX() +nextPosition.getX()].getSymbol() == "D") {
			return true;
		}
		return false;
	}
	
}
