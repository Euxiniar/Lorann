package model.element;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * <h1>The Element Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public abstract class Element implements IElement{
	
	private ArrayList<Sprite> spriteArray;
	private Permeability permeability;
	private int selectedSpriteValue = 0;
	private boolean isAlive = true;
	protected Position position;
	
	public Element(char character, BufferedImage spriteSheet, int xImagePos, int yImagePos, int nbSprites, Permeability permeability) {
		this.setPermability(permeability);
		this.createSpriteArray(character, spriteSheet, xImagePos, yImagePos, nbSprites);
	}
	
	public ArrayList<Sprite> getSpriteArray() {
		return spriteArray;
	}
	
	protected void setSpriteArray(ArrayList<Sprite> spriteArray) {
		this.spriteArray = spriteArray;
	}
	
	public int getSpriteArraySize() {
		return this.spriteArray.size();
	}
	
	public Permeability getPermeability() {
		return permeability;
	}
	
	private void setPermability(Permeability permeability) {
		this.permeability = permeability;
	}
	
	public BufferedImage getSelectedImage() {
		return spriteArray.get(this.selectedSpriteValue).getImage();
	}
	
	public char getSymbol() {
		return spriteArray.get(0).getSymbol();
	}
	
	private void createSpriteArray(char character, BufferedImage spriteSheet, int xPos, int yPos, int nbSprites) {
		ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
		for(int i = 0; i < nbSprites; i++) {
			spriteArray.add(new Sprite(character, spriteSheet, xPos, yPos));
		}
		this.setSpriteArray(spriteArray);
	}

	private int getSelectedSpriteValue() {
		return selectedSpriteValue;
	}

	public void setSelectedSpriteValue(int selectedSpriteValue) {
		this.selectedSpriteValue = selectedSpriteValue;
	}
	
	public Sprite getSelectedSprite() {
		return this.spriteArray.get(this.getSelectedSpriteValue());
	}
	
	public BufferedImage getImage() {
		return this.getSelectedSprite().getImage();
	}

	/**
	 * @return the isAlive
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * @param isAlive the isAlive to set
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void setPosition(int x, int y) {
		position.setPosition(x, y);
	}
	
	public Position getPosition() {
		return position;
	}
}