package model;

import java.awt.image.BufferedImage;

public interface IElement {
	Sprite getSprite();
	Permeability getPermeability();
	BufferedImage getImage();
}
