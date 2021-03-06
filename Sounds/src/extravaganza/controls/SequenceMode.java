package extravaganza.controls;

import extravaganza.led.LedController;
import extravaganza.led.LedPattern;
import extravaganza.led.pattern.PatternEight;
import extravaganza.led.pattern.PatternFive;
import extravaganza.led.pattern.PatternFour;
import extravaganza.led.pattern.PatternNine;
import extravaganza.led.pattern.PatternSeven;
import extravaganza.led.pattern.PatternSix;
import extravaganza.led.pattern.PatternTen;
import extravaganza.led.pattern.RainbowPattern;
import extravaganza.led.pattern.StripePattern;
import extravaganza.led.pattern.ThrobbingPattern;

// Pattern Mode???
public class SequenceMode implements Mode {
	private static final int DELAY_INCREMENT_MS = 100;
	private static final int MIN_DELAY_MS = 0;
	private static final int MAX_DELAY_MS = 300;
	
	private PatternThread currentPattern = new PatternThread();
	private LedController controller = LedController.create();
	
	private LedPattern[] patterns = new LedPattern[] {
		new StripePattern(controller),
		new RainbowPattern(controller),
		new ThrobbingPattern(controller),
		new PatternFour(controller),
		new PatternFive(controller),
		new PatternSix(controller),
		new PatternSeven(controller),
		new PatternEight(controller),
		new PatternNine(controller),
		new PatternTen(controller)
	};
	
	@Override
	public boolean setOption(char option, int value) {
		if (option == 'p') {
			// control a thread
			if (value >= 0 && value < patterns.length) {
				LedPattern pattern = patterns[value];
				this.currentPattern.setPattern(pattern);
			} else {
				return false;
			}
		} else if (option == 's') {
			if (value > MIN_DELAY_MS && value < MAX_DELAY_MS) {
				this.currentPattern.setDelayInMilliseconds(value*DELAY_INCREMENT_MS);
			} else {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String getName() {
		return "pattern";
	}

	@Override
	public char[] getOptions() {
		return new char[] { 'p', 's' };
	}

	@Override
	public void start() {
		this.currentPattern.run();
	}

	@Override
	public void stop() {
		this.currentPattern.stopPattern();
		this.currentPattern.stop();
	}

}
