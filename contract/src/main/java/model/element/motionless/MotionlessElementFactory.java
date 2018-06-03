package model.element.motionless;

import model.element.Position;

/**
 * <h1>The MotionlessElementFactory Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class MotionlessElementFactory {
    /**
     * Create a new BallBone.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createBallBone(Position position) {
    	BallBone ballBone = new BallBone(new Position(position.getX(), position.getY()));
    	return ballBone;
    }
    
    /**
     * Create a new Door.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createDoor(Position position) {
    	Door door = new Door(new Position(position.getX(), position.getY()));
    	return door;
    }
    
    /**
     * Create a new HorizontalBone.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createHorizontalBone(Position position) {
    	HorizontalBone horizontalBone = new HorizontalBone(new Position(position.getX(), position.getY()));
    	return horizontalBone;
    }
    
    /**
     * Create a new VerticalBone.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createVerticalBone(Position position) {
    	VerticalBone verticalBone = new VerticalBone(new Position(position.getX(), position.getY()));
    	return verticalBone;
    }
    
    /**
     * Create a new Key.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createKey(Position position) {
    	Key key = new Key(new Position(position.getX(), position.getY()));
    	return key;
    }
    
    /**
     * Create a new Purse.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createPurse(Position position) {
    	Purse purse = new Purse(new Position(position.getX(), position.getY()));
    	return purse;
    }
    
    /**
     * Create a new Macadam.
     * @param position
     * 			the MotionlessElement position.
     * @return the MotionlessElement.
     */
    public static MotionlessElement createMacadam(Position position) {
    	Macadam macadam = new Macadam(new Position(position.getX(), position.getY()));
    	return macadam;
    }
    
    /**
     * Gets the motionlessElement from a symbol.
     * @param symbol
     * 			the motionless element symbol.
     * @param position
     * 			the motionless element position.
     * @return the motionless element.
     */
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