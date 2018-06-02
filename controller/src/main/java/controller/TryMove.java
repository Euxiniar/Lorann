/**
 * 
 */
package controller;



import java.util.ArrayList;

import model.ILorannModel;
import model.element.IElement;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.Direction;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * @author Snargol/Vicente
 *
 */
public class TryMove {
		
	static ILorannModel lorannmodel;
		public TryMove(ILorannModel lorannModel) {
			TryMove.lorannmodel=lorannModel;
		}
		public static Position getTheoricalPositionElement(IElement element, Direction direction) {
	        Position position = new Position(element.getPosition().getX(), element.getPosition().getY() );
	        switch(direction) {
	        case UP:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() - 1);
	            break;
	        case DOWN:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() + 1);
	            break;
	        case LEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY());
	            break;
	        case RIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY());
	            break;
	        case UPLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() - 1);
	            break;
	        case UPRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() - 1);
	            break;
	        case DOWNLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() + 1);
	            break;
	        case DOWNRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() + 1);
	            break;
	        default:
	            break;
	        }
	        return position;
	    }
		public static Direction getOrderToDirection(Order order) {
			Direction direction = null;
			switch(order) {
			case UP:
				direction = Direction.UP;
				break;
			case DOWN:
				direction = Direction.DOWN;
				break;
			case LEFT:
				direction = Direction.LEFT;
				break;
			case RIGHT:
				direction = Direction.RIGHT;
				break;
			case UPLEFT:
        		direction = Direction.UPLEFT;
        		break;
			case UPRIGHT:
        		direction = Direction.UPRIGHT;
        		break;
			case DOWNLEFT:
				direction = Direction.DOWNLEFT;
				break;
			case DOWNRIGHT:
				direction = Direction.DOWNRIGHT;
				break;
			default:
				direction = Direction.STATIC;
				break;
			}
		return direction;
		}
		public static Direction getMobDirection(IMonster monster, Player player) {
			Direction direction = null;
			if (monster.getPosition().getX() > player.getPosition().getX()) {
				if (monster.getPosition().getY() > player.getPosition().getY()) {
					direction = Direction.UPLEFT;
				}
				else if (monster.getPosition().getY() < player.getPosition().getY()) {
					direction = Direction.DOWNLEFT;
				}
				else if (monster.getPosition().getY() == player.getPosition().getY()) {
					direction = Direction.LEFT;
				}
			}
			if (monster.getPosition().getX() < player.getPosition().getX()) {
				if (monster.getPosition().getY() > player.getPosition().getY()) {
					direction = Direction.UPRIGHT;
				}
				else if (monster.getPosition().getY() < player.getPosition().getY()) {
					direction = Direction.DOWNRIGHT;
				}
				else if (monster.getPosition().getY() == player.getPosition().getY()) {
					direction = Direction.RIGHT;
				}
			}
			if (monster.getPosition().getX() == player.getPosition().getX()) {
				if (monster.getPosition().getY() > player.getPosition().getY()) {
					direction = Direction.UP;
				}
				else if (monster.getPosition().getY() < player.getPosition().getY()) {
					direction = Direction.DOWN;
				}
//------------------This case isn't supposed to exist--------------------------------------
				else if (monster.getPosition().getY() == player.getPosition().getY()) {
					direction = Direction.UP;
				}
//-----------------------------------------------------------------------------------------
			}
			return direction;
		}
		public static Direction reverseDirection(Direction direction) {
            switch(direction) {
            case UP:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.UP;
                break;
            case LEFT:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.LEFT;
                break;
            case UPLEFT:
                direction = Direction.DOWNRIGHT;
                break;
            case UPRIGHT:
                direction = Direction.DOWNLEFT;
                break;
            case DOWNLEFT:
                direction = Direction.UPRIGHT;
                break;
            case DOWNRIGHT:
                direction = Direction.UPLEFT;
                break;
            default:
                break;
            }
            return direction;
		}
		public static Direction changeClockwiseMonsterDirection(Direction direction) {
			switch(direction) {
            case UP:
                direction = Direction.UPRIGHT;
                break;
            case UPRIGHT:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.DOWNRIGHT;
                break;
            case DOWNRIGHT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.DOWNLEFT;
                break;
            case DOWNLEFT:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.UPLEFT;
                break;
            case UPLEFT:
                direction = Direction.UP;
                break;
            default:
                break;
            }
            return direction;
		}
		public Direction changeCounterclockwiseMonsterDirection(Direction direction) {
			switch(direction) {
            case UP:
                direction = Direction.UPLEFT;
                break;
            case UPLEFT:
                direction = Direction.LEFT;
                break;
            case LEFT:
                direction = Direction.DOWNLEFT;
                break;
            case DOWNLEFT:
                direction = Direction.DOWN;
                break;
            case DOWN:
                direction = Direction.DOWNRIGHT;
                break;
            case DOWNRIGHT:
                direction = Direction.RIGHT;
                break;
            case RIGHT:
                direction = Direction.UPRIGHT;
                break;
            case UPRIGHT:
                direction = Direction.UP;
                break;
            default:
                break;
            }
            return direction;
		}
		public static void tryMovePlayer(Player player, Order order) {

            if (!player.isPlayerhasMoved() && order != Order.STOP)
            	player.setPlayerhasMoved(true);
            
            Position theoricalPosition = new Position();
            Direction direction;
            IElement element = lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition().getX(), lorannmodel.getPlayer().getPosition().getY());
            
            Collisions.testMonsterOnTheCaseThenKill(lorannmodel.getPlayer(), lorannmodel);
            
            direction = getOrderToDirection(order);
            theoricalPosition = getTheoricalPositionElement(player, direction);
            
            if (!Collisions.testNextCaseWall(lorannmodel.getPlayer(), theoricalPosition, lorannmodel)) { 
                player.setPosition(theoricalPosition);
                element = lorannmodel.getMap().getOnTheMap(lorannmodel.getPlayer().getPosition().getX(), lorannmodel.getPlayer().getPosition().getY());
            }
            if (Collisions.testCaseObject(lorannmodel.getPlayer(), lorannmodel)) { 
                if (element.getSymbol() == 'P' && element.getIsAlive()) {
                    player.incrementScore();
                    element.setAlive(false);
                    System.out.println(player.getScore());
                }
                else if (element.getSymbol() == 'K' && element.getIsAlive()) {
                    element.setAlive(false);
                    
                    for(int y = 0; y < lorannmodel.getMap().getHeight(); y++) {
            			for(int x = 0; x < lorannmodel.getMap().getWidth(); x++) {
            				element = lorannmodel.getMap().getOnTheMap(new Position(x, y));
            				if(element.getSymbol() == 'D') {
            					element.setPermeability(Permeability.ENDER);
            				}
            			}
            		}
                }
            }
            else {
                Collisions.testMonsterOnTheCaseThenKill(lorannmodel.getPlayer(), lorannmodel);
              //---------------------------------------mort potentielle
                
                 if (Collisions.testCaseDoorClose(lorannmodel.getPlayer(), lorannmodel)) {
                     System.out.println("porte fermée");
                     //---------------------------------------mort
                 }
                    if (Collisions.testCaseDoorOpen(lorannmodel.getPlayer(), lorannmodel)) {
                         System.out.println("porte ouverte");
                    //     Win() (ou retour au menu);
                    }
            }
        }

