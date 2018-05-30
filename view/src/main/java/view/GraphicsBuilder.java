package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import GameFrame.IGraphicsBuilder;
import model.ILorannModel;
import model.element.IElement;
import model.element.Map;
import model.element.Position;
import model.element.mobile.IMonster;
import model.element.mobile.Player;
import model.element.mobile.Spell;

class GraphicsBuilder implements IGraphicsBuilder {
	private final ILorannModel lorannModel;
	private BufferedImage mapImage;

	public GraphicsBuilder(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
	}

	@Override
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		buildMapGraph(graphics);
		drawMonsters(graphics);
		drawPlayer(graphics, observer);
		drawSpell(graphics);

	}
	
	private void buildMapGraph(Graphics g) {
		int x = 0, y = 0;
		Position position = new Position(x,y);
		for (IElement[] ligne : lorannModel.getMap().getMap()) {
			for (IElement element : lorannModel.getMap().getMap()[y]) {
				g.drawImage(element.getSelectedImage(), element.getPosition().getX(), element.getPosition().getY(), 50, 50, null);
				position.setX(x + 1);
			}
			position.setY(y + 1);
		}
	}
	
	private void drawPlayer(Graphics g, ImageObserver observer) {

			g.drawImage(lorannModel.getPlayer().getSelectedImage(), lorannModel.getPlayer().getPosition().getX(), lorannModel.getPlayer().getPosition().getY(), 50, 50, null);

	}
	
	private void drawSpell(Graphics g) {

		if (lorannModel.getSpell().getIsAlive() == true) {
			g.drawImage(lorannModel.getPlayer().getSelectedImage(), lorannModel.getPlayer().getPosition().getX(), lorannModel.getPlayer().getPosition().getY(), 50, 50, null);
		}
	}
	
	private void drawMonsters(Graphics g) {
		for (IMonster monster : lorannModel.getMonsters()) {
			if (monster.getIsAlive() == true) {
				g.drawImage(monster.getSelectedImage(), monster.getPosition().getX(), monster.getPosition().getY(), 50, 50, null);
			}
		}
	}

}
