package controller;

import model.element.IElement;

public class Animator {
	
	private IElement element;
	
	private volatile boolean running = false;
	
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	
	public Animator(IElement element) {
		this.element = element;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	public void update(long time) {
		if (running) {
			if(time - previousTime >= speed) {
				currentFrame++;
				try { // if the number is greater than bounder then we put the currentFrame to 0
					if(element.getSelectedSpriteValue() >= element.getSpriteArraySize()-1) {
						element.setSelectedSpriteValue(0);
					}
					else {
					element.setSelectedSpriteValue(element.getSelectedSpriteValue()+1);
					}
				}catch(IndexOutOfBoundsException e) {
					element.setSelectedSpriteValue(0);
				}
				previousTime = time;
			}
		}
			
	}
	
	public void start() {
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	
	public void stop() {
		running = false;
	}
	
	public void pause() {
		frameAtPause = currentFrame;
		running = false;
	}
	
	public void resume() {
		currentFrame = frameAtPause;
		running = true;
	}
}
