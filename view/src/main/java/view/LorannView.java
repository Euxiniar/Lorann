package view;

import java.util.Observable;

import javax.swing.JOptionPane;

import GameFrame.GameFrame;
import controller.IOrderPerformer;

public class LorannView implements IViewSystem{
	private final GraphicsBuilder graphicsBuilder;
	private final EventPerformer eventPerformer;
	private final Observable observable;
	private GameFrame gameFrame;
	
	public LorannView(final IOrderPerformer orderPerformer, ILorannModel lorannModel , Observable observable ) {
		
	}
	
	private void run() {
		this.gameFrame = new GameFrame("Lorann", this.eventPerformer, this.graphicsBuilder, this.observable);
	}

	@Override
	public void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	@Override
	public void closeAll() {
		this.gameFrame.dispose();
	}
}
	