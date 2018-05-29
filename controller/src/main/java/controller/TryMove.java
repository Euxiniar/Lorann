/**
 * 
 */
package controller;

import GameFrame.GamePanel;
import model.element.Direction;
import model.element.mobile.Player;
import model.element.mobile.Position;

/**
 * @author Snargol
 *
 */
public class TryMove {
	
	public TryMove(Player player, Direction direction) {
		Position position = new Position();
		position = getTheoricalPositionPlayer(player, direction);
		Collisions.testNextCaseWall(player, position);
		GamePanel.paintComponent(null);
		
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
