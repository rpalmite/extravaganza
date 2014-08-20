package extravaganza.led;

import java.util.ArrayList;
import java.util.List;

// TODO new name??? LedStripSet???
public class LedController {
	private static LedController singleton = new LedController();
	private static List<LedStrip> strips = new ArrayList<LedStrip>();
	
	static {
		// GPIO pin mapping B+
		strips.add(new LedStrip(2, 3, 4)); // 0
		strips.add(new LedStrip(17, 27, 22)); // 1
		strips.add(new LedStrip(10, 9, 11)); // 2
		strips.add(new LedStrip(5, 6, 13)); // 3
		strips.add(new LedStrip(16, 20, 21)); // 4
	}
	
	public static LedController create() {
		return singleton;
	}

	public void blink() {
		System.out.println("*** blink ****");
		for (LedStrip strip : strips) {
			strip.setColor(Color.create(0, 0, 25));
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

