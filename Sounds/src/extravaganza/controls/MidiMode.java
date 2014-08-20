package extravaganza.controls;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import extravaganza.midi.LedNoteReceiver;
import extravaganza.midi.Midi;
import extravaganza.midi.NoteReceiver;


public class MidiMode implements Mode {
	private static List<String> midiFilesAvailable = new ArrayList<String>();
	private static NoteReceiver ledNoteReceiver = new LedNoteReceiver();
	private Midi currentSong = new Midi("midis/beat16.mid", ledNoteReceiver);
	
	static {
		File folder = new File("midis");
		for (final File fileEntry : folder.listFiles()) {
			midiFilesAvailable.add(fileEntry.getPath());
	    }
	}
	
	@Override
	public boolean setOption(char charValue, int value) {
		if (charValue == 's') {
			if (value > 0 && value < midiFilesAvailable.size()) {
				String song = midiFilesAvailable.get(value);
				stop();
				currentSong = new Midi(song, ledNoteReceiver);
				start();
				System.out.println("chose song " + song);
			} else {
				return false;
			}
		}
		System.out.println("option " + charValue + " set to " + value);
		return true;
	}
	
	@Override
	public String getName() {
		return "midi";
	}
	
	@Override
	public char[] getOptions() {
		return new char[] { 's', 'g', 'a' };
	}

	@Override
	public void start() {
		currentSong.play();
	}

	@Override
	public void stop() {
		currentSong.stop();
	}

}
