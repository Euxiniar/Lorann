/**
 * <h1>The MotionlessElementFactory.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.motionless;

import model.element.Position;

public abstract class MotionlessElementFactory {

    /** The Constant Skeleton. */
    private static final BallBone ballBone = new BallBone(new Position());
    
    /** The Constant Temple. */
    private static final Door door = new Door(new Position());
    
    /** The Constant Krannox. */
    private static final HorizontalBone horizontalBone = new HorizontalBone(new Position());
    
    /** The Constant Crocrodil. */
    private static final VerticalBone verticalBone = new VerticalBone(new Position());
    
    private static final Key key = new Key(new Position());
    
    private static final Purse purse = new Purse(new Position());
    
    private static final Macadam macadam = new Macadam(new Position());
    
    private static MotionlessElement[] motionlessElements  = {
    		ballBone,
    		door,
    		horizontalBone,
    		verticalBone,
    		key,
    		purse,
    		macadam};
    
    public static MotionlessElement createBallBone(Position position) {
    	ballBone.setPosition(position);
    	return ballBone;
    }
    
    public static MotionlessElement createDoor(Position position) {
    	door.setPosition(position);
    	return door;
    }
    
    public static MotionlessElement createHorizontalBone(Position position) {
    	horizontalBone.setPosition(position);
    	return horizontalBone;
    }
    
    public static MotionlessElement createVerticalBone(Position position) {
    	verticalBone.setPosition(position);
    	return verticalBone;
    }
    
    public static MotionlessElement createKey(Position position) {
    	key.setPosition(position);
    	return key;
    }
    
    public static MotionlessElement createPurse(Position position) {
    	purse.setPosition(position);
    	return purse;
    }
    
    public static MotionlessElement createMacadam(Position position) {
    	macadam.setPosition(position);
    	return purse;
    }
    
    public static MotionlessElement getFromSymbol(char symbol, Position position) {
    	for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSymbol() == symbol) {
            	motionlessElement.setPosition(position);
                return motionlessElement;
            }
        }
    	return null;
    }
}