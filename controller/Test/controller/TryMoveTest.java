/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.Test;

import model.element.Direction;
import model.element.mobile.MobileElement;
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
		 expected.setPosition(0, 1);
		 
		 Direction direction = Direction.UP;
		 
		 position.setPosition(position.getX(), position.getY() + 1);
		 assertEquals(expected, position);
	}

}
