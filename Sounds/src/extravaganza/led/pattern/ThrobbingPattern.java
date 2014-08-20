package extravaganza.led.pattern;

import extravaganza.led.LedController;
import extravaganza.led.Color;
import extravaganza.led.LedStrip;
import extravaganza.led.SequencedLedPattern;

public class ThrobbingPattern extends SequencedLedPattern {
	private Color[] colors = new Color[] {
		Color.red(),
		Color.black(),
		Color.blue(),
		Color.green(),
		Color.create(25, 15, 35)
	};
	
	private boolean makeLighter = false;
	
	public ThrobbingPattern(LedController ledController) {
		super(ledController);
	}

	@Override
	public void nextSequence() {
		for (int i=0;i<getStripCount();i++) {
			Color currentColor = colors[i % colors.length]; // one color per strip
			
			int intensity = getIteration() % 100; // new intensity 0%-100%
			
			if (intensity == 0) {
				makeLighter = !makeLighter;
			}
			
			if (makeLighter) {
				currentColor.lighten(1);
			} else {
				currentColor.darken(1);
			}
			
			LedStrip currentStrip = getStrip(i);
			currentStrip.setColor(currentColor);
		}
	}

}