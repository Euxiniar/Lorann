/**
 * 
 */
package controller;

import java.sql.SQLException;

import model.ILorannModel;
import model.Level;
import model.dao.LevelDAO;
import model.element.Map;
import model.element.Position;
import model.element.mobile.*;
import model.element.mobile.MonsterFactory;
import model.element.mobile.Player;
import model.element.motionless.MotionlessElementFactory;
import view.ILorannView;

/**
 * @author Vicente Vaz/Charles Agostini
 *
 */
public class LorannController implements IOrderPerformer{
	private static int TIME_SLEEP = 30;
	private boolean isGameOver	= false;
	private final ILorannModel lorannModel;
	private ILorannView lorannView;
	private String mapString = 	"O------------------OE"
			+ 					"|                  |E"
			+ 					"|       | * |      |E"
			+ 					"|       | D |      |E"
			+ 					"|       O---O      |E"
			+ 					"|        324       |E"
			+ 					"|                  |E"
			+ 					"|                  |E"
			+ 					"| -----------------|E"
			+ 					"|P  P    P  P    P |E"
			+ 					"|----------------- |E"
			+ 					"| K1  P   P    P   |E"
			+ 					"O------------------OEF";
	//private String mapString = "|-ODDE*1234EPK   EF";
	
	private Animator playerAnimator;
	private Animator monstersAnimator;
	private Animator spellAnimator;
	
	public LorannController(ILorannView lorannView, ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		this.lorannView = lorannView;
	}
	
	public void orderPerform(UserOrder userOrder) {
		
	}
	
	public void play() {
		buildMap();
		playerAnimator = new Animator(lorannModel.getPlayer());
		playerAnimator.setSpeed(100);
		playerAnimator.start();
		monstersAnimator = new Animator(lorannModel.getMonsters());
		monstersAnimator.setSpeed(100);
		monstersAnimator.start();
		spellAnimator = new Animator(lorannModel.getSpell());
		spellAnimator.setSpeed(100);
		spellAnimator.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		gameLoop();
	}
	
	public Level catchMapFromBDD(int id) {
		Level level = null;
		try {
			level = LevelDAO.getCodeLevel(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
	}
	
	public void setLorannView(ILorannView lorannView) {
		this.lorannView = lorannView;
	}
	
	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}
			playerAnimator.update(System.currentTimeMillis());
			monstersAnimator.update(System.currentTimeMillis());
			
			
//			final ArrayList<MobileElement> initialMobileElement = new ArrayList<MobileElement>();
//			for (final MobileElement element : this.lorannModel.getElement()) {
//				initialMobilesElement.add(element);
//			}
//			for (final IMobile mobile : initialMobiles) {
//				mobile.move();
//				if (mobile.isWeapon()) {
//					this.manageCollision(mobile);
//				}
//			}
			this.lorannModel.setMobilesHavesMoved();
			orderPerform();
		}
	}
	public void buildMap() {
		//Level level = catchMapFromBDD(1);
		String mapString = 			"O------------------OE"
				+ 					"|                  |E"
				+ 					"|       | * |      |E"
				+ 					"|       | D |      |E"
				+ 					"|       O---O      |E"
				+ 					"|        324       |E"
				+ 					"|                  |E"
				+ 					"|                  |E"
				+ 					"| -----------------|E"
				+ 					"|P  P    P  P    P |E"
				+ 					"|----------------- |E"
				+ 					"| K1  P   P    P   |E"
				+ 					"O------------------OEF";
		Level level = new Level(1, mapString, 13, 20);
		int i = 0, y = 0, x = 0;
		Map map = new Map(level.getWidth(), level.getHeight());
			
		while(level.getCode().charAt(i) != 'F') {
			while (level.getCode().charAt(i) != 'E') {
				if(level.getCode().charAt(i) == '*') {
					Player player = new Player(new Position(x, y));
					lorannModel.setPlayer(player);
				}
				else if(level.getCode().charAt(i) == '1' || level.getCode().charAt(i) == '2' || level.getCode().charAt(i) == '3' || level.getCode().charAt(i) == '4') {
					lorannModel.addMonster(MonsterFactory.getFromSymbol(level.getCode().charAt(i), new Position(x, y)));
				}
				
				map.setOnTheMap(MotionlessElementFactory.getFromSymbol(level.getCode().charAt(i), new Position(x, y)), new Position(x, y));
				
				i++;
				x++;
			}
			i++;
			y++;
			x = 0;
		}
		lorannModel.setSpell(new Spell(new Position(0, 0)));
		lorannModel.setMap(map);
	}

	/* (non-Javadoc)
	 * @see controller.IOrderPerformer#orderPerform(controller.IUserOrder)
	 */
	@Override
	public void orderPerform() {
		TryMove tryMove = new TryMove(lorannModel);
		UserOrder order = KeyToOrder();
		if (order.getOrder() != Order.STOP) {
			tryMove.tryMovePlayer(lorannModel.getPlayer(), order.getOrder());
		}
		else {
			//System.out.println("else");
		}
			
			
		}
	
	private UserOrder KeyToOrder() {
		//Z, D, S, Q UP,RIGHT, DOWN, LEFT
		boolean[] bools= lorannView.getBools();
		
		UserOrder order = null;
			if (bools[0] && bools[1]) {
				order = new UserOrder(Order.UPRIGHT);
			}
			else if (bools[0] && bools[3]) {
				order = new UserOrder(Order.UPLEFT);
			}
			else if (bools[2] && bools[1]) {
				order = new UserOrder(Order.DOWNRIGHT);
			}
			else if (bools[2] && bools[3]) {
				order = new UserOrder(Order.DOWNLEFT);
			}
			else if (bools[0]) {
				order = new UserOrder(Order.UP);
			}
			else if (bools[1]) {
				order = new UserOrder(Order.RIGHT);
			}
			else if (bools[2]) {
				order = new UserOrder(Order.DOWN);
			}
			else if (bools[3]) {
				order = new UserOrder(Order.LEFT);
			}
			else {
			order = new UserOrder(Order.STOP);
			}
			
			return order;
		}
	}
//}
