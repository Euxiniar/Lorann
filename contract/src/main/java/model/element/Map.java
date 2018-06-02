/**
 * <h1>The Map.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element;

public class Map {
	private static int WIDTH = 20;    
	private static int HEIGHT = 13;
	private IElement[][] map;
	
	public Map() {
		this(WIDTH, HEIGHT);
	}
	
	public Map(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
		map = new IElement[WIDTH][HEIGHT];
	}
	
	public void setOnTheMap(IElement element, Position position) {
		map[position.getX()][position.getY()] = element;
	}
	
	public IElement getOnTheMap(Position position) {
		return map[position.getX()][position.getY()];
	}
	
	public IElement getOnTheMap(int x, int y) {
		return map[x][y];
	}
	
	public IElement[][] getMap() {
		return this.map;
	}

	public int getHeight() {
		return HEIGHT;
	}

	public int getWidth() {
		return WIDTH;
	}
}
