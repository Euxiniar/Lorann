package controller;

import model.ILorannModel;
import model.element.IElement;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * <h1>The Collisions Class.</h1>
 *
 * @author Charles Agostini/ Couasnon Anatole / Vicente Vaz / Louis Marjolet
 * @version 1.0
 */
public class Collisions {
	

	/**
	 * Test position of a player or a spell with all the others Movable Entity.
	 * @param element
	 * 			the element to test.
	 * @param lorannModel
	 * 			the lorannModel.
	 * @return true if there's monster on it, false if not.
	 */
	public static boolean testMonsterOnTheCaseThenKill(IElement element, ILorannModel lorannModel) {
        for(int i=0; i <= lorannModel.getMonsters().size()-1; i++) {
        	if (lorannModel.getMonsters().get(i).getIsAlive()) {
            //if it is a player
            if (element.getPermeability() == Permeability.BLOCKING && 
            		element.getPosition().getX() == lorannModel.getMonsters().get(i).getPosition().getX() && 
            		element.getPosition().getY() == lorannModel.getMonsters().get(i).getPosition().getY()) {
                    if(element.getPermeability() == Permeability.BLOCKING) {
                    	element.setAlive(false);}
                    return true;
                }
                
            //if it is a spell
            else if(element.getPermeability() == Permeability.KILLER && element.getSymbol() == 'S' &&
            		element.getPosition().getX() == lorannModel.getMonsters().get(i).getPosition().getX() && 
            		element.getPosition().getY() == lorannModel.getMonsters().get(i).getPosition().getY()) {
                if (lorannModel.getMonsters().get(i).getIsAlive() && element.getIsAlive()) {
                    lorannModel.getMonsters().get(i).setAlive(false);
                    return true;
                }
            }
        }
        }
        return false;
    }
	
	/**
	 * Test player position with spell position.
	 * @param player
	 * 			the player.
	 * @param spell
	 * 			the spell.
	 * @return true if the spell is at the player position, false if not.
	 */
	public static boolean testCasePlayer(Player player, Spell spell) {
		
		if (player.getPosition().getX() == spell.getPosition().getX() && player.getPosition().getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Test player with element permeability.GRABABLE of the case.
	 * @param player
	 * 			the player.
	 * @param lorannmodel
	 * 			the lorannModel.
	 * @return true if there's an element with permeability.GRABABLE at the player position, false if not.
	 */
	public static boolean testCaseObject(Player player, ILorannModel lorannmodel) {
		
		if (lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition()).getPermeability() == Permeability.GRABABLE){
			return true;
		}
		
		return false;
	}
	
	/**
	 * Test player position with motionLessElement Door.
	 * @param element
	 * 			the element to test
	 * @param lorannmodel
	 * 			the lorannModel
	 * @return true if there's a door at the element position, false if not.
	 */
	public static boolean testCaseDoor(IElement element, ILorannModel lorannmodel) {
		
		if (lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition()).getSymbol() == 'D') {
			return true;
		}
		return false;
	}
	
	/**
	 * Test player position with motionLessElement Door with permeability.ENDER.
	 * @param element
	 * 			the element to test.
	 * @param lorannmodel
	 * 			the lorannModel.
	 * @return true if there's an open door at the player position, false if not.
	 */
	public static boolean testCaseDoorOpen(IElement element, ILorannModel lorannmodel) {
		
		if (lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition()).getPermeability() == Permeability.ENDER) {
			return true;
		}
		return false;
	}
	
	/**
	 * Test player position with motionLessElement Door with permeability.KILLER.
	 * @param element
	 * 			the element to test.
	 * @param lorannmodel
	 * 			the lorannModel.
	 * @return true if there's a close door at the element position, false if not.
	 */
	public static boolean testCaseDoorClose(IElement element, ILorannModel lorannmodel) {
	        
	        if (lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition()).getPermeability() == Permeability.KILLER) {
	            return true;
	        }
	        return false;
	    }
	
	/**
	 * Test next case Object for IElement.
	 * @param element
	 * 		the element to test.
	 * @param nextPosition
	 * 		the element next position.
	 * @param lorannModel
	 * 		the lorannModel.
	 * @return true if there's a grabable object at the next case, false if not.
	 */
	public static boolean testNextCaseObjectGrabable(IElement element, Position nextPosition, ILorannModel lorannModel) {
		if (lorannModel.getMap().getOnTheMap(nextPosition).getIsAlive()) {
			if (lorannModel.getMap().getOnTheMap(nextPosition).getPermeability() == Permeability.GRABABLE) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean testNextCaseMonster(IElement element, Position nextPosition, ILorannModel lorannModel) {
		if (lorannModel.getMap().getOnTheMap(nextPosition).getIsAlive()) {
			if (lorannModel.getMap().getOnTheMap(nextPosition).getPermeability() == Permeability.KILLER && (lorannModel.getMap().getOnTheMap(nextPosition).getSymbol() == '1' || lorannModel.getMap().getOnTheMap(nextPosition).getSymbol() == '2' || lorannModel.getMap().getOnTheMap(nextPosition).getSymbol() == '3' || lorannModel.getMap().getOnTheMap(nextPosition).getSymbol() == '4')) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Test next case Spell for IElement.
	 * @param element
	 * 			the element to test.
	 * @param position
	 * 			the element position.
	 * @param spell
	 * 			the spell.
	 * @return true if there's a spell at the next position, false if not. 
	 */
	public static boolean testNextCaseSpell(IElement element, Position position,Spell spell) {
		
		if (element.getPosition().getX()+position.getX() == spell.getPosition().getX() && element.getPosition().getY() + position.getY() == spell.getPosition().getY()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Test next case Wall for IElement.
	 * @param element
	 * 			the element to test.
	 * @param nextPosition
	 * 			the element's next position.
	 * @param lorannModel
	 * 			the lorannModel.
	 * @return true if there's a wall at the next position, false if not.
	 */
	public static boolean testNextCaseWall(IElement element, Position nextPosition, ILorannModel lorannModel) {
        if (lorannModel.getMap().getOnTheMap(nextPosition).getPermeability() == Permeability.BLOCKING) {
            return true;
        }
        return false;
    }
	
	/**
	 * Test next case Door for IElement.
	 * @param element
	 * 			the element to test.
	 * @param nextPosition
	 * 			the element next position.
	 * @param lorannModel
	 * 			the lorannModel.
	 * @return  true if there's a door at the next position, false if not.
	 */
	public static boolean testNextCaseDoor(IElement element, Position nextPosition, ILorannModel lorannModel) {
	        
	        if (lorannModel.getMap().getOnTheMap(nextPosition).getSymbol() == 'D') {
	            return true;
	        }
	        return false;
	    }	
}
