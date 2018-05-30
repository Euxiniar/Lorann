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
	int selectedSpriteValue = 0;
	boolean isAlive = true;
	Position position = new Position();
	ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
	Permeability permeability;
	
	public Element(char symbol, int xImagePos, int yImagePos, int nbSprites, Permeability permeability, Position position) {
		setPosition(position);
		setPermeability(permeability);
		createSpriteArray(symbol, xImagePos, xImagePos, nbSprites);
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getSpriteArray()
	 */
	@Override
	public ArrayList<Sprite> getSpriteArray() {
		return this.spriteArray;
	}
	
	private void setSpriteArray(ArrayList<Sprite> spriteArray) {
		this.spriteArray = spriteArray;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getSpriteArraySize()
	 */
	@Override
	public int getSpriteArraySize() {
		return this.spriteArray.size();
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getPermeability()
	 */
	@Override
	public Permeability getPermeability() {
		return this.permeability;
	}
	
	@Override
	public void setPermeability(Permeability permeability) {
		this.permeability = permeability;
	}

	private Sprite getSelectedSprite() {
		return this.spriteArray.get(selectedSpriteValue);
	}
	
	private void createSpriteArray(char symbol, int xPos, int yPos, int nbSprites) {
		ArrayList<Sprite> spriteArray = new ArrayList<Sprite>();
		for(int i = 0; i < nbSprites; i++) {
			spriteArray.add(new Sprite(symbol, xPos, yPos));
		}
		this.setSpriteArray(spriteArray);
	}
	
	/* (non-Javadoc)
	 * @see model.element.IElement#getSelectedImage()
	 */
	@Override
	public BufferedImage getSelectedImage() {
		return getSelectedSprite().getImage();
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getSymbol()
	 */
	@Override
	public char getSymbol() {
		return this.spriteArray.get(0).getSymbol();
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getSelectedSpriteValue()
	 */
	@Override
	public int getSelectedSpriteValue() {
		return this.selectedSpriteValue;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#setSelectedSpriteValue(int)
	 */
	@Override
	public void setSelectedSpriteValue(int value) {
		this.selectedSpriteValue = value;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#isAlive()
	 */
	@Override
	public boolean getIsAlive() {
		return this.isAlive;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#setAlive(boolean)
	 */
	@Override
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#setPosition(int, int)
	 */
	@Override
	public void setPosition(int x, int y) {
		this.position.setPosition(x, y);
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#setPosition(model.element.Position)
	 */
	@Override
	public void setPosition(Position position) {
		this.position = position;
	}

	/* (non-Javadoc)
	 * @see model.element.IElement#getPosition()
	 */
	@Override
	public Position getPosition() {
		return this.position;
	}
	
	
}