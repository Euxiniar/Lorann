
package controller;

import java.util.ArrayList;

import model.element.IElement;
import model.element.mobile.IMonster;

/**
 * <h1>The Animator Class.</h1>
 *
 * @author Charles Agostini/Anatole Couasnon
 * @version 1.0
 */
public class Animator {
	/**
	 * The element array.
	 */
	private ArrayList<IElement> elementArray = null;
	/**
	 * The monster array.
	 */
	private ArrayList<IMonster> monstersArray = null;
	/**
	 * the running status
	 */
	private volatile boolean running = false;
	/**
	 * the speed, and the previousTime.
	 */
	private long previousTime, speed;
	/**
	 * The frameAtPause, and the currentFrame.
	 */
	private int frameAtPause, currentFrame;
	
	/**
	 * Creates an Animator.
	 * @param element
	 * 			the element to animate.
	 */
	public Animator(IElement element) {
		elementArray = new ArrayList<IElement>();
		this.elementArray.add(element);
	}
	
	/**
	 * Creates an Animator.
	 * @param monsters
	 * 			the monsters to animate.
	 */
	public Animator(ArrayList<IMonster> monsters) {
		this.monstersArray = monsters;
	}

	/**
	 * Sets the speed. The closer the speed is to 0, the faster the elements goes.
	 * @param speed
	 * 			the speed.
	 */
	public void setSpeed(long speed) {
		this.speed = speed;
	}
	
	/**
	 * Update the element sprite to draw.
	 * @param time
	 * 			the current time.
	 */
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
	
	/**
	 * Starts the animation.
	 */
	public void start() {
		running = true;
		previousTime = 0;
		frameAtPause = 0;
		currentFrame = 0;
	}
	
	/**
	 * Stops the animation.
	 */
	public void stop() {
		running = false;
	}
	
	/**
	 * Pauses the animation.
	 */
	public void pause() {
		frameAtPause = currentFrame;
		running = false;
	}
	
	/**
	 * Resume the animation.
	 */
	public void resume() {
		currentFrame = frameAtPause;
		running = true;
	}
}
