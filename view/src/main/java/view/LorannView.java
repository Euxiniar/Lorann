package view;

import java.util.Observable;

import javax.swing.JOptionPane;

import GameFrame.GameFrame;
import model.ILorannModel;

@SuppressWarnings("deprecation")
	
public class LorannView implements ILorannView{
	private final GraphicsBuilder graphicsBuilder;
	private final Observable observable;
	private GameFrame gameFrame;
	
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
}