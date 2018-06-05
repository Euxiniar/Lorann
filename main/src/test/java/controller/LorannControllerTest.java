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
import view.LorannView;

/**
 * @author Euxiniar
 *
 */
public class LorannControllerTest {
	private static LorannModel lorannModel;
	private static LorannView lorannView;
	private static LorannController lorannController = null;
	private boolean[] bools;
	static Order result;
	UserOrder order;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		lorannModel = new LorannModel();
    	lorannView = new LorannView( lorannModel, lorannModel);
    	lorannController = new LorannController(lorannView, lorannModel);
    	result = null;
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
	 * Test the keyToOrder method.
	 */
	@Test
	public void testKeyToOrder() {
		lorannView.resetBools();
		bools = lorannView.getBools();
		Order tabResult[] = {Order.UPRIGHT, Order.UPLEFT, Order.DOWNRIGHT, Order.DOWNLEFT, Order.UP, Order.RIGHT, Order.DOWN, Order.LEFT, Order.STOP};
		bools[0] = true;
		bools[1] = true;
		lorannView.setBools(bools);
		order = lorannController.keyToOrder();
		result = tabResult[0];
		assertEquals(result, order.getOrder());
		
		
		lorannView.resetBools();
		bools = lorannView.getBools();
		bools[0] = true;
		bools[3] = true;
		lorannView.setBools(bools);
		order = lorannController.keyToOrder();
		result = tabResult[1];
		assertEquals(result, order.getOrder());	
		
		
		lorannView.resetBools();
		bools = lorannView.getBools();
		bools[2] = true;
		bools[1] = true;
		lorannView.setBools(bools);
		order = lorannController.keyToOrder();
		result = tabResult[2];
		assertEquals(result, order.getOrder());
		
		
		lorannView.resetBools();
		bools = lorannView.getBools();
		bools[3] = true;
		bools[2] = true;
		lorannView.setBools(bools);
		order = lorannController.keyToOrder();
		result = tabResult[3];
		assertEquals(result, order.getOrder());
		
		for (int i = 0; i < 4; i++) {
			lorannView.resetBools();
			bools = lorannView.getBools();
			bools[i] = true;
			lorannView.setBools(bools);
			order = lorannController.keyToOrder();
			result = tabResult[4+i];
			assertEquals(result, order.getOrder());
		}		
		lorannView.resetBools();
		bools = lorannView.getBools();
		lorannView.setBools(bools);
		order = lorannController.keyToOrder();
		result = tabResult[8];
		assertEquals(result, order.getOrder());
	}
}
