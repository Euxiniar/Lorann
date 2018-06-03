package model.element.mobile;

import model.element.Position;

/**
 * <h1>The MonsterFactory.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class MonsterFactory {
  
	/**
	 * Creates a Skeleton
	 * @param position
	 * 			the monster position.
	 * @return the Monster.
	 */
    public static Monster createSkeleton(Position position) {
    	Skeleton skeleton = new Skeleton(new Position(position.getX(), position.getY()));
    	return skeleton;
    }
    
    /**
	 * Creates a Temple.
	 * @param position
	 * 			the monster position.
	 * @return the Monster.
	 */
    public static Monster createTemple(Position position) {
    	Temple temple = new Temple(new Position(position.getX(), position.getY()));
    	return temple;
    }
    
    /**
	 * Creates a Krannox.
	 * @param position
	 * 			the monster position.
	 * @return the Monster.
	 */
    public static Monster createKrannox(Position position) {
    	Krannox krannox = new Krannox(new Position(position.getX(), position.getY()));
    	return krannox;
    }
    
    /**
	 * Creates a Crocrodil
	 * @param position
	 * 			the monster position.
	 * @return the Monster.
	 */
    public static Monster createCrocrodil(Position position) {
    	Crocrodil crocrodil = new Crocrodil(new Position(position.getX(), position.getY()));
    	return crocrodil;
    }
    
    /**
     * Creates a monster thanks to the symbol.
     * @param symbol
     * 			the symbol.
     * @param position
     * 			the monster position.
     * @return the Monster.
     */
    public static Monster getFromSymbol(char symbol, Position position) {
    	
		switch(symbol) {
		case '1' :
			return createSkeleton(position);
		case '2' :
			return createKrannox(position);
		case '3' :
			return createCrocrodil(position);
		case '4' :
			return createTemple(position);
		default : 
			return null;
		}
    }
}