//__________________________Set the position of the monster____________________________________________________________________________________
		
		public static void tryMoveMonster(IMonster monster, Player player) {
			Position theoricalPosition = new Position();
			theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
	//---------Determination of	the direction and the theorical position of the monster relative to his position and that of the player
			
					
			//theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
					//monster.setPosition(theoricalPosition);
	//---------------------------------------------------------------------------------------------------------------------------------
	//-------Execution of the matching behaviour---------------------------------------------------------------------------------------
			switch(monster.getBehaviour()) {
			case 1:
				movementMonster1(monster, theoricalPosition, player);
				break;
			case 2:
				movementMonster2(monster, theoricalPosition, player);
				break;
//			case 3:
//				movementMonster3(monster, theoricalPosition, player);
//				break;
			default:
				break;
			}
			
	//---------------------------------------------------------------------------------------------------------------------------------
			//peindre composants
		}
//______________________END OF tryMoveMonster_______________________________________________________________________________________

//______________________Movement of the monster with the behaviour 1________________________________________________________________
		public static void movementMonster1(IMonster monster, Position theoricalPosition, Player player) {
			if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(monster, theoricalPosition, lorannmodel))
				if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMobDirection(monster, player)), lorannmodel) || Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(monster, theoricalPosition, lorannmodel))
					monster.setDirection(reverseDirection(monster.getDirection()));
				else {
					monster.setDirection(getMobDirection(monster, player));
					monster.setPosition(getTheoricalPositionElement(monster, monster.getDirection()));
				}
		else {
			monster.setPosition(theoricalPosition);
		}
		}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 2_________________________________________________________________
		public static void movementMonster2(IMonster monster, Position theoricalPosition, Player player) {
			//theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());

			if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(monster, theoricalPosition, lorannmodel)) {
				if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMobDirection(monster, player)), lorannmodel) || Collisions.testNextCaseObjectGrabable(monster, getTheoricalPositionElement(monster, getMobDirection(monster, player)), lorannmodel) || Collisions.testNextCaseDoor(monster, getTheoricalPositionElement(monster, getMobDirection(monster, player)), lorannmodel)) {
					monster.setDirection(changeClockwiseMonsterDirection(monster.getDirection()));
					theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
					movementMonster2(monster, theoricalPosition, player);
				}
				else {
					monster.setDirection(getMobDirection(monster, player));
					monster.setPosition(getTheoricalPositionElement(monster, monster.getDirection()));
				}
			}
			else {
				monster.setPosition(theoricalPosition); 
			}
		}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 3_________________________________________________________________
