/**
 * 
 */
package controller;


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
		
		public Position getTheoricalPositionElement(IElement element, Direction direction) {
	        Position position = new Position();
	        switch(direction) {
	        case UP:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() - 1);
	        case DOWN:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() + 1);
	        case LEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY());
	        case RIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY());
	        case UPLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() - 1);
	        case UPRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() - 1);
	        case DOWNLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() + 1);
	        case DOWNRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() + 1);
	        default:
	            break;
	        }
	        return position;
	    }
		public Direction getOrderToDirection(Order order) {
			Direction direction = null;
			switch(order) {
			case UP:
				direction = Direction.UP;
			case DOWN:
				direction = Direction.DOWN;
			case LEFT:
				direction = Direction.LEFT;
			case RIGHT:
				direction = Direction.RIGHT;
			case UPLEFT:
        		direction = Direction.UPLEFT;
			case UPRIGHT:
        		direction = Direction.UPRIGHT;
			case DOWNLEFT:
				direction = Direction.DOWNLEFT;
			case DOWNRIGHT:
				direction = Direction.DOWNRIGHT;
			default:
				break;
			}
		return direction;
		}
		
		
		public void tryMovePlayer(Player player, Order order) {
			Position theoricalPosition = new Position();
			Direction direction;
			direction = getOrderToDirection(order);
			theoricalPosition = getTheoricalPositionElement(player, direction);
			if (!Collisions.testNextCaseWall(player, theoricalPosition)) {
				//appliquer le mouvement
				//peindre composants
			}
		}
		public void tryMoveMonster(IMonster monster, Order order) {
			Position theoricalPosition = new Position();
			Direction direction;
			direction = getOrderToDirection(order);
			theoricalPosition = getTheoricalPositionElement(monster, direction);
			if (!Collisions.testNextCaseWall(monster, theoricalPosition)) {
				//appliquer le mouvement
				//peindre composants
			}
		}
		public void tryMoveSpell(Spell spell, Order order) {
			Position theoricalPosition = new Position();
			Direction direction;
			direction = getOrderToDirection(order);
			theoricalPosition = getTheoricalPositionElement(spell, direction);
			if (!Collisions.testNextCaseWall(spell, theoricalPosition)) {
				//appliquer le mouvement
				//peindre composants
			}
		}
		public void setLorannModel(ILorannModel lorannmodel) {
			
		}
		public void launchSpell(Spell spell) {
			
		}

}
