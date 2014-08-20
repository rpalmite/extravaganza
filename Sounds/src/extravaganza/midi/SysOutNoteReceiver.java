package extravaganza.midi;

public class SysOutNoteReceiver implements NoteReceiver {

	@Override
	public void onNote(String key, int note, int octive, int volume) {
		System.out.println("Key: " + key + " Note " + note + " Octive " + octive + " Volume " + volume);
	}

}
