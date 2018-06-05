
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
 * <h1>The LorannController Class.</h1>
 *
 * @author Charles Agostini / Vicente Vaz / Anatole Couasnon / Louis Marjolet
 * @version 1.0
 */
public class LorannController implements IOrderPerformer{
	/**
	 * The constante to set the use of data base.
	 */
	private static boolean USE_DB = true;
	/**
	 * The level number.
	 */
	private static int numlevel = 4;
	/**
	 * The thread time sleep constant.
	 */
	private static int TIME_SLEEP = 30;
	/**
	 * Do the game has started.
	 */
	private boolean gameHasStarted = false;
	/**
	 * Do the game has finished.
	 */
	private boolean isGameOver	= false;
	/**
	 * The lorannModel.
	 */
	private final ILorannModel lorannModel;
	/**
	 * The lorannVIew.
	 */
	private ILorannView lorannView;
	/**
	 * The local map.
	 */
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
	/**
	 * the local map width.
	 */
	private int mapWidth = 20;
	/**
	 * the local map height.
	 */
	private int mapHeight = 13;
	//private String mapString = "|-ODDE*1234EPK   EF";
	
	/**
	 * The animators.
	 */
	private Animator playerAnimator;
	private Animator monstersAnimator;
	private Animator spellAnimator;
	
	/**
	 * Creates a lorannController.
	 * @param lorannView
	 * 			the lorannView.
	 * @param lorannModel
	 * 			the lorannModel.
	 */
	public LorannController(ILorannView lorannView, ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		this.lorannView = lorannView;
		TryMove.setLorannModel(lorannModel);
	}
	
	/**
	 * Launch the game.
	 */
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

		gameLoop();
	}
	
	/**
	 * Catch the map from the database.
	 * @param id
	 *				the id.
	 * @return	the level.
	 * @see model.Level 
	 */
	public Level catchMapFromDB(int id) {
		Level level = null;
		try {
			level = LevelDAO.getCodeLevel(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return level;
	}
	
	/**
	 * Sets the lorannView
	 * @param lorannView
	 * 			the lorannView.
	 */
	public void setLorannView(ILorannView lorannView) {
		this.lorannView = lorannView;
	}
	
	/**
	 * The game loop.
	 */
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
			
			this.lorannModel.setMobilesHavesMoved();
			orderPerform();
		}
	}
	
	/**
	 * build the map, fill the monster array, and the player.
	 */
	public void buildMap() {
		Level level = new Level(1, mapString, this.mapHeight, this.mapWidth);
		if(USE_DB) {
			level = catchMapFromDB(numlevel);
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
				lorannView.displayMessage("GameOver ! :(");
				LorannController.numlevel = 1;
				this.gameHasStarted = false;
				loadLvl();
			}
		}
		if (lorannModel.getPlayer().getHasSucceedLvl()) {
			String message = "You achieved the Level " + numlevel + " !";
			lorannView.displayMessage(message);
			if (numlevel < 16) {
				numlevel += 1;
			lorannModel.getPlayer().setHasSucceedLvl(false);
			loadLvl();
			}
			else {
				lorannModel.getPlayer().setHasSucceedLvl(false);
				lorannView.displayMessage("You win !!! :D");
				lorannView.closeAll();
				this.isGameOver=true;
			}
		}
	}
	}
		
	/**
	 * Load the next level.
	 */
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
	
	/**
	 * Gets the booleans from the view and transform it to Orders.
	 * @return the user orders.
	 */
	private UserOrder KeyToOrder() {
		boolean[] bools= lorannView.getBools();
		for (int i = 0; i < bools.length ; i++) {
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
	
	/**
	 * Gets the booleans from the view and transform it to Orders.
	 * @return the user order.
	 */
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

