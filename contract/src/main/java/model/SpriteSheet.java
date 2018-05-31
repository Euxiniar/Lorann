/**
 * <h1>The SpriteSheet.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author Euxiniar
 *
 */
public abstract class SpriteSheet {
	private static BufferedImage spriteSheet = null;
	private static String PATH = "../textures/texture_atlas.png";
	
	private static void loadImage() {
		try {
			SpriteSheet.setSpriteSheet(ImageIO.read(new File(PATH)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void setSpriteSheet(BufferedImage image) {
		SpriteSheet.spriteSheet = image;
	}
	
	public static BufferedImage get() {
		if(spriteSheet == null) {
			SpriteSheet.loadImage();
		}
		return SpriteSheet.spriteSheet;
	}
}
