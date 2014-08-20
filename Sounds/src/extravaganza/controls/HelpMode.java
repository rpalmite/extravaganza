package extravaganza.controls;

import extravaganza.speech.Speech;

public class HelpMode implements Mode {

	@Override
	public void start() {
		Speech.speak("Modes: 0 for help mode. 1 for manual mode. 2 for sequence mode.");
	}

	@Override
	public void stop() {
		
	}

	@Override
	public boolean setOption(char charValue, int value) {
		return false;
	}

	@Override
	public String getName() {
		return "help";
	}

	@Override
	public char[] getOptions() {
		return new char[] { };
	}

}
