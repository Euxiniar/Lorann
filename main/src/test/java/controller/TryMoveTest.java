/**
 * 
 */
package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.LorannModel;
import model.element.Position;
import view.LorannView;

/**
 * @author Euxiniar
 *
 */
public class TryMoveTest {

	static LorannModel lorannModel;
	static LorannView lorannView;
	static LorannController lorannController;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lorannModel = new LorannModel();
		lorannView = new LorannView( lorannModel, lorannModel);
		lorannController = new LorannController(lorannView, lorannModel);
		lorannController.setLocalLevel("|*PEF", 3, 1);
		lorannController.setUseDB(false);
		lorannController.buildMap();
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.TryMove#tryMovePlayer(model.element.mobile.Player, controller.Order)}.
	 */
	@Test
	public void testTryMovePlayer() {
		Position position = new Position(2, 0);
		if(lorannModel.getMap().getOnTheMap(position).getIsAlive() == true) {
			TryMove.tryMovePlayer(lorannModel.getPlayer(), Order.RIGHT);
			assertEquals(lorannModel.getMap().getOnTheMap(position).getIsAlive(), false);
		}
		else
			fail("The grabable object seems to be already dead !");
	}
}
