package model.element.motionless;

import model.element.Element;
import model.element.Permeability;
import model.element.Position;

/**
 * <h1>The MotionlessElement Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class MotionlessElement extends Element {

    MotionlessElement(char symbol, int xImagePos, int yImagePos, int nbSprites, Permeability permeability, Position position) {
        super(symbol, xImagePos, yImagePos, nbSprites, permeability, position);
    }
    
    MotionlessElement(char symbol, int xImagePos, int yImagePos, Permeability permeability, Position position) {
        this(symbol, xImagePos, yImagePos, 1, permeability, position);
    }
}