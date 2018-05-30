/**
 * <h1>The Position.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element;

/**
 * @author Euxiniar
 *
 */
public class Position {
	private int x;
	private int y;
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPosition(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	public Position() {
		
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
