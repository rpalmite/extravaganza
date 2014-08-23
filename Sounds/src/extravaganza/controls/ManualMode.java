package extravaganza.controls;

import extravaganza.led.LedController;
import extravaganza.led.LedStrip;

public class ManualMode implements Mode {
	private LedController ledController = LedController.create();
	private LedStrip currentStrip = ledController.getStrip(1);
	
	@Override
	public boolean setOption(char option, int value) {
		if (option == 's') {
			if (value >= 0 && value < 5) {
				currentStrip = ledController.getStrip(value);
			} else {
				return false;
			}
		} else if (option == 'r') {
			currentStrip.setRed(value);
		} else if (option == 'g') {
			currentStrip.setGreen(value);
		} else if (option == 'b') {
			currentStrip.setBlue(value);
		}
		return true;
	}

	@Override
	public String getName() {
		return "manual";
	}

	@Override
	public char[] getOptions() {
		return new char[] { 's', 'r', 'g', 'b' };
	}

	@Override
	public void start() {
		currentStrip.setRed(100);
		currentStrip.setGreen(100);
		currentStrip.setBlue(100);
	}

	@Override
	public void stop() {
		currentStrip.setRed(0);
		currentStrip.setGreen(0);
		currentStrip.setBlue(0);
	}

}
