package controller;


import model.ILorannModel;
import model.element.IElement;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.Direction;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

/**
 * <h1>The TryMove Class.</h1>
 *
 * @author Charles Agostini / Vicente Vaz / Anatole Couasnon / Louis Marjolet
 * @version 1.0
 */
public class TryMove {
	
	/**
	 * The lorannModel.
	 */
	private static ILorannModel lorannModel;
	
	/**
	 * Sets the lorannModel.
	 * @param lorannModel
	 * 			the lorannModel.
	 */
	public static void setLorannModel(ILorannModel lorannModel) {
		TryMove.lorannModel = lorannModel;
	}	
	
	/**
	 * Gets the theorical element position after a move.
	 * @param element
	 * 			the element.
	 * @param direction
	 * 			the direction.
	 * @return	the new theorical position.
	 */
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
	
	/**
	 * Gets the Direction thanks to the order.
	 * @param order
	 *			the order.
	 * @return the direction.
	 */
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
	
	/**
	 * Gets the monster's direction towards the player.
	 * @param monster
	 * 			the monster.
	 * @param player
	 * 			the player.
	 * @return the monster's direction.
	 */
	public static Direction getMonsterDirection(IMonster monster, Player player) {
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
	
	/**
	 * Gets a reverse direction
	 * @param direction
	 * 			the direction to reverse.
	 * @return the reverse direction.
	 */
	public static Direction reverseDirection(Direction direction) {
		Direction tabParameter[] = {Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.STATIC};
		Direction tabResult[] =    {Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.STATIC};
		Direction directionOut = null;
		for(int i = 0; i < 8; i++){
			if(direction == tabParameter[i]) {
				directionOut = tabResult[i];}}
        return directionOut;
	}
	
	/**
	 * Change the clockwise monster direction.
	 * @param direction
	 * 			the monster direction.
	 * @return the new direction.
	 */
	public static Direction changeClockwiseMonsterDirection(Direction direction) {
		Direction tabParameter[] = {Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.STATIC};
		Direction tabResult[] =    {Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.UP, Direction.STATIC};
		Direction directionOut = null;
		for(int i = 0; i < 8; i++){
			if(direction == tabParameter[i]) {
				directionOut = tabResult[i];}}
        return directionOut;
	}
	
	/**
	 * Change the counter clockwise monster direction.
	 * @param direction
	 * 			the direction.
	 * @return the new direction.
	 */
	public static Direction changeCounterclockwiseMonsterDirection(Direction direction) {
		Direction tabParameter[] = {Direction.UP, Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT};
		Direction tabResult[] =    {Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT, Direction.UP};
		Direction directionOut = null;
		for(int i = 0; i < 8; i++){
			if(direction == tabParameter[i]) {
				directionOut = tabResult[i];}}
        return directionOut;
	}
	
	/**
	 * Randomly change the monster direction.
	 * @param randNumb
	 * 			the random number
	 * @param direction
	 * 			the direction.
	 * @return the new direction.
	 */
	public static Direction changeRandomlyMonsterDirection(int randNumb, Direction direction) {
		Direction tabResult[] = {Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT, Direction.UP};
		for(int i = 0; i < 8; i++){
			if(i == randNumb) {
				direction = tabResult[i];}}
        return direction;
	}
	
	/**
	 * Try to move the player.
	 * @param player
	 * 			the player.
	 * @param order
	 * 			the order.
	 */
	public static void tryMovePlayer(Player player, Order order) {

        if (!player.isPlayerhasMoved() && order != Order.STOP)
        	player.setPlayerhasMoved(true);
        
        Position theoricalPosition = new Position();
        Direction direction;
        IElement element = lorannModel.getMap().getOnTheMap(lorannModel.getPlayer().getPosition());
        
        Collisions.testMonsterOnTheCaseThenKill(lorannModel.getPlayer(), lorannModel);
        
        direction = getOrderToDirection(order);
        player.setDirection(direction);
        theoricalPosition = getTheoricalPositionElement(player, direction);
        
        if (!Collisions.testNextCaseWall(lorannModel.getPlayer(), theoricalPosition, lorannModel)) { 
            player.setPosition(theoricalPosition);
            element = lorannModel.getMap().getOnTheMap(lorannModel.getPlayer().getPosition());
        }
        if (Collisions.testCaseObject(lorannModel.getPlayer(), lorannModel)) { 
            if (element.getSymbol() == 'P' && element.getIsAlive()) {
                player.incrementScore();
                element.setAlive(false);
            }
            else if (element.getSymbol() == 'K' && element.getIsAlive()) {
                element.setAlive(false);
                
                for(int y = 0; y < lorannModel.getMap().getHeight(); y++) {
        			for(int x = 0; x < lorannModel.getMap().getWidth(); x++) {
        				element = lorannModel.getMap().getOnTheMap(new Position(x, y));
        				if(element.getSymbol() == 'D') {
        					element.setPermeability(Permeability.ENDER);
        					element.setSelectedSpriteValue(1);
        				}
        			}
        		}
            }
        }
        else {
            Collisions.testMonsterOnTheCaseThenKill(lorannModel.getPlayer(), lorannModel);
            
            if (Collisions.testCaseDoorClose(lorannModel.getPlayer(), lorannModel)) {
            	lorannModel.getPlayer().setAlive(false);
            }
            if (Collisions.testCaseDoorOpen(lorannModel.getPlayer(), lorannModel)) {
            	lorannModel.getPlayer().setHasSucceedLvl(true);
            }
        }
    }

	/**
	 * Try to move the monster.
	 * @param monster
	 * 			the monster.
	 * @param player
	 * 			the player.
	 */
	public static void tryMoveMonster(IMonster monster, Player player) {
		Position theoricalPosition = new Position();
		theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
//---------Determination of	the direction and the theorical position of the monster relative to his position and that of the player
//---------------------------------------------------------------------------------------------------------------------------------
//-------Execution of the matching behaviour---------------------------------------------------------------------------------------
		switch(monster.getBehaviour()) {
		case SILLY:
			movementMonster1(monster, theoricalPosition, player);
			break;
		case NORMAL:
			movementMonster2(monster, theoricalPosition, player);
			break;
		case SMART:
			movementMonster3(monster, theoricalPosition, player);
			break;
		case GENIUS:
			movementMonster4(monster, theoricalPosition, player);
			break;
		default:
			break;
		}
		
//---------------------------------------------------------------------------------------------------------------------------------
		//peindre composants
	}
//______________________END OF tryMoveMonster_______________________________________________________________________________________

//______________________Movement of the monster with the behaviour 1________________________________________________________________
	/**
	 * The first type of monster movement.
	 * @param monster
	 * 			the monster.
	 * @param theoricalPosition
	 * 			the theorical position.
	 * @param player
	 * 			the player.
	 */
	public static void movementMonster1(IMonster monster, Position theoricalPosition, Player player) {
		if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseDoor(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseMonster(monster, theoricalPosition, lorannModel))
			if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
				Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseDoor(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseMonster(monster,  getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel)) {
				monster.setDirection(reverseDirection(monster.getDirection()));
			}
			else {
				monster.setDirection(getMonsterDirection(monster, player));
			}
	else {
		monster.setPosition(theoricalPosition);
	}
	}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 2_________________________________________________________________
	/**
	 * The second type of monster movement.
	 * @param monster
	 * 			the monster.
	 * @param theoricalPosition
	 * 			the theorical position.
	 * @param player
	 * 			the player.
	 */
	public static void movementMonster2(IMonster monster, Position theoricalPosition, Player player) {
		if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannModel) ||
				Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannModel) || 
				Collisions.testNextCaseDoor(monster, theoricalPosition, lorannModel)|| 
				Collisions.testNextCaseMonster(monster, theoricalPosition, lorannModel)) {
			if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) || 
					Collisions.testNextCaseObjectGrabable(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) || 
					Collisions.testNextCaseDoor(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
					Collisions.testNextCaseMonster(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel)) {
                monster.setDirection(changeClockwiseMonsterDirection(monster.getDirection()));
                theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
                movementMonster2(monster, theoricalPosition, player);
            }
			else {
				monster.setDirection(getMonsterDirection(monster, player));
				theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
				movementMonster2(monster, theoricalPosition, player);
			}
		}
		else {
			monster.setPosition(theoricalPosition); 
		}
	}
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 3_________________________________________________________________
	/**
	 * The third type of monster movement.
	 * @param monster
	 * 			the monster.
	 * @param theoricalPosition
	 * 			the theorical position.
	 * @param player
	 * 			the player.
	 */
	public static void movementMonster3(IMonster monster, Position theoricalPosition, Player player) {
		if(monster.getCounter() == 8) {
            monster.setCounter(0);
            monster.setRotationDirection(!(monster.isRotationDirection()));
        }
        else {
            monster.setCounter(monster.getCounter() + 1);
        }
        if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannModel) || 
        		Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannModel) || 
        		Collisions.testNextCaseDoor(monster, theoricalPosition, lorannModel) ||
        		Collisions.testNextCaseMonster(monster, theoricalPosition, lorannModel)) {
            if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) || 
            		Collisions.testNextCaseObjectGrabable(monster, 
            				getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) || 
            		Collisions.testNextCaseDoor(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
            		Collisions.testNextCaseMonster(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel))
                if(monster.isRotationDirection()) {
                    monster.setDirection(changeClockwiseMonsterDirection(monster.getDirection()));
                    theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
                    movementMonster3(monster, theoricalPosition, player);
                }
                else {
                    monster.setDirection(changeCounterclockwiseMonsterDirection(monster.getDirection()));
                    theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
                    movementMonster3(monster, theoricalPosition, player);
                }
            else {
                monster.setDirection(getMonsterDirection(monster, player));
                theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
                movementMonster3(monster, theoricalPosition, player);
            }
        }
        else {
            monster.setPosition(theoricalPosition); 
        }
    }
