/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import model.element.Direction;
import model.element.mobile.Position;
/**
 * @author Louis
 *
 */
public class TryMoveTest {

	/**
	 * Test method for {@link controller.TryMove#getTheoricalPosition(model.element.Direction, model.element.mobile.MobileElement)}.
	 */
	@Test
	public void testGetTheoricalPosition() {
		 
		 Position position = new Position();
		 position.setPosition(0, 0);
		 Position expected = new Position();
		 Direction direction = Direction.DOWN;
		
		 switch(direction) {
	        case UP:
	        	expected.setPosition(0, 1);
	            position.setPosition(position.getX(), position.getY() + 1);
	        case DOWN:
	        	expected.setPosition(0, -1);
	            position.setPosition(position.getX(), position.getY() - 1);
	        case LEFT:
	        	expected.setPosition(-1, 0);
	            position.setPosition(position.getX() - 1, position.getY());
	        case RIGHT:
	        	expected.setPosition(1,0);
	            position.setPosition(position.getX() + 1, position.getY());
	        case UPLEFT:
	        	expected.setPosition(-1, 1);
	            position.setPosition(position.getX() - 1, position.getY() + 1);
	        case UPRIGHT:
	        	expected.setPosition(1, 1);
	            position.setPosition(position.getX() + 1, position.getY() + 1);
	        case DOWNLEFT:
	        	expected.setPosition(-1, -1);
	            position.setPosition(position.getX() - 1, position.getY() - 1);
	        case DOWNRIGHT:
	        	expected.setPosition(1, -1);
	            position.setPosition(position.getX() + 1, position.getY() - 1);
	        default:
	            break;
	        }
		 assertEquals(position.getX(), expected.getX());
		 assertEquals(position.getY(), expected.getY());
	}

}
