package extravaganza.controls;

import java.util.ArrayList;
import java.util.List;

import extravaganza.led.LedController;
import extravaganza.speech.Speech;

// 0 = help
// 1 = pattern (striped, alternating, random, wer)
// patterns apply to individual strips!!!
// 2 = color (all red, all blue, reds, blues, greens, random, all alternating, single alternating)
// 3 = controller (single speed, midi beats, mp3 wave-alizer, plain jane) -- mode?
// controller = midi, moving color, alternating color, solid color
// (when it changes)
// controllers apply to all the strips!!!

// 4 = timer (every 100ms, 500ms, 3s, gets faster, gets slower, random)

public class Menu {
	
	private Mode[] modes = new Mode[] {
		new HelpMode(),
		new ManualMode(),
		new SequenceMode(),
		new MidiMode()
	};
	
	private KeyboardInputScanner input = new KeyboardInputScanner();
	private LedController ledController = LedController.create();
	private Mode currentMode = new HelpMode();
	
	public static void main(String[] args) {
		Menu m = new Menu();
		m.output("Music. Lights. Extravaganza.");
		System.out.println("(0 for help)");
		m.takeInput();
	}

	public void takeInput() {

		while (input.hasMoreInput()) {
			
			int modeIndex = input.readMode();
			
			boolean modeIsValid = modeIndex >= 0 && (modeIndex < modes.length);
			if (modeIsValid) {
				ledController.blink();
				
				currentMode.stop();
				currentMode = modes[modeIndex];
				output("selected mode " + currentMode.getName()); // mode.getName()
				currentMode.start();
				
				while (input.hasMoreInput()) {
					char option = input.readOption();
					
					List<Character> availableOptions = getAvailableOptions(currentMode);
					boolean isValidOption = !availableOptions.contains(new Character(option));
					
					if (option == '<') {
						ledController.blink();
						break;
					} else if (option == '0') {
						output("invalid input received for option");
					} else if (isValidOption) {
						output("option " + option + " is not valid for mode " + currentMode.getName());
					} else {
						// good option selected
						ledController.blink();
						int value = input.readValue();
						
						if (value > 0) {
							ledController.blink();
							boolean optionSet = currentMode.setOption(option, value);
							
							if (!optionSet) {
								output("invalid value " + value + " for option " + option);
							}
						} else {
							output("invalid value specified for option " + option);
						}
					}
				}
			} else {
				output("invalid mode selected");
			}
	
		}
		
		System.out.println("Exiting");
	}

	private List<Character> getAvailableOptions(Mode mode) {
		List<Character> availableOptions = new ArrayList<Character>();
	    for (char c : mode.getOptions()) {
	    	availableOptions.add(c);
	    }
	    return availableOptions;
	}

	private void output(String string) {
		System.out.println(string);
		
		Speech s = new Speech(string);
		s.speak();
	}

//	private void diagnosticMode() {
//		giveMenuSelection("diagnostic mode");
//		// one preprogrammed sequence
//	}
//
//	private void helpMode() {
//		giveMenuSelection("help mode");
//	}
//
//	private void mp3Mode() {
//		giveMenuSelection("mp3 mode");
//
//	}
//
//	private void midiMode() {
//		giveMenuSelection("midi mode");
//
//	}

//	private void sequenceMode() {
//		giveMenuSelection("sequence mode");
//		
//		// [P]attern
//		// -- 1 = all changing
//		// -- 2 = following
//		// -- 3 = skipping
//		// -- 4 = random
//		// -- 5 = 5
//		
//		// change speed
//		// -- f = 100ms
//		// -- g = 500ms
//		// -- h = 1s
//		// -- i = 2s
//		// -- j = 3s
//		// -- k = 5s
//		// -- l = 10s
//		// -- m = 30s
//		// -- n = 1m
//		
//		// blue
//		// -- r = 0%
//		// -- s = 20%
//		// -- t = 40%
//		// -- u = 60%
//		// -- v = 80%
//		// -- w = 100%
//		
//		// x
//		// y
//		// z
//		
//		
//		
//		// color
//		// -- all one color
//		// -- rainbow
//		// -- hues of same color
//		// aaa = black, zzz = white
//		
//		// speed
//		// -- a = slow, z = fast
//	}
//
//	private void manualMode() {
//		System.out.println("Manual Control Mode");
//
//		// strip
//		// -- a = 1
//		// -- b = 2
//		// -- c = 3
//		// -- d = 4
//		// -- e = 5
//		
//		// red
//		// -- f = 0%
//		// -- g = 20%
//		// -- h = 40%
//		// -- i = 60%
//		// -- j = 80%
//		// -- k = 100%
//
//		// green
//		// -- l = 0%
//		// -- m = 20%
//		// -- n = 40%
//		// -- o = 60%
//		// -- p = 80%
//		// -- q = 100%
//		
//		// blue
//		// -- r = 0%
//		// -- s = 20%
//		// -- t = 40%
//		// -- u = 60%
//		// -- v = 80%
//		// -- w = 100%
//		
//		// x
//		// y
//		// z
//	}
//
//	private void help() {
//		// TODO Auto-generated method stub
//
//	}

}
