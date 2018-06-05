/**
 * 
 */
package controller;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Position;
import model.element.mobile.Direction;
import model.element.mobile.IMonster;
import model.element.mobile.MonsterFactory;
import model.element.mobile.Player;

/**
 * @author Vicente
 *
 */
public class TryMoveTest {
	private Position positionPlayer;
	private Position positionMonster;
	private IMonster monster;
	private Player player;
	Direction result;
	Direction direction;
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
		this.positionPlayer = new Position();
		this.positionMonster = new Position();
		this.monster = MonsterFactory.getFromSymbol('3', positionMonster);
		this.player = new Player(positionPlayer);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link controller.TryMove#getTheoricalPositionElement(model.element.IElement, model.element.mobile.Direction)}.
	 */
	@Test
	public void testGetTheoricalPositionElement() {
		
		//fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.TryMove#getOrderToDirection(controller.Order)}.
	 */
	@Test
	public void testGetOrderToDirection() {
		Order tabParameter[] = {Order.UP, Order.DOWN, Order.LEFT, Order.RIGHT, Order.UPLEFT, Order.UPRIGHT, Order.DOWNLEFT, Order.DOWNRIGHT, Order.STOP, Order.SHOOT};
		Direction tabExpected[] =  {Direction.UP, Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.UPLEFT, Direction.UPRIGHT, Direction.DOWNLEFT, Direction.DOWNRIGHT, Direction.STATIC, Direction.STATIC};
		for(int i = 0; i < 8; i++)
		{
			Order order = tabParameter[i];
			this.result = tabExpected[i];
			assertEquals(result, TryMove.getOrderToDirection(order));
		}
	}

	/**
	 * Test method for {@link controller.TryMove#getMonsterDirection(model.element.mobile.IMonster, model.element.mobile.Player)}.
	 */
	@Test
	public void testGetMonsterDirection() {
		this.positionPlayer.setPosition(0, 0);
		this.positionMonster.setPosition(1, 1);
		this.monster.setPosition(this.positionMonster);
		this.player.setPosition(positionPlayer);
		int tabPositionXPlayerParameter[] =  {0, 0, 0, 1, 1, 1, 0, 0, 0};
		int tabPositionYPlayerParameter[] =  {0, 1, 0, 0, 1, 0, 0, 1, 0};
		int tabPositionXMonsterParameter[] = {1, 1, 1, 0, 0, 0, 0, 0, 0};
		int tabPositionYMonsterParameter[] = {1, 0, 0, 1, 0, 0, 1, 0, 0};
		Direction tabExpected[] = {Direction.UPLEFT, Direction.DOWNLEFT, Direction.LEFT, Direction.UPRIGHT, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UP, Direction.DOWN, Direction.UP};
		for(int i = 0; i < 9; i++)
		{
			this.positionPlayer.setPosition(tabPositionXPlayerParameter[i], tabPositionYPlayerParameter[i]);
			this.positionMonster.setPosition(tabPositionXMonsterParameter[i], tabPositionYMonsterParameter[i]);
			this.player.setPosition(positionPlayer);
			this.monster.setPosition(positionMonster);
			this.result = tabExpected[i];
			assertEquals(result, TryMove.getMonsterDirection(monster, player));
		}
	}

	/**
	 * Test method for {@link controller.TryMove#reverseDirection(model.element.mobile.Direction)}.
	 */
	@Test
	public void testReverseDirection() {
		Direction tabParameter[] = {Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT};
		Direction tabExpected[] =  {Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT};
		for(int i = 0; i < 8; i++)
		{
			this.direction = tabParameter[i];
			this.result = tabExpected[i];
			assertEquals(result, TryMove.reverseDirection(direction));
		}
	}

	/**
	 * Test method for {@link controller.TryMove#changeClockwiseMonsterDirection(model.element.mobile.Direction)}.
	 */
	@Test
	public void testChangeClockwiseMonsterDirection() {
		Direction tabParameter[] = {Direction.UP, Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT};
		Direction tabExpected[] =  {Direction.UPRIGHT, Direction.RIGHT, Direction.DOWNRIGHT, Direction.DOWN, Direction.DOWNLEFT, Direction.LEFT, Direction.UPLEFT, Direction.UP};
		for(int i = 0; i < 8; i++)
		{
			this.direction = tabParameter[i];
			this.result = tabExpected[i];
			assertEquals(result, TryMove.changeClockwiseMonsterDirection(direction));
		}
	}

	/**
	 * Test method for {@link controller.TryMove#changeCounterclockwiseMonsterDirection(model.element.mobile.Direction)}.
	 */
	@Test
	public void testChangeCounterclockwiseMonsterDirection() {
		Direction tabParameter[] = {Direction.UP, Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT};
		Direction tabExpected[] =  {Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT, Direction.UP};
		
		for(int i = 0; i < 8; i++)
		{
			this.direction = tabParameter[i];
			this.result = tabExpected[i];
			assertEquals(result, TryMove.changeCounterclockwiseMonsterDirection(direction));
		}
	}
	
	/**
	 * Test method for {@link controller.TryMove#changeRandomlyMonsterDirection(Integer , model.element.mobile.Direction)}.
	 */
	@Test
	public void testChangeRandomlyMonsterDirection() {
		this.direction = null;
		Direction tabExpected[] = {Direction.UPLEFT, Direction.LEFT, Direction.DOWNLEFT, Direction.DOWN, Direction.DOWNRIGHT, Direction.RIGHT, Direction.UPRIGHT, Direction.UP};
		for(int i = 0; i < 8; i++)
		{
			this.result = tabExpected[i];
			assertEquals(result, TryMove.changeRandomlyMonsterDirection(i, direction));
		}
	}
	/**
	 * Test method for {@link controller.TryMove#tryMovePlayer(model.element.mobile.Player, controller.Order)}.
	 */
//	public void testTryMovePlayer() {
//		Order order;
//		Position position = new Position();
//		Player player = new Player(position);
//		TryMove.tryMovePlayer(player, order);
//	}
	
	/**
	 * Test method for {@link controller.TryMove#tryMoveMonster(model.element.mobile.IMonster, model.element.mobile.Player)}.
	 */
	@Test
	public void testTryMoveMonster() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.TryMove#movementMonster1(model.element.mobile.IMonster, model.element.Position, model.element.mobile.Player)}.
	 */
	@Test
	public void testMovementMonster1() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.TryMove#movementMonster2(model.element.mobile.IMonster, model.element.Position, model.element.mobile.Player)}.
	 */
	@Test
	public void testMovementMonster2() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link controller.TryMove#movementMonster3(model.element.mobile.IMonster, model.element.Position, model.element.mobile.Player)}.
	 */
	@Test
	public void testMovementMonster3() {
//		fail("Not yet implemented");
	}

}
