/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import model.element.mobile.Crocodil;
import model.element.mobile.MobileElement;
import model.element.mobile.Player;
import model.element.mobile.Position;
import model.element.mobile.Spell;
import model.element.motionless.MotionlessElement;

/**
 * @author Louis
 *
 */
public class CollisionsTest {

	/**
	 * Test method for {@link controller.Collisions#testCaseMob(model.element.mobile.MobileElement, java.util.ArrayList)}.
	 */
	
	@Test
	public void testTestCaseMob() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement e1 = new Player(position);
		MobileElement e2 = new Crocodil(position);
		ArrayList<MobileElement> listeEntity;
		listeEntity.add(e2);
		assertEquals(Collisions.testCaseMob(e1, listeEntity), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testCaseSpell(model.element.mobile.Player, model.element.mobile.Spell)}.
	 */
	@Test
	public void testTestCaseSpell() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		Player p = new Player(position);
		Spell s = new Spell(position);
		assertEquals(Collisions.testCaseSpell(p, s), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testCaseObject(model.element.mobile.Player, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestCaseObject() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		Player p = new Player(position);
		MotionlessElement purse = new Purse();
		MotionlessElement[][] map = {{purse},{}};
		assertEquals(Collisions.testCaseObject(p, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testCaseDoorClose(model.element.mobile.MobileElement, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestCaseDoorClose() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement door = new Door();
		MotionlessElement[][] map = {{door},{}};
		assertEquals(Collisions.testCaseDoorClose(mobileElement, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testCaseDoorOpen(model.element.mobile.MobileElement, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestCaseDoorOpen() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement door = new Door();
		door.setPermeability(Door.ENDER);
		MotionlessElement[][] map = {{door},{}};
		assertEquals(Collisions.testCaseDoorClose(mobileElement, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testCaseDoor(model.element.mobile.MobileElement, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestCaseDoor() {
		int x=0, y=0;
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement door = new Door();
		MotionlessElement[][] map = {{door},{}};
		assertEquals(Collisions.testCaseDoorClose(mobileElement, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testNextCaseObject(model.element.mobile.MobileElement, model.element.mobile.Position, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestNextCaseObject() {
		int x=0, y=1;
		Position nextPosition = new Position();
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement purse = new Purse();
		MotionlessElement[][] map = {{purse},{}};
		nextPosition.setPosition(mobileElement.getPosition().getX(), mobileElement.getPosition().getY() - 1);
		mobileElement.setPosition(nextPosition.getX(), nextPosition.getY());
		assertEquals(Collisions.testNextCaseObject(mobileElement, nextPosition, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testNextCaseSpell(model.element.mobile.MobileElement, model.element.mobile.Position, model.element.mobile.Spell)}.
	 */
	@Test
	public void testTestNextCaseSpell() {
		int x=0, y=1;
		Position position = new Position(x,y);
		Position nextPosition = new Position();
		MobileElement mobileElement = new Player(position);
		Spell spell = new Spell(nextPosition);
		nextPosition.setPosition(mobileElement.getPosition().getX(), mobileElement.getPosition().getY() - 1);
		mobileElement.setPosition(nextPosition.getX(), nextPosition.getY());
		assertEquals(Collisions.testNextCaseSpell(mobileElement, nextPosition, spell), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testNextCaseWall(model.element.mobile.MobileElement, model.element.mobile.Position, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestNextCaseWall() {
		int x=0, y=1;
		Position nextPosition = new Position();
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement wall = new HorizontalBone();
		MotionlessElement[][] map = {{wall},{}};
		nextPosition.setPosition(mobileElement.getPosition().getX(), mobileElement.getPosition().getY() - 1);
		mobileElement.setPosition(nextPosition.getX(), nextPosition.getY());
		assertEquals(Collisions.testNextCaseObject(mobileElement, nextPosition, map), true);
	}

	/**
	 * Test method for {@link controller.Collisions#testNextCaseDoor(model.element.mobile.MobileElement, model.element.mobile.Position, model.element.motionless.MotionlessElement[][])}.
	 */
	@Test
	public void testTestNextCaseDoor() {
		int x=0, y=1;
		Position nextPosition = new Position();
		Position position = new Position(x,y);
		//position.setPosition(0, 0);
		MobileElement mobileElement = new Player(position);
		//MobileElement mobileElement2 = new Crocodil(position);
		//Spell spell = new Spell(null, x, y);
		MotionlessElement door = new Door();
		MotionlessElement[][] map = {{door},{}};
		nextPosition.setPosition(mobileElement.getPosition().getX(), mobileElement.getPosition().getY() - 1);
		mobileElement.setPosition(nextPosition.getX(), nextPosition.getY());
		assertEquals(Collisions.testNextCaseObject(mobileElement, nextPosition, map), true);
	}

}
