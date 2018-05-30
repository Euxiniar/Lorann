/**
 * <h1>The MonsterFactory.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Position;

/**
 * @author Euxiniar
 *
 */
public abstract class MonsterFactory {

    /** The Constant Skeleton. */
    private static final Skeleton skeleton = new Skeleton(new Position());
    
    /** The Constant Temple. */
    private static final Temple temple = new Temple(new Position());
    
    /** The Constant Krannox. */
    private static final Krannox krannox = new Krannox(new Position());
    
    /** The Constant Crocrodil. */
    private static final Crocrodil crocrodil = new Crocrodil(new Position());
    
    private static Monster[] monsters  = {
    		skeleton,
    		temple,
    		krannox,
    		crocrodil};
    
    public static Monster createSkeleton(Position position) {
    	skeleton.setPosition(position);
    	return skeleton;
    }
    
    public static Monster createTemple(Position position) {
    	temple.setPosition(position);
    	return temple;
    }
    
    public static Monster createKrannox(Position position) {
    	krannox.setPosition(position);
    	return krannox;
    }
    
    public static Monster createCrocrodil(Position position) {
    	crocrodil.setPosition(position);
    	return crocrodil;
    }
    
    public static Monster getFromSymbol(char symbol, Position position) {
    	for (final Monster monster : monsters) {
            if (monster.getSymbol() == symbol) {
            	monster.setPosition(position);
                return monster;
            }
        }
    	return null;
    }
}