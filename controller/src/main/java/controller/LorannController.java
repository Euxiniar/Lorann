
package controller;

import java.sql.SQLException;

import model.ILorannModel;
import model.Level;
import model.dao.LevelDAO;
import model.element.IElement;
import model.element.Map;
import model.element.Permeability;
import model.element.Position;
import model.element.mobile.*;
import model.element.mobile.MonsterFactory;
import model.element.mobile.Player;
import model.element.motionless.MotionlessElementFactory;
import view.ILorannView;

/**
 * <h1>The LorannController.java Class.</h1>
 *
 * @author Charles Agostini / Vicente Vaz / Anatole Couasnon / Louis Marjolet
 * @version 1.0
 */
public class LorannController implements IOrderPerformer{
	private static boolean USE_BDD = true;
	private static int numlevel = 1;
	private static int TIME_SLEEP = 30;
	private boolean gameHasStarted = false;
	private boolean isGameOver	= false;
	private final ILorannModel lorannModel;
	private ILorannView lorannView;
	private String mapString = 	"O------------------OE"
			+ 					"| P                |E"
			+ 					"|       | * |      |E"
			+ 					"|  K    | D |      |E"
			+ 					"|       O---O      |E"
			+ 					"|       1   2      |E"
			+ 					"| O--------------O |E"
			+ 					"|                  |E"
			+ 					"|P-----------------|E"
			+ 					"|P  P            P |E"
			+ 					"|----------------- |E"
			+ 					"| K1  P  4P  3 P   |E"
			+ 					"O------------------OEF";
	private int mapWidth = 20;
	private int mapHeight = 13;
	//private String mapString = "|-ODDE*1234EPK   EF";
	
	private Animator playerAnimator;
	private Animator monstersAnimator;
	private Animator spellAnimator;
	
	public LorannController(ILorannView lorannView, ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		this.lorannView = lorannView;
		TryMove.setLorannModel(lorannModel);
	}
	
	public void play() {
		buildMap();
		this.gameHasStarted = true;
		playerAnimator = new Animator(lorannModel.getPlayer());
		playerAnimator.setSpeed(100);
		playerAnimator.start();
		monstersAnimator = new Animator(lorannModel.getMonsters());
		monstersAnimator.setSpeed(100);
		monstersAnimator.start();
		spellAnimator = new Animator(lorannModel.getSpell());
		spellAnimator.setSpeed(200);
		spellAnimator.start();
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		gameLoop();
		lorannView.displayMessage("You died !");
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
			spellAnimator.update(System.currentTimeMillis());
			
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
		Level level = new Level(1, mapString, this.mapHeight, this.mapWidth);
		if(USE_BDD) {
			level = catchMapFromBDD(numlevel);
		}
			
		int i = 0, y = 0, x = 0;
		Map map = new Map(level.getWidth(), level.getHeight());
			
		while(level.getCode().charAt(i) != 'F') {
			while (level.getCode().charAt(i) != 'E') {
				if(level.getCode().charAt(i) == '*' && !gameHasStarted) {
					Player player = new Player(new Position(x, y));
					lorannModel.setPlayer(player);
				}
				else if(level.getCode().charAt(i) == '*' && gameHasStarted) {
					lorannModel.getPlayer().setPosition(new Position(x, y));
					lorannModel.getPlayer().setAlive(true);
					lorannModel.getPlayer().setDirection(Direction.STATIC);
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
		if (lorannModel.getPlayer().getIsAlive()) {
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		UserOrder order = KeyToOrder();
		TryMove.tryMovePlayer(lorannModel.getPlayer(), order.getOrder());
		if (!lorannModel.getSpell().getIsAlive())
			order = KeySpellToOrder();
		TryMove.tryMoveSpell(lorannModel.getSpell(), order.getOrder());
		
		if (lorannModel.getPlayer().isPlayerhasMoved()) {
			for (IMonster monster : lorannModel.getMonsters()) {
				if (monster.getIsAlive())
					TryMove.tryMoveMonster(monster, lorannModel.getPlayer());
			}
		}
		
		if (!lorannModel.getPlayer().getIsAlive()) {
			if (lorannModel.getPlayer().getLife()>=2) {
				lorannModel.getPlayer().removeLife(1);
		        lorannView.displayMessage("You died !");
		        lorannModel.getPlayer().setScore(lorannModel.getPlayer().getScore()-1000);
		        if(lorannModel.getPlayer().getScore() < 0)
		        	lorannModel.getPlayer().setScore(0);
				loadLvl();
			}
			else {
				lorannView.displayMessage("GameOver");
				lorannView.closeAll();
			}
		}
		if (lorannModel.getPlayer().getHasSucceedLvl()) {
			if (numlevel <= 6) {
				numlevel += 1;
			System.out.println("You achieved the Level !");
			lorannView.displayMessage("You achieved the Level !");
			lorannModel.getPlayer().setHasSucceedLvl(false);
			loadLvl();
			}
			else {
				lorannView.displayMessage("You win !!! :D");
			}
		}
	}
	}
			
	private void loadLvl() {
        System.out.println(lorannModel.getPlayer().getLife());
        IElement element = null;
        for(int y = 0; y < lorannModel.getMap().getHeight(); y++) {
            for(int x = 0; x < lorannModel.getMap().getWidth(); x++) {
                element = lorannModel.getMap().getOnTheMap(new Position(x, y));
                if(element.getSymbol() == 'D') {
                    element.setPermeability(Permeability.KILLER);
                }
            }
        }
        lorannModel.getMonsters().clear();
        lorannModel.getPlayer().setPlayerhasMoved(false);
        lorannView.resetBools();
        lorannModel.getPlayer().setDirection(Direction.STATIC);
        lorannModel.getPlayer().setAlive(true);
        play();
        }
	
	private UserOrder KeyToOrder() {
		//Z, D, S, Q UP,RIGHT, DOWN, LEFT
		boolean[] bools= lorannView.getBools();
		for (int i = 0; i < bools.length -1; i++) {
		}
		
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
	
	private UserOrder KeySpellToOrder() {
		
		boolean[] bools= lorannView.getBools();
		
		UserOrder order = null;
		
		if (bools[4] && bools[5]) {
			order = new UserOrder(Order.UPRIGHT);
		}
		else if (bools[4] && bools[7]) {
			order = new UserOrder(Order.UPLEFT);
		}
		else if (bools[6] && bools[5]) {
			order = new UserOrder(Order.DOWNRIGHT);
		}
		else if (bools[6] && bools[7]) {
			order = new UserOrder(Order.DOWNLEFT);
		}
		else if (bools[4]) {
			order = new UserOrder(Order.UP);
		}
		else if (bools[5]) {
			order = new UserOrder(Order.RIGHT);
		}
		else if (bools[6]) {
			order = new UserOrder(Order.DOWN);
		}
		else if (bools[7]) {
			order = new UserOrder(Order.LEFT);
		}
		else {
		order = new UserOrder(Order.STOP);
		}
		return order;
}
	}
//}
