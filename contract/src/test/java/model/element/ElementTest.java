package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.mobile.Skeleton;

public class ElementTest {

	static Position position;
	static IElement element;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		position = new Position(1,1);
		element = new Skeleton(position);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSetSelectedSpriteValue() {
		try {
			element.setSelectedSpriteValue(8);
		}
		catch (Exception e){
			String exception = e.toString();
			assertEquals("java.lang.ArrayIndexOutOfBoundsException: 1", exception);
		}
	}

	@Test
	public void testSetPositionIntInt() {
		position = new Position(-1, -1);
		try {
			element.setPosition(position);
		}
		catch (Exception e){
			String exception = e.toString();
			assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", exception);
		}
	}

	@Test
	public void testSetPositionPositionMax() {
		position = new Position(21, 21);
		try {
			element.setPosition(position);
		}
		catch (Exception e){
			String exception = e.toString();
			assertEquals("java.lang.ArrayIndexOutOfBoundsException: 1", exception);
		}
	}

	@Test
	public void testSetPositionPositionMin() {
		position = new Position(-1, -1);
		try {
			element.setPosition(position);
		}
		catch (Exception e){
			String exception = e.toString();
			assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", exception);
		}
	}
}
