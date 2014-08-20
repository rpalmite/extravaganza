package extravaganza.midi;

public interface NoteReceiver {
	public void onNote(String key, int note, int octive, int volume);
}
