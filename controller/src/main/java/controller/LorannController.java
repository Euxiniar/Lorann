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
import view.IViewSystem;

/**
 * @author vazvi
 *
 */
public class LorannController implements IOrderPerformer{
	private static int TIME_SLEEP = 30;
	private boolean isGameOver	= false;
	private final ILorannModel lorannModel;
	private IViewSystem viewSystem;
	private String mapString = "|";
	
	public LorannController(ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
	}
	
	public void orderPerform(UserOrder userOrder) {
		
	}
	
	public void play() {
		buildMap(mapString);
		gameLoop();
	}
	
	public void setViewSystem(IViewSystem viewSystem) {
		
	}
	
	private void gameLoop() {
		while (!this.isGameOver) {
			try {
				Thread.sleep(TIME_SLEEP);
			} catch (final InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

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
		int i = 0, j = 0;
		Map map = new Map();
		Position position = new Position();
			
		while(mapString.charAt(j) != 'F') {
			while (mapString.charAt(i) != 'E') {
				position.setX(i);
				position.setY(j);
				if(mapString.charAt(i) == '*') {
					Player player = new Player(position);
					lorannModel.setPlayer(player);
				}
				else if(mapString.charAt(i) == '1' || mapString.charAt(i) == '2' || mapString.charAt(i) == '3' || mapString.charAt(i) == '4') {
					IMonster monster = MonsterFactory.getFromSymbol(mapString.charAt(i), position);
					lorannModel.addMonster(monster);
				}
					
				else {
					map.setOnTheMap(MotionlessElementFactory.getFromSymbol(mapString.charAt(i), position), position);
				}
				i++;
			}
			j++;
		}
		lorannModel.setMap(map);
	}

	/* (non-Javadoc)
	 * @see controller.IOrderPerformer#orderPerform(controller.IUserOrder)
	 */
	@Override
	public void orderPerform(IUserOrder userOrder) {
		if (userOrder != null) {
			final IMobile plane = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer());
			if (plane != null) {
				Direction direction;
				switch (userOrder.getOrder()) {
					case UP:
						direction = Direction.UP;
						break;
					case RIGHT:
						direction = Direction.RIGHT;
						break;
					case DOWN:
						direction = Direction.DOWN;
						break;
					case LEFT:
						direction = Direction.LEFT;
						break;
					case SHOOT:
						try {
							this.lauchMissile(userOrder.getPlayer());
						} catch (final IOException e) {
							e.printStackTrace();
						}
					case NOP:
					default:
						direction = this.dogfightModel.getMobileByPlayer(userOrder.getPlayer()).getDirection();
						break;
				}
				plane.setDirection(direction);
			}
		}
	}
}
