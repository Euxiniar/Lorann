/**
 * 
 */
package controller;

import GameFrame.GamePanel;
import model.element.Direction;
import model.element.Position;
import model.element.mobile.Player;

/**
 * @author Snargol
 *
 */
public class TryMove {
	
	public void tryMove(Player player, Direction direction) {
		Position theoricalPosition = new Position();
		theoricalPosition = getTheoricalPositionPlayer(player, direction);
		if (!Collisions.testNextCaseWall(player, theoricalPosition)) {
			//appliquer le mouvement
			//peindre composants
		}
		
	}
	
		public Position getTheoricalPositionPlayer(Player player, Direction direction) {
	        Position position = new Position();
	        switch(direction) {
	        case UP:
	            position.setPosition(player.getPosition().getX(), player.getPosition().getY() - 1);
	        case DOWN:
	            position.setPosition(player.getPosition().getX(), player.getPosition().getY() + 1);
	        case LEFT:
	            position.setPosition(player.getPosition().getX() - 1, player.getPosition().getY());
	        case RIGHT:
	            position.setPosition(player.getPosition().getX() + 1, player.getPosition().getY());
	        case UPLEFT:
	            position.setPosition(player.getPosition().getX() - 1, player.getPosition().getY() - 1);
	        case UPRIGHT:
	            position.setPosition(player.getPosition().getX() + 1, player.getPosition().getY() - 1);
	        case DOWNLEFT:
	            position.setPosition(player.getPosition().getX() - 1, player.getPosition().getY() + 1);
	        case DOWNRIGHT:
	            position.setPosition(player.getPosition().getX() + 1, player.getPosition().getY() + 1);
	        default:
	            break;
	        }
	        return position;
	    }
	
}
