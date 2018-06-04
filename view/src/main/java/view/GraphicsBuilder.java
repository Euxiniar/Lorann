package view;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;

import model.ILorannModel;
import model.element.IElement;
import model.element.Position;
import model.element.mobile.IMonster;
import view.gameFrame.IGraphicsBuilder;

/**
 * <h1>The GraphicsBuilder Class.</h1>
 *
 * @author Charles Agostini / Anatole Couasnon
 * @version 1.0
 */
class GraphicsBuilder implements IGraphicsBuilder {
	private final ILorannModel lorannModel;

	public GraphicsBuilder(final ILorannModel lorannModel) {
		this.lorannModel = lorannModel;
	}

	@Override
	public void applyModelToGraphic(final Graphics graphics) {
		if(lorannModel.getMap() != null && lorannModel.getPlayer() != null && lorannModel.getMonsters() != null) {
	        clearScreen(graphics);
	        buildMapGraph(graphics);
	        drawMonsters(graphics);
	        drawPlayer(graphics);
	        drawSpell(graphics);
	        drawScore(graphics);
	        drawLife(graphics);
	        }

	}
	
	/**
	 * Clear the screen
	 * @param g
	 * to paint on the gamePanel
	 */
	private void clearScreen(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 1000, 800);
	}
	
	/**
	 * draw the map
	 * @param g
	 * to paint on the gamePanel
	 */
	private void buildMapGraph(Graphics g) {
		int x = 0, y = 0;
		Position position = new Position(x,y);
		IElement element;
		
		for(y = 0; y < lorannModel.getMap().getHeight(); y++) {
			for(x = 0; x < lorannModel.getMap().getWidth(); x++) {
				element = lorannModel.getMap().getOnTheMap(new Position(x, y));
				if(element.getIsAlive() == true) {
				g.drawImage(element.getSelectedImage(), element.getPosition().getX()*50, element.getPosition().getY()*50, 50, 50, null);
				}
				position.setX(x + 1);
			}
				position.setY(y + 1);
		}
	}
	
	/**
	 * draw the player
	 * @param g
	 * to paint on the gamePanel
	 */
	private void drawPlayer(Graphics g) {
		if (lorannModel.getPlayer().getIsAlive() == true)
			g.drawImage(lorannModel.getPlayer().getSelectedImage(), lorannModel.getPlayer().getPosition().getX()*50, lorannModel.getPlayer().getPosition().getY()*50, 50, 50, null);
	}
	
	/**
	 * draw the spell
	 * @param g
	 * to paint on the gamePanel
	 */
	private void drawSpell(Graphics g) {
		if (lorannModel.getSpell().getIsAlive() == true) {
			g.drawImage(lorannModel.getSpell().getSelectedImage(), lorannModel.getSpell().getPosition().getX()*50, lorannModel.getSpell().getPosition().getY()*50, 50, 50, null);
		}
	}
	
	/**
	 * draw all the monsters
	 * @param g
	 * to paint on the gamePanel
	 */
	private void drawMonsters(Graphics g) {
		if(!lorannModel.getMonsters().isEmpty()) {
			for (IMonster monster : lorannModel.getMonsters()) {
				if (monster.getIsAlive() == true) {
					g.drawImage(monster.getSelectedImage(), monster.getPosition().getX()*50, monster.getPosition().getY()*50, 50, 50, null);
				}
			}
		}
	}
	
	/**
	 * draw the score
	 * @param g
	 * to paint on the gamePanel
	 */
	private void drawScore(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString("Score : ", 100, 680);
        font = new Font("Courier", Font.ITALIC, 30);
        g.setFont(font);
        g.setColor(Color.RED);
        g.drawString(String.valueOf(lorannModel.getPlayer().getScore()), 300, 680);
	}
	
	/**
	 * draw the life
	 * @param g
	 * to paint on the gamePanel
	 */
	private void drawLife(Graphics g) {
		Font font = new Font("Courier", Font.BOLD, 30);
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString("Life : ", 650, 680);
        font = new Font("Courier", Font.ITALIC, 30);
        g.setFont(font);
        g.setColor(Color.GREEN);
        g.drawString(String.valueOf(lorannModel.getPlayer().getLife()), 840, 680);
	}
}
