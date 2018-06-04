package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The SpriteSheet.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class SpriteSheet {
	/**
	 * the spriteSheet.
	 */
	private static BufferedImage spriteSheet = null;
	/**
	 * the spriteSeet path.
	 */
	private static String PATH = "../textures/texture_atlas.png";
	
	/**
	 * loads the Image.
	 */
	private static void loadImage() {
		try {
			SpriteSheet.setSpriteSheet(ImageIO.read(new File(PATH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the image.
	 * @param image
	 * 			the image.
	 */
	private static void setSpriteSheet(BufferedImage image) {
		SpriteSheet.spriteSheet = image;
	}
	
	/**
	 * Gets the SpriteSheet.
	 * @return	the spriteSheet.
	 */
	public static BufferedImage get() {
		if(spriteSheet == null) {
			SpriteSheet.loadImage();
		}
		return SpriteSheet.spriteSheet;
	}
}
