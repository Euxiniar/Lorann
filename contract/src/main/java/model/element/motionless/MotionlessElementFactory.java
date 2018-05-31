/**
 * <h1>The MotionlessElementFactory.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.motionless;

import model.element.Position;

public abstract class MotionlessElementFactory {
    
    public static MotionlessElement createBallBone(Position position) {
    	BallBone ballBone = new BallBone(new Position(position.getX(), position.getY()));
    	return ballBone;
    }
    
    public static MotionlessElement createDoor(Position position) {
    	Door door = new Door(new Position(position.getX(), position.getY()));
    	return door;
    }
    
    public static MotionlessElement createHorizontalBone(Position position) {
    	HorizontalBone horizontalBone = new HorizontalBone(new Position(position.getX(), position.getY()));
    	return horizontalBone;
    }
    
    public static MotionlessElement createVerticalBone(Position position) {
    	VerticalBone verticalBone = new VerticalBone(new Position(position.getX(), position.getY()));
    	return verticalBone;
    }
    
    public static MotionlessElement createKey(Position position) {
    	Key key = new Key(new Position(position.getX(), position.getY()));
    	return key;
    }
    
    public static MotionlessElement createPurse(Position position) {
    	Purse purse = new Purse(new Position(position.getX(), position.getY()));
    	return purse;
    }
    
    public static MotionlessElement createMacadam(Position position) {
    	Macadam macadam = new Macadam(new Position(position.getX(), position.getY()));
    	return macadam;
    }
    
    public static MotionlessElement getFromSymbol(char symbol, Position position) {

    		switch(symbol) {
    		case '|' :
    			return createVerticalBone(position);
    		case '-' :
    			return createHorizontalBone(position);
    		case 'O' :
    			return createBallBone(position);
    		case 'K' :
    			return createKey(position);
    		case 'P' :
    			return createPurse(position);
    		case 'D' :
    			return createDoor(position);
    		default :
    			return createMacadam(position);
        }
    }
}