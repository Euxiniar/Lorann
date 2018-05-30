package main;

import java.sql.SQLException;

import controller.ControllerFacade;
import controller.LorannController;
import model.LorannModel;
import model.ModelFacade;
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
        final LorannController controller = new LorannController(new LorannView(), new LorannModel());

        try {
            controller.play();
        } catch (final SQLException exception) {
            exception.printStackTrace();
        }
    }

}
