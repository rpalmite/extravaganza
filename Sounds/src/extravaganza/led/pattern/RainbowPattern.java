package extravaganza.led.pattern;

import extravaganza.led.LedController;
import extravaganza.led.Color;
import extravaganza.led.LedStrip;
import extravaganza.led.SequencedLedPattern;

public class RainbowPattern extends SequencedLedPattern {
	private Color[] colors = new Color[] {
		Color.red(),
		Color.black(),
		Color.blue(),
		Color.green(),
		Color.create(25, 15, 35)
	};
	
	public RainbowPattern(LedController ledController) {
		super(ledController);
	}

	@Override
	public void nextSequence() {
		int numberOfStrips = getStripCount();
		
		for (int i=0;i<numberOfStrips;i++) {
			LedStrip currentStrip = getStrip(i);
			Color stripColor = colors[(i % getSequence()) % colors.length];
			currentStrip.setColor(stripColor);
		}
		
	}

}
