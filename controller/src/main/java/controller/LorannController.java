/**
 * 
 */
package controller;
import model.element.IElement;
import model.element.Position;
import model.element.mobile.MonsterFactory;
import model.element.mobile.Player;
import model.element.mobile.Position;

/**
 * @author vazvi
 *
 */
public class LorannController {
	private static int TIME SLEEP = 30;
	
	public LorannController(ILorannModel lorannModel) {
	
	}
	
	public void orderPerform(UserOrder userOrder) {
		
	}
	
	public void play() {
		
	}
	
	public void setViewSystem(IViewSystem viewSystem) {
		
	}
	private void gameLoop() {
		
	}
	public Map buildMap(String mapString) {
		int i = 0, j = 0;
		Map map = new Map();
		Position position = null;
			
		while(mapString.charAt(j) != 'F') {
			while (mapString.charAt(i) != 'E') {
				position.setX(i);
				position.setY(j);
				if(mapString.charAt(i) == '*') {
					Player player = Player(position);
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
		lorannModel.setPlayer(player);
		map.LorannModel.getMap();
	}
}
