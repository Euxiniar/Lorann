/**
 * 
 */
package controller;

import model.element.mobile.MobileElement;
import model.element.motionless.MotionlessElement;

/**
 * @author Snargol
 *
 */
public class ModelToView {
	MotionlessElement[] motionlessElementsPermanent;
	MotionlessElement[] motionlessElementsGrabable;
	MobileElement[] mobilesElements;
	
	public ModelToView(MotionlessElement[] motionlessElementsPermanent, MotionlessElement[] motionlessElementsGrabable, MobileElement[] mobilesElements) {
		this.motionlessElementsPermanent = motionlessElementsPermanent;
		this.motionlessElementsGrabable = motionlessElementsGrabable;
		this.mobilesElements = mobilesElements;
	}
	
	public ModelToView(MotionlessElement[] motionlessElementsGrabable, MobileElement[] mobilesElements) {
		this.motionlessElementsGrabable = motionlessElementsGrabable;
		this.mobilesElements = mobilesElements;
	}
	
	public MotionlessElement[] getMotionlessElementsPermanent() {
		return motionlessElementsPermanent;
	}

	public MotionlessElement[] getMotionlessElementsGrabable() {
		return motionlessElementsGrabable;
	}

	public MobileElement[] getMobilesElements() {
		return mobilesElements;
	}
	
}
