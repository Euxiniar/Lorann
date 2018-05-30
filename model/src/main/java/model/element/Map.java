/**
 * <h1>The Map.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element;

/**
 * @author Euxiniar
 *
 */
public class Map {
	private static int WIDTH = 20;
	private static int HEIGHT = 16;
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
}
