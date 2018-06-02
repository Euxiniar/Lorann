/**
 * <h1>The MonsterFactory.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element.mobile;

import model.element.Position;

public abstract class MonsterFactory {
  
    public static Monster createSkeleton(Position position) {
    	Skeleton skeleton = new Skeleton(new Position(position.getX(), position.getY()));
    	return skeleton;
    }
    
    public static Monster createTemple(Position position) {
    	Temple temple = new Temple(new Position(position.getX(), position.getY()));
    	return temple;
    }
    
    public static Monster createKrannox(Position position) {
    	Krannox krannox = new Krannox(new Position(position.getX(), position.getY()));
    	return krannox;
    }
    
    public static Monster createCrocrodil(Position position) {
    	Crocrodil crocrodil = new Crocrodil(new Position(position.getX(), position.getY()));
    	return crocrodil;
    }
    
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