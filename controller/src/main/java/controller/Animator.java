package controller;

import java.util.ArrayList;

import model.element.IElement;
import model.element.mobile.IMonster;

public class Animator {
	
	private ArrayList<IElement> elementArray = null;
	private ArrayList<IMonster> monstersArray = null;
	private volatile boolean running = false;
	
	private long previousTime, speed;
	private int frameAtPause, currentFrame;
	
	public Animator(IElement element) {
		elementArray = new ArrayList<IElement>();
		this.elementArray.add(element);
	}

	/**
	 * @param monsters
	 */

	
	public Animator(ArrayList<IMonster> monsters) {
		this.monstersArray = monsters;
	}

	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	public void update(long time) {
		if (running) {
			if(time - previousTime >= speed) {
				currentFrame++;
				if(elementArray != null) {
					for(IElement element : elementArray) {
						if(element.getSelectedSpriteValue() >= element.getSpriteArraySize()-1) {
							element.setSelectedSpriteValue(0);
						}
						else {
						element.setSelectedSpriteValue(element.getSelectedSpriteValue()+1);
						}
					}
				}
				else if(monstersArray != null) {
					for(IMonster monster : monstersArray) {
						if(monster.getSelectedSpriteValue() >= monster.getSpriteArraySize()-1) {
							monster.setSelectedSpriteValue(0);
						}
						else {
							monster.setSelectedSpriteValue(monster.getSelectedSpriteValue()+1);
						}
					}
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
