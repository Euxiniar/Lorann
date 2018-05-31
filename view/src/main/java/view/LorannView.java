package view;

import java.util.Observable;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import GameFrame.GameFrame;
import controller.IOrderPerformer;
import model.ILorannModel;

@SuppressWarnings("deprecation")
public class LorannView implements ILorannView, Runnable{
	private final GraphicsBuilder graphicsBuilder;
	private final EventPerformer eventPerformer;
	private final Observable observable;
	private GameFrame gameFrame;
	
	public LorannView(final IOrderPerformer orderPerformer, ILorannModel lorannModel , Observable observable ) {
		this.observable = observable;
		this.graphicsBuilder = new GraphicsBuilder(lorannModel);
		this.eventPerformer = new EventPerformer(orderPerformer);
		SwingUtilities.invokeLater(this);
	}
	
	@Override
	public void run() {
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
	