/**
 * <h1>The PositionTest.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import static org.junit.Assert.*;

import org.junit.Test;

import model.element.Position;

/**
 * @author Louis
 *
 */
public class PositionTest {

	/**
	 * Test method for {@link model.element.mobile.Position#getX()}.
	 */
	Position position = new Position();
	Position expected = new Position();
	
	@Test
	public void testGetX() {
		this.position.setPosition(0,0);
		this.expected.setPosition(0,0);
		assertEquals(this.position.getX(), this.expected.getX());
	}

	/**
	 * Test method for {@link model.element.mobile.Position#setX(int)}.
	 */
	@Test
	public void testSetX() {
	}

	/**
	 * Test method for {@link model.element.mobile.Position#getY()}.
	 */
	@Test
	public void testGetY() {
		assertEquals(this.position.getY(), this.expected.getY());
	}

	/**
	 * Test method for {@link model.element.mobile.Position#setY(int)}.
	 */
	@Test
	public void testSetY() {
	}

	/**
	 * Test method for {@link model.element.mobile.Position#setPosition(int, int)}.
	 */
	@Test
	public void testSetPosition() {
	}

}
