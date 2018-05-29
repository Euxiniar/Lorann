/**
 * 
 */
package controller;

import model.element.Direction;
import model.element.mobile.MobileElement;
import model.element.mobile.Position;

/**
 * @author Snargol
 *
 */
public class TryMove {
	
	
		public Position getTheoricalPosition(Direction direction, MobileElement element) {
	        Position position = new Position();
	        switch(direction) {
	        case UP:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() + 1);
	        case DOWN:
	            position.setPosition(element.getPosition().getX(), element.getPosition().getY() - 1);
	        case LEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY());
	        case RIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY());
	        case UPLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() + 1);
	        case UPRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() + 1);
	        case DOWNLEFT:
	            position.setPosition(element.getPosition().getX() - 1, element.getPosition().getY() - 1);
	        case DOWNRIGHT:
	            position.setPosition(element.getPosition().getX() + 1, element.getPosition().getY() - 1);
	        default:
	            break;
	        }
	        return position;
	    }
	
}
