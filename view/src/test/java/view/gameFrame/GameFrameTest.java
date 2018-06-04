package view.gameFrame;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import view.gameFrame.GameFrame;

/**
 * <h1>The GameFrameTest Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class GameFrameTest {

	private boolean[] orderBools; 
	private static GameFrame gameFrame;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		gameFrame = new GameFrame(null, null, null);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		orderBools = gameFrame.getBools(); 
		gameFrame.resetBools();
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link view.gameFrame.GameFrame#resetBools()}.
	 */
	@Test
	public void testResetBools() {
		for (int i = 0; i < orderBools.length; i++)
		assertEquals(false, orderBools[i]);
	}
	
	/**
	 * Test method for {@link view.gameFrame.GameFrame#setBool(boolean, int)}.
	 */
	@Test
	public void testSetBools() {
		for (int i = 0; i < orderBools.length; i++) {
			gameFrame.setBool(true, i);
			assertEquals(true, orderBools[i]);
		}
	}
}



