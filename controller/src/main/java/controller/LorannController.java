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
	private String mapString = 	"O-------OE"
			+ 					"|       |E"
			+ 					"| 2 * 1 |E"
			+ 					"|       |E"
			+ 					"O-------OEF";
	
	private Animator playerAnimator;
	
	public LorannController(ILorannView lorannView, ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		this.lorannView = lorannView;
	}
	
	public void orderPerform(UserOrder userOrder) {
		
	}
	
	public void play() {
		buildMap(mapString);
		playerAnimator = new Animator(lorannModel.getPlayer());
		playerAnimator.setSpeed(200);
		playerAnimator.start();
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
		
		KeyToOrder();
		
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
			}
		//}
	//}
	
//	private boolean boolZ = false;
//	private boolean boolD = false;
//	private boolean boolS = false;
//	private boolean boolQ = false;
//	
//	private boolean boolUP = false;
//	private boolean boolRIGHT = false;
//	private boolean boolDOWN = false;
//	private boolean boolLEFT = false;
	
	private void KeyToOrder() {
		
		boolean[] bools= lorannView.getBools();
		
		UserOrder order;
			if (bools[1] && bools[2]) {
				order = new UserOrder(Order.UPRIGHT);
			}
			else if (bools[1] && bools[4]) {
				order = new UserOrder(Order.UPLEFT);
			}
			else if (bools[3] && bools[2]) {
				order = new UserOrder(Order.DOWNRIGHT);
			}
			else if (bools[3] && bools[4]) {
				order = new UserOrder(Order.DOWNLEFT);
			}
			else if (bools[1]) {
				order = new UserOrder(Order.UP);
			}
			else if (bools[2]) {
				order = new UserOrder(Order.RIGHT);
			}
			else if (bools[3]) {
				order = new UserOrder(Order.DOWN);
			}
			else if (bools[4]) {
				order = new UserOrder(Order.LEFT);
			}
			//return order;
		}
	}
//}