//		public void movementMonster3(IMonster monster, Position theoricalPosition, Player player) {
//			if(monster.getCounter() == 3) {
//				monster.setCounter(0);
//				monster.setRotationDirection(!monster.isRotationDirection());
//			}
//			else {
//				monster.setCounter(monster.getCounter() + 1);
//			}
//			if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(monster, theoricalPosition, lorannmodel)) {
//				if(monster.isRotationDirection()) { 
//					monster.setDirection(changeClockwiseMonsterDirection(monster.getDirection()));
//				}
//				else
//					monster.setDirection(changeCounterclockwiseMonsterDirection(monster.getDirection()));
//					movementMonster3(monster, theoricalPosition, player);
//			}
//			else {
//				monster.setPosition(theoricalPosition);
//			}
//}
//___________________________________________________________________________________________________________________________________


		public static void tryMoveSpell(Spell spell, Order order) {
            Position theoricalPosition = new Position();
            if (spell.getDirection() == Direction.STATIC) {
                spell.setDirection(getOrderToDirection(order));
                if (spell.getDirection() != Direction.STATIC && !spell.getIsAlive()) {
                    launchSpell(spell, lorannmodel.getPlayer());
                    theoricalPosition = getTheoricalPositionElement(spell, spell.getDirection());
                    if(Collisions.testNextCaseWall(spell, theoricalPosition, lorannmodel) || Collisions.testNextCaseObjectGrabable(spell, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(spell, theoricalPosition, lorannmodel)) {
                        spell.setAlive(false);
                        spell.setDirection(Direction.STATIC);
                    }
                }
            }
            
            if(Collisions.testMonsterOnTheCaseThenKill(spell, lorannmodel)){
                spell.setAlive(false);
                spell.setDirection(Direction.STATIC);
            }
            
            theoricalPosition = getTheoricalPositionElement(spell, spell.getDirection());
           
            if(spell.getIsAlive()==true){
                if(Collisions.testNextCaseObjectGrabable(spell, theoricalPosition, lorannmodel) || Collisions.testNextCaseDoor(spell, theoricalPosition, lorannmodel) || Collisions.testNextCaseWall(spell, theoricalPosition, lorannmodel)){
                    if (lorannmodel.getMap().getOnTheMap(theoricalPosition).getIsAlive()) {
                        spell.setDirection(reverseDirection(spell.getDirection()));
                        theoricalPosition = getTheoricalPositionElement(spell, spell.getDirection());
                    }
                }
                spell.setPosition(theoricalPosition);
                if(Collisions.testMonsterOnTheCaseThenKill(spell, lorannmodel)){
                    spell.setAlive(false);
                    spell.setDirection(Direction.STATIC);
                }
                else if(Collisions.testCasePlayer(lorannmodel.getPlayer(), spell)){
                        spell.setAlive(false);
                        spell.setDirection(Direction.STATIC);
                    }
        }
            //peindre composants
    }
		
		public void setLorannModel(ILorannModel lorannmodel) {
			this.lorannmodel = lorannmodel;
		}
		public static void launchSpell(Spell spell, Player player) {
            spell.setPosition(player.getPosition());
            System.out.println(spell.getPosition().getX() + " " + spell.getPosition().getY());
            spell.setAlive(true);
        }

}
