/**
 * 
 */
package controller;

import model.ILorannModel;
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
//	private String mapString = 	"O-------OE"
//			+ 					"|       |E"
//			+ 					"| 2 * 1 |E"
//			+ 					"|       |E"
//			+ 					"O-------OEF";
	private String mapString = "|-ODDE*1234EPK   EF";
	
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
		buildMap(mapString);
		playerAnimator = new Animator(lorannModel.getPlayer());
		playerAnimator.setSpeed(100);
		playerAnimator.start();
		monstersAnimator = new Animator(lorannModel.getMonsters());
		monstersAnimator.setSpeed(100);
		monstersAnimator.start();
		spellAnimator = new Animator(lorannModel.getSpell());
		spellAnimator.setSpeed(100);
		spellAnimator.start();
		gameLoop();
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
		}
	}
	public void buildMap(String mapString) {
		int i = 0, y = 0, x = 0;
		Map map = new Map();
			
		while(mapString.charAt(i) != 'F') {
			while (mapString.charAt(i) != 'E') {
				if(mapString.charAt(i) == '*') {
					Player player = new Player(new Position(x, y));
					lorannModel.setPlayer(player);
				}
				else if(mapString.charAt(i) == '1' || mapString.charAt(i) == '2' || mapString.charAt(i) == '3' || mapString.charAt(i) == '4') {
					lorannModel.addMonster(MonsterFactory.getFromSymbol(mapString.charAt(i), new Position(x, y)));
				}
				else {
					map.setOnTheMap(MotionlessElementFactory.getFromSymbol(mapString.charAt(i), new Position(x, y)), new Position(x, y));
				}
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
	public void orderPerform(IUserOrder userOrder) {
//		if (userOrder != null) {
//			final IMobile plane = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer());
//			if (plane != null) {
//				Direction direction;
//				switch (userOrder.getOrder()) {
//					case UP:
//						direction = Direction.UP;
//						break;
//					case RIGHT:
//						direction = Direction.RIGHT;
//						break;
//					case DOWN:
//						direction = Direction.DOWN;
//						break;
//					case LEFT:
//						direction = Direction.LEFT;
//						break;
//					case SHOOT:
//						try {
//							this.lauchMissile(userOrder.getPlayer());
//						} catch (final IOException e) {
//							e.printStackTrace();
//						}
//					case NOP:
//					default:
//						direction = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer()).getDirection();
//						break;
//				}
//				plane.setDirection(direction);
//			}
//		}
	}
}
