package extravaganza.led.pattern;

import extravaganza.led.LedController;
import extravaganza.led.Color;
import extravaganza.led.LedStrip;
import extravaganza.led.SequencedLedPattern;

public class StripePattern extends SequencedLedPattern {
	
	public StripePattern(LedController ledController) {
		super(ledController);
	}

	@Override
	public void nextSequence() {
		int numberOfStrips = getStripCount();
		
		for (int i=0;i<numberOfStrips;i++) {
			LedStrip currentStrip = getStrip(i);
			if (i == getSequence()) {
				currentStrip.setColor(Color.red());
			} else {
				currentStrip.setColor(Color.black());
			}
		}
		
	}

}
