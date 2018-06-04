package model.element;

import java.awt.image.BufferedImage;

import model.SpriteSheet;

/**
 * <h1>The Sprite Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Sprite {
	/**
	 * The sprite image.
	 */
	private BufferedImage image;
	/**
	 * The element symbol.
	 */
	private char symbol;
	
	/**
	 * Create a sprite with defined symbol, 
	 * x position on the map,  and y position on the map.
	 * The image will have default width = 32 and height = 32.
	 * @param symbol
	 * 			the element symbol.
	 * @param xPos
	 * 			the x position on the map.
	 * @param yPos
	 * 			the y position on the map.
	 */
	public Sprite(char symbol, int xPos, int yPos) {
		this(symbol, xPos, yPos, 32, 32);
	}

	/**
	 * Create a sprite with an associated symbol, an x position on the SpriteSheet, a y position on the 
	 * SpriteSheet, a width, and a height.
	 * @see model.SpriteSheet
	 * @param symbol
	 * 			the symbol.
	 * @param xPos
	 * 			the x position on the spriteSheet.
	 * @param yPos
	 * 			the y position on the spriteSheet.
	 * @param width
	 * 			the image width.
	 * @param height
	 * 			the image height.
	 */
	public Sprite(char symbol, int xPos, int yPos, int width, int height) {
		this.setSymbol(symbol);	
		this.selectImage(SpriteSheet.get(), xPos, yPos, width, height);
	}
	
	/**
	 * Select the image to use.
	 * @param spriteSheet
	 * 			the SpriteSheet.
	 * @param xPos
	 * 			the x position.
	 * @param yPos
	 * 			the y position.
	 * @param width
	 * 			the image width.
	 * @param height
	 * 			the image height.
	 */
	private void selectImage(BufferedImage spriteSheet, int xPos, int yPos, int width, int height) {
		BufferedImage image = spriteSheet.getSubimage((xPos * 35), (yPos * 35), width, height);
		setImage(image);
	}
	
	/**
	 * Gets the image.
	 * @return the image.
	 */
	public BufferedImage getImage() {
		return this.image;
	}
	
	/**
	 * Gets the symbol.
	 * @return the symbol.
	 */
	public char getSymbol() {
		return this.symbol;
	}
	
	/**
	 * Sets the image.
	 * @param image
	 * 			the image.
	 */
	private void setImage(BufferedImage image) {
		this.image = image;
	}
	
	/**
	 * Sets the symbol.
	 * @param symbol
	 * 			the symbol.
	 */
	private void setSymbol(char symbol) {
		this.symbol = symbol;
	}
}
