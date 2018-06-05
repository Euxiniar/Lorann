/**
 * 
 */
package model.element;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.motionless.MotionlessElementFactory;

/**
 * <h1>The MapTest Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class MapTest {

	private Map map;
	private IElement element;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		map = new Map(1,1);
		Position position = new Position(0,0);
		element = MotionlessElementFactory.getFromSymbol('|', position);
		map.setOnTheMap(element, position);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link model.element.Map#getOnTheMap(model.element.Position)}.
	 */
	@Test
	public void testGetOnTheMapPosition() {
		Position position = new Position(1,1);
		try {
			map.getOnTheMap(position);
			fail("Out of bound but no exception");
		} catch (Exception e) {
			String exception = e.toString();
			if(exception == "java.lang.ArrayIndexOutOfBoundsException: 1") {
				assertEquals("java.lang.ArrayIndexOutOfBoundsException: 1", exception);
			}
			else if(exception == "java.lang.ArrayIndexOutOfBoundsException: -1") {
				assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", exception);
			}
		}
	}

	/**
	 * Test method for {@link model.element.Map#getOnTheMap(int, int)}.
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testGetOnTheMapIntInt() {
		int x = 1;
		int y = 1;
		try {
			map.getOnTheMap(x, y);
			fail("Out of bound but no exception");
		} catch (Exception e) {
			String exception = e.toString();
			if(exception == "java.lang.ArrayIndexOutOfBoundsException: 1") {
				assertEquals("java.lang.ArrayIndexOutOfBoundsException: 1", exception);
			}
			else if(exception == "java.lang.ArrayIndexOutOfBoundsException: -1") {
				assertEquals("java.lang.ArrayIndexOutOfBoundsException: -1", exception);
			}
		}
	}

}
