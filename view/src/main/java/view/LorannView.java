package view;

import java.util.Observable;

import javax.swing.JOptionPane;

import model.ILorannModel;
import view.gameFrame.GameFrame;

/**
 * <h1>The LorannView Class.</h1>
 *
 * @author Anatole Couasnon
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class LorannView implements ILorannView{
	/**
	 * the graphicsBuilder
	 */
	private final GraphicsBuilder graphicsBuilder;
	/**
	 * the observable
	 */
	private final Observable observable;
	/**
	 * the gameFrame
	 */
	private GameFrame gameFrame;
	
	/**
	 * The constructor, set the parameters
	 * @param lorannModel
	 * contain all the useful elements 
	 * @param observable
	 * 			the observable.
	 */
	public LorannView(ILorannModel lorannModel , Observable observable ) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(lorannModel);
		this.gameFrame = new GameFrame("Lorann", this.graphicsBuilder, this.observable);
	}

	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void closeAll() {
		this.gameFrame.dispose();
	}

	@Override
	public boolean[] getBools() {
		return this.gameFrame.getBools();
	}
	
	@Override
	public void resetBools() {
		this.gameFrame.resetBools();
	}
	
	/**
	 * Gets the gameFrame.
	 * @return the gameFrame.
	 */
	public GameFrame getGameFrame() {
        return gameFrame;
    }

	/**
	 * Sets the gameFrame.
	 * @param gameFrame
	 * 			the gameFrame.
	 */
    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    /**
     * Sets the bools.
     * @param bools
     * 			the bools.
     */
    public void setBools(boolean[] bools) {
        for (int i = 0; i < bools.length; i++) {
            this.gameFrame.setBool(bools[i], i);
        }
    }
}