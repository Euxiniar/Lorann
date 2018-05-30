package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

import GameFrame.IGraphicsBuilder;
import model.element.IElement;

class GraphicsBuilder implements IGraphicsBuilder {
	private final ILorannModel lorannModel;
	private BufferedImage mapImage;

	public GraphicsBuilder(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
		this.buildMap();
	}

	@Override
	public void applyModelToGraphic(final Graphics graphics, final ImageObserver observer) {
		buildMap(graphics);

	}
	
	public void buildMap(Graphics g) {
		
	}
	
	public void drawPlayer(Player player, Graphics g, ImageObserver observer) {
		
	}
	
	public void drawSpell(Spell spell, Graphics g) {
		
	}
	
	public void drawMonsters(ArrayList<IMonsters> monsters, Graphics g) {
		
	}

	@Override
	public int getGlobalWidth() {
		return this.lorannModel.getArea().getWidth();
	}

	@Override
	public int getGlobalHeight() {
		return this.lorannModel.getArea().getHeight();
	}

}
