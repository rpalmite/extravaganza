package extravaganza.controls;

import extravaganza.led.LedController;
import extravaganza.led.LedPattern;
import extravaganza.led.pattern.StripePattern;

public class PatternThread extends Thread {
	private int delayInMilliseconds;
	private LedPattern pattern = new StripePattern(LedController.create());
	private boolean shouldRun;

	public PatternThread() {
		super("Pattern Thread");
		this.delayInMilliseconds = 1000;
		this.shouldRun = true;
	}

	public void run() {
//		for (int count = 1, row = 1; row < 20; row++, count++) {
//			try {
//				System.out.format("Line #%d from %s\n", count, getName());
//				Thread.currentThread().sleep(delay);
//			} catch (InterruptedException ie) {
//				// This would be a surprise.
//			}
//		}
		
		for (int count = 1; shouldRun; count++) {
			try {
				//System.out.format("Line #%d from %s\n", count, getName());
				pattern.preSequence();
				pattern.nextSequence();
				pattern.postSequence();
				
				Thread.currentThread().sleep(delayInMilliseconds);
			} catch (InterruptedException ie) {
				// This would be a surprise.
			}
		}
	}
	
	public synchronized void setPattern(LedPattern pattern) {
		this.pattern = pattern;
	}
	
	public void setDelayInMilliseconds(int delayInMilliseconds) {
		this.delayInMilliseconds = delayInMilliseconds;
	}
	
	public void stopPattern() {
		this.shouldRun = false;
	}


}