//___________________________________________________________________________________________________________________________________
//______________________Movement of the monster with the behaviour 4_________________________________________________________________
		/**
		 * The second type of monster movement.
		 * @param monster
		 * 			the monster.
		 * @param theoricalPosition
		 * 			the theorical position.
		 * @param player
		 * 			the player.
		 */
		public static void movementMonster4(IMonster monster, Position theoricalPosition, Player player) {
			//theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());

			if (Collisions.testNextCaseWall(monster, theoricalPosition, lorannModel) ||
					Collisions.testNextCaseObjectGrabable(monster, theoricalPosition, lorannModel) ||
					Collisions.testNextCaseDoor(monster, theoricalPosition, lorannModel) ||
					Collisions.testNextCaseMonster(monster, theoricalPosition, lorannModel)) {
				if (Collisions.testNextCaseWall(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
						Collisions.testNextCaseObjectGrabable(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
						Collisions.testNextCaseDoor(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel) ||
						Collisions.testNextCaseMonster(monster, getTheoricalPositionElement(monster, getMonsterDirection(monster, player)), lorannModel)) {
	                int randNumb = (int) (Math.random()*8);
					monster.setDirection(changeRandomlyMonsterDirection(randNumb, monster.getDirection()));
	                theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
	                movementMonster2(monster, theoricalPosition, player);
	            }
				else {
					monster.setDirection(getMonsterDirection(monster, player));
					theoricalPosition = getTheoricalPositionElement(monster, monster.getDirection());
					movementMonster2(monster, theoricalPosition, player);
				}
			}
			else {
				monster.setPosition(theoricalPosition); 
			}
		}
	//___________________________________________________________________________________________________________________________________
	
	
	
	/**
	 * Try to move the spell.
	 * @param spell
	 * 			the spell.
	 * @param order
	 * 			the order.
	 */
	public static void tryMoveSpell(Spell spell, Order order) {
		if(!spell.getIsAlive() && getOrderToDirection(order) != Direction.STATIC) {
			spell.setDirection(getOrderToDirection(order));
			launchSpell(spell, lorannModel.getPlayer());
			if(Collisions.testCasePlayer(lorannModel.getPlayer(), spell) || Collisions.testMonsterOnTheCaseThenKill(spell, lorannModel)) {
				spell.setAlive(false);
				spell.setDirection(Direction.STATIC);
			}
		}
		
		else if(spell.getIsAlive()) {
			if(Collisions.testNextCaseDoor(spell, getTheoricalPositionElement(spell, spell.getDirection()), lorannModel) ||
					Collisions.testNextCaseObjectGrabable(spell, getTheoricalPositionElement(spell, spell.getDirection()), lorannModel) ||
					Collisions.testNextCaseWall(spell, getTheoricalPositionElement(spell, spell.getDirection()), lorannModel)) {
				spell.setDirection(reverseDirection(spell.getDirection()));
			}
			
			if(spell.getDirection() == reverseDirection(lorannModel.getPlayer().getDirection())) {
				if(Collisions.testCasePlayer(lorannModel.getPlayer(), spell)) {
					spell.setAlive(false);
					spell.setDirection(Direction.STATIC);
				}
			}
			
			for(int i = 0; i < lorannModel.getMonsters().size(); i++ ) {
				if(spell.getDirection() == reverseDirection(lorannModel.getMonsters().get(i).getDirection())) {
					if(Collisions.testMonsterOnTheCaseThenKill(spell, lorannModel)) {
						spell.setAlive(false);
						spell.setDirection(Direction.STATIC);
					}
				}
			}
			
			spell.setPosition(getTheoricalPositionElement(spell, spell.getDirection()));
			
			if(Collisions.testCasePlayer(lorannModel.getPlayer(), spell) || Collisions.testMonsterOnTheCaseThenKill(spell, lorannModel)) {
				spell.setAlive(false);
				spell.setDirection(Direction.STATIC);
			}
		}
	}
        //peindre composants
	/**
	 * Launch the spell.
	 * @param spell
	 * 			the spell.
	 * @param player
	 * 			the player.
	 */
	public static void launchSpell(Spell spell, Player player) {
		if(!Collisions.testNextCaseWall(player, getTheoricalPositionElement(player, spell.getDirection()), lorannModel) &&
				!Collisions.testNextCaseObjectGrabable(player, getTheoricalPositionElement(player, spell.getDirection()), lorannModel) &&
				!Collisions.testNextCaseDoor(player, getTheoricalPositionElement(player, spell.getDirection()), lorannModel)) {
			spell.setPosition(getTheoricalPositionElement(player, spell.getDirection()));
            spell.setAlive(true);
		}  
    }
}
