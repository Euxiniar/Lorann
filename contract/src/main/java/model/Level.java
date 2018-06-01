package model;

public class Level {
	private int id, height, width;
	private String code;
	
	public Level(int id, String code, int height, int width) {
		setId(id);
		setCode(code);
		setHeight(height);
		setWidth(width);
	}

	public int getId() {
		return id;
	}

	public String getCode() {
		return code;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}
}
