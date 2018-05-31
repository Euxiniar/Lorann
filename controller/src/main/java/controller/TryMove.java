/**
 * 
 */
package controller;



import java.util.ArrayList;

import model.ILorannModel;
import model.element.IElement;
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
	        Position position = new Position(element.getPosition().getX(), element.getPosition().getX() );
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
				System.out.println();
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
				break;
			}
		return direction;
		}
		public Direction getMobDirection(IMonster monster, Player player) {
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
		public Direction reverseDirection(Direction direction) {
            switch(direction) {
            case UP:
                direction = Direction.DOWN;
            case DOWN:
                direction = Direction.UP;
            case LEFT:
                direction = Direction.RIGHT;
            case RIGHT:
                direction = Direction.LEFT;
            case UPLEFT:
                direction = Direction.DOWNRIGHT;
            case UPRIGHT:
                direction = Direction.DOWNLEFT;
            case DOWNLEFT:
                direction = Direction.UPRIGHT;
            case DOWNRIGHT:
                direction = Direction.UPLEFT;
            default:
                break;
            }
            return direction;
		}
		public Direction changeClockwiseMonsterDirection(Direction direction) {
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

			Position theoricalPosition = new Position();
			Direction direction;
			direction = getOrderToDirection(order);
			theoricalPosition = getTheoricalPositionElement(player, direction);
			if (Collisions.testNextCaseWall(lorannmodel.getPlayer(), theoricalPosition, lorannmodel)) { 
				// lorannmodel.getPlayer().setPosition(lorannmodel.getPlayer().getPosition().getY(),lorannmodel.getPlayer().getPosition().getX());
                // The player doesn't move
				System.out.println("l� on ne fait rien");
            }
            else {
                player.setPosition(theoricalPosition);
            }
            if (false) { //Collisions.testCaseObject(lorannmodel.getPlayer())
                lorannmodel.getMap().getMap()[lorannmodel.getPlayer().getPosition().getY()][lorannmodel.getPlayer().getPosition().getX()].setAlive(false);
                if (ControllerFacade.map[lorannmodel.getPlayer().getPosition().getY()][lorannmodel.getPlayer().getPosition().getX()].getSymbol() == 'P') {
//                    score.setScore(score.getScore() + 750);
                }
                }
            else {
                if (false) { //Collisions.testMonsterOnTheCaseThenKill(lorannmodel.getPlayer(), lorannmodel.getMonsters()) || Collisions.testCaseDoorClose(lorannmodel.getPlayer())
                //GameOver();
                }
                else {
                    if (false) { //Collisions.testCaseDoorOpen(lorannmodel.getPlayer())
                    //     Win() (ou retour au menu);
                    }
                    }
            }
		}

//__________________________Set the position of the monster____________________________________________________________________________________
		
		public void tryMoveMonster(IMonster monster, Player player) {
			Position theoricalPosition = new Position();
			Direction direction = null;
			Direction redirection = null;
			
	//---------Determination of	the direction and the theorical position of the monster relative to his position and that of the player
			direction = getMobDirection(monster, player);
			theoricalPosition = getTheoricalPositionElement(monster, direction);
	//---------------------------------------------------------------------------------------------------------------------------------
	//-------Execution of the matching behaviour---------------------------------------------------------------------------------------
//			switch(monster.getBehaviour()) {
//			case 1:
//				movementMonster1(monster, theoricalPosition, direction, redirection);
//			default:
//				break;
//			}
			
	//---------------------------------------------------------------------------------------------------------------------------------
			//peindre composants
		}
//______________________END OF tryMoveMonster_______________________________________________________________________________________

//______________________Movement of the monster with the behaviour 1________________________________________________________________
		public void movementMonster1(IMonster monster, Position theoricalPosition, Direction direction, Direction redirection) {
			if (!Collisions.testNextCaseWall(monster, theoricalPosition, lorannmodel)) {
				monster.setPosition(theoricalPosition);
			}
			else {
				 redirection = reverseDirection(direction);
				 theoricalPosition = getTheoricalPositionElement(monster, redirection);
				 monster.setPosition(theoricalPosition);
			}
		}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 2_________________________________________________________________
		public void movementMonster2(IMonster monster, Position theoricalPosition, Direction direction) {
			theoricalPosition = getTheoricalPositionElement(monster, direction);
			if (!Collisions.testNextCaseWall(monster, theoricalPosition, lorannmodel)) {
				monster.setPosition(theoricalPosition);
			}
			else {
				 direction = changeClockwiseMonsterDirection(direction);
				 movementMonster2(monster, theoricalPosition, direction);
			}
		}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 3_________________________________________________________________
		public void movementMonster3(IMonster monster, Position theoricalPosition, Direction direction) {
//			if(monster.getCounter() == 3) {
//				monster.setCounter(0);
//				monster.setRotationDirection(!monster.getRotationDirection());
//			}
//			else {
//				monster.setCounter(monster.getCounter() + 1);
//			}
//			theoricalPosition = getTheoricalPositionElement(monster, direction);
//			if (!Collisions.testNextCaseWall(monster, theoricalPosition)) {
//				monster.setPosition(theoricalPosition);
//			}
//			else {
//				if(monster.getRotationDirection()) { 
//					direction = changeClockwiseMonsterDirection(direction);
//				}
//				else
//					direction = changeCounterclockwiseMonsterDirection(direction);
//				}
//				movementMonster2(monster, theoricalPosition, direction);
			}
//___________________________________________________________________________________________________________________________________


		public void tryMoveSpell(Spell spell, Order order, ArrayList<IMonster> monsters) {
            Position theoricalPosition = new Position();
            Direction direction;
            direction = getOrderToDirection(order);
            theoricalPosition = getTheoricalPositionElement(spell, direction);

            if(spell.getIsAlive()==true){
                if(Collisions.testNextCaseObjectGrabable(spell, theoricalPosition) || Collisions.testNextCaseDoor(spell, theoricalPosition) || Collisions.testNextCaseWall(spell, theoricalPosition, lorannmodel)){
                    Direction newDirection = reverseDirection(direction);
                    theoricalPosition = getTheoricalPositionElement(spell, newDirection);
                    spell.setPosition(theoricalPosition);
                }
                else {
                    if(Collisions.testMonsterOnTheCaseThenKill(spell, monsters)){
                    	spell.setAlive(false);
                    }
                    else{
                        if(Collisions.testCasePlayer(lorannmodel.getPlayer(), spell)){ //here
                            spell.setAlive(false);
                        };
                    }
                    spell.setPosition(theoricalPosition);
                }
            }
                //peindre composants
        }
		public void setLorannModel(ILorannModel lorannmodel) {
			this.lorannmodel = lorannmodel;
		}
		public void launchSpell(Spell spell, Player player) {
            spell.setPosition(player.getPosition());
            //setDirection � l'oppos� de la direction pr�c�dente du joueur?
            spell.getIsAlive();
        }

}
