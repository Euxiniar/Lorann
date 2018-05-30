/**
 * 
 */
package controller;

import static org.junit.Assert.*;
import model.element.Element;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author vazvi
 *
 */
public class LorannControllerTest {
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
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.LorannController#buildMap(String)}.
	 */
	@Test
	public void testBuildMap() {
		final char expected = '|';
		String map = "|  *";
		LorannController lcontroller = new LorannCntroller();
		if(!assertEquals(expected, buildMap(map).getSymbol())) {
			fail("The built element doesn't match");
		}
	}

}
