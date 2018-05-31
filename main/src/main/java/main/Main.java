package main;

import controller.LorannController;
import model.LorannModel;

import view.LorannView;

/**
 * <h1>The Class Main.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
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
    	LorannView view = new LorannView(model, model);
    	
        final LorannController controller = new LorannController(view, model);

        controller.play();
    }

}
