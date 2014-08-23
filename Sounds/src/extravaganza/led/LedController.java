package extravaganza.led;

import java.util.ArrayList;
import java.util.List;

import extravaganza.speech.Speech;

// TODO new name??? LedStripSet???
public class LedController {
	private static LedController singleton = new LedController();
	private static List<LedStrip> strips = new ArrayList<LedStrip>();
	
	static {
		// GPIO pin mapping B+
		strips.add(new LedStrip(25, 24, 23)); // 0
		strips.add(new LedStrip(4, 17, 22)); // 1
		strips.add(new LedStrip(10, 9, 11)); // 2
		strips.add(new LedStrip(5, 6, 13)); // 3
		strips.add(new LedStrip(16, 20, 21)); // 4
	}
	
	public static LedController create() {
		return singleton;
	}

	public void blink() {
		for (LedStrip strip : strips) {
			Color old = strip.getColor();
			strip.setColor(Color.create(0, 0, 0));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				Speech.speakError(e);
			}
			strip.setColor(old);
		}
	}
	
	public LedStrip getStrip(int number) {
		// TODO check number range
		return LedController.strips.get(number);
	}
	
	public void swap(int fromStrip, int toStrip) {
		// TODO check number range
		LedStrip from = LedController.strips.get(fromStrip);
		
	}

	public int getStripCount() {
		return strips.size();
	}
	
}

