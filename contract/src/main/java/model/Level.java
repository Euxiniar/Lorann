package model;
/**
 * <h1>The Level.java Class.</h1>
 *
 * @author Vicente Vaz
 * @version 1.0
 */

public class Level {
	/** The id, the height, the width. */
	private int id, height, width;
	/** The code. */
	private String code;
	
	/**
     * Instantiates a new example.
     *
     * @param id
 *          	the id
     * @param code
 *            	the code
     *@param height
 *            	the height
     *@param width
     *			the width
     */
	public Level(int id, String code, int height, int width) {
		setId(id);
		setCode(code);
		setHeight(height);
		setWidth(width);
	}

	/**
     * Gets the id.
     * @return the id.
     */
	public int getId() {
		return id;
	}

	/**
     * Gets the code.
     * @return the code.
     */
	public String getCode() {
		return code;
	}

	/**
     * Sets the id.
     * @param id
     * 			the id.
     */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Sets the code.
	 * @param code
	 * 			the code.
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the height.
	 * @return the height.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height.
	 * @param height
	 *			the height.
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the width
	 * @return the width.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the Width.
	 * @param width
	 * 			the width.
	 */
	public void setWidth(int width) {
		this.width = width;
	}
}
