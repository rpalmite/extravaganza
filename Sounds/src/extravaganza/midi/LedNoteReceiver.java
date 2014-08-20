package extravaganza.midi;

import extravaganza.led.LedController;

public class LedNoteReceiver implements NoteReceiver {
	private LedController ledController = LedController.create();

	@Override
	public void onNote(String key, int note, int octive, int volume) {
		ledController.blink();
	}

}
