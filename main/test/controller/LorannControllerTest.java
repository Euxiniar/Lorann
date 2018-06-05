//package controller;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import model.LorannModel;
//import view.LorannView;
//
//class LorannControllerTest {
//	private LorannModel lorannModel;
//	private LorannView lorannView;
//	private LorannController lorannController = null;
//	private boolean[] bools;
//	Order result;
//	UserOrder order;
//	
//	@BeforeAll
//	static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterAll
//	static void tearDownAfterClass() throws Exception {
//	}
//
//	@BeforeEach
//	void setUp() throws Exception {
//		lorannModel = new LorannModel();
//    	lorannView = new LorannView( lorannModel, lorannModel);
//    	lorannController = new LorannController(lorannView, lorannModel);
//    	result = null;
//	}
//
//	@AfterEach
//	void tearDown() throws Exception {
//	}
//
//	@Test
//	void testKeyToOrder() {
//		lorannView.resetBools();
//		bools = lorannView.getBools();
//		Order tabResult[] = {Order.UPRIGHT, Order.UPLEFT, Order.DOWNRIGHT, Order.DOWNLEFT, Order.UP, Order.RIGHT, Order.DOWN, Order.LEFT, Order.STOP};
//		bools[0] = true;
//		bools[1] = true;
//		lorannView.setBools(bools);
//		order = lorannController.keyToOrder();
//		result = tabResult[0];
//		assertEquals(result, order.getOrder());
//		
//		
//		lorannView.resetBools();
//		bools = lorannView.getBools();
//		bools[0] = true;
//		bools[3] = true;
//		lorannView.setBools(bools);
//		order = lorannController.keyToOrder();
//		result = tabResult[1];
//		assertEquals(result, order.getOrder());	
//		
//		
//		lorannView.resetBools();
//		bools = lorannView.getBools();
//		bools[2] = true;
//		bools[1] = true;
//		lorannView.setBools(bools);
//		order = lorannController.keyToOrder();
//		result = tabResult[2];
//		assertEquals(result, order.getOrder());
//		
//		
//		lorannView.resetBools();
//		bools = lorannView.getBools();
//		bools[3] = true;
//		bools[2] = true;
//		lorannView.setBools(bools);
//		order = lorannController.keyToOrder();
//		result = tabResult[3];
//		assertEquals(result, order.getOrder());
//		
//		for (int i = 0; i < 4; i++) {
//			lorannView.resetBools();
//			bools = lorannView.getBools();
//			bools[i] = true;
//			lorannView.setBools(bools);
//			order = lorannController.keyToOrder();
//			result = tabResult[4+i];
//			assertEquals(result, order.getOrder());
//		}		
//		lorannView.resetBools();
//		bools = lorannView.getBools();
//		lorannView.setBools(bools);
//		order = lorannController.keyToOrder();
//		result = tabResult[8];
//		assertEquals(result, order.getOrder());
//	}
//
//}
