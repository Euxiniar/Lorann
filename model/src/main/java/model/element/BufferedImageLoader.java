package model.element;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * <h1>The BufferedImageLoader Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class BufferedImageLoader {
	
	private BufferedImage image;
	private boolean imageLoaded = false;
	
	public BufferedImageLoader(String path) throws IOException {
		this.loadImage(path);
	}
	
	public void loadImage(String path) throws IOException {
		
		this.setBufferedImage(ImageIO.read(new File(path)));
		
		this.setImageLoaded(true);
	}
	
	public boolean isImageLoaded() {
		return this.imageLoaded;
	}
	
	private void setImageLoaded(boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}
	
	public BufferedImage getBufferedImage() {
		return this.image;
	}
	
	private void setBufferedImage(BufferedImage image) {
		this.image = image;
	}
}