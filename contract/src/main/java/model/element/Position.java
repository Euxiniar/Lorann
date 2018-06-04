/**
 * <h1>The Position.java Class.</h1>
 *
 * @author Charles Agostini
 * @version 1.0
 */
package model.element;

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
	
	/**
	 * Sets the element position.
	 * @param x
	 * 			the x coordinate.
	 * @param y
	 * 			the y coordinate.
	 */
	public void setPosition(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	/*
	 * Create a default position, at coordinates x = 0, y = 0. 
	 */
	public Position() {
		this.x = 0;
		this.y = 0;
	}
	
	/**
	 * Create a position with defined coordinates.
	 * @param x
	 * 			the x coordinate. 
	 * @param y
	 * 			the y coordinate.
	 */
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
