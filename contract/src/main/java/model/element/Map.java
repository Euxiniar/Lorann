package model.element;

/**
 * <h1>The Map Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
public class Map {
	/**
	 * the width.
	 */
	private static int WIDTH = 20;    
	/**
	 * the height.
	 */
	private static int HEIGHT = 13;
	/**
	 * the element array.
	 */
	private IElement[][] map;
	
	/**
	 * Generate the map with default coordinates.
	 */
	public Map() {
		this(WIDTH, HEIGHT);
	}
	
	/**
	 * Generate the map with selected coordinates.
	 * @param width
	 * 			the width.
	 * @param height
	 * 			the height.
	 */
	public Map(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		map = new IElement[WIDTH][HEIGHT];
	}
	
	
	/**
	 * Sets an IElement on the map.
	 * @param element
	 * 			the element.
	 * @param position
	 * 			the element position.
	 */
	public void setOnTheMap(IElement element, Position position) {
		map[position.getX()][position.getY()] = element;
	}
	
	/**
	 * Gets the IElement at a defined position.
	 * @param position
	 * 			the position.
	 * @return the IElement.
	 */
	public IElement getOnTheMap(Position position) {
		if((position.getX() < 0 || position.getX() >= WIDTH) && (position.getY() < 0 || position.getY() >= HEIGHT)) {
			try {
				throw new Exception("Position out of range");
			} catch (Exception e) {
			}
		}
		return map[position.getX()][position.getY()];
	}
	
	/**
	 * @deprecated Gets the IElement at a defined position. 
	 * Prefer to use {@link #getOnTheMap(Position position)} 
	 * @param x
	 * 			the x position.
	 * @param y
	 * 			the y position.
	 * @return the IElement.
	 */
	public IElement getOnTheMap(int x, int y) {
		return map[x][y];
	}
	
	/**
	 * Gets the map.
	 * @return the IElement array.
	 */
	public IElement[][] getMap() {
		return this.map;
	}

	/**
	 * Gets the height.
	 * @return the height.
	 */
	public int getHeight() {
		return HEIGHT;
	}

	/**
	 * Gets the width.
	 * @return the width.
	 */
	public int getWidth() {
		return WIDTH;
	}
}
