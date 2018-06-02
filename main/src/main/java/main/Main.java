package main;

import controller.LorannController;
import model.LorannModel;

import view.LorannView;

/**
 * <h1>The Main.java Class.</h1>
 *
 * @author Charles Agostini / Vicente Vaz / Anatole Couasnon / Louis Marjolet
 * @version 1.0
 */
public abstract class Main {

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(final String[] args) {
    	
    	LorannModel model = new LorannModel();
    	LorannView view = new LorannView( model, model);
    	final LorannController controller = new LorannController(view, model);
    	
        controller.play();
    }

}
