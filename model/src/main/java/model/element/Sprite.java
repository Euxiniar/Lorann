package model.element;

import java.awt.image.BufferedImage;

/**
 * <h1>The Sprite Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Sprite {
	private BufferedImage image;
	private char symbol;
	
	public Sprite(char character, BufferedImage spriteSheet, int xPos, int yPos) {
		this(character, spriteSheet, xPos, yPos, 32, 32);
	}

	public Sprite(char character, BufferedImage spriteSheet, int xPos, int yPos, int width, int height) {
		this.setConsoleImage(character);
		this.selectImage(spriteSheet, xPos, yPos, width, height);
	}
	
	private void selectImage(BufferedImage spriteSheet, int xPos, int yPos, int width, int height) {
		BufferedImage image = spriteSheet.getSubimage((xPos * 34), (yPos * 33), width, height);
		setImage(image);
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	private void setImage(BufferedImage image) {
		this.image = image;
	}
	
	private void setConsoleImage(char consoleImage) {
		this.symbol = consoleImage;
	}
}
