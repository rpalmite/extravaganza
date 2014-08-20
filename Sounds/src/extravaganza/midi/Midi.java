package extravaganza.midi;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Synthesizer;
import javax.sound.midi.Transmitter;
import javax.swing.JOptionPane;

import extravaganza.speech.Speech;

public class Midi {

    public static void main(String[] args) throws Exception {
    	// get file
//    	File midi = new File("love_runs_out.mid");
    	//File midi = new File("midis/shakira_dare_la_la_la.mid");
    	//Midi midi = new Midi("midis/ariana_grande-problem_ft_iggy_azalea.mid");
    	Midi midi = new Midi("midis/beat16.mid");
    	midi.play();
    	System.out.println("before");
    	Thread.sleep(1000);
    	System.out.println("after");
    	midi.stop();
    	System.out.println("done");
    }
    
    private File midi;
    private Sequence sequence;
    private Sequencer sequencer;
    
    public Midi(String filePath) {
    	this(filePath, new SysOutNoteReceiver());
    }

    public Midi(String filePath, NoteReceiver noteReceiver) {
    	try {
			midi = new File(filePath);
			sequence = MidiSystem.getSequence(midi);
			
			sequencer = MidiSystem.getSequencer();
			
			 // change receiver(s) for sequencer
			List<Transmitter> transmitters = sequencer.getTransmitters();
			for (Transmitter t : transmitters) {
				Receiver oldReceiver = t.getReceiver();
			    MyMidiReceiver myReceiver = new MyMidiReceiver(oldReceiver, noteReceiver);
			    //DumpReceiver dumpReceiver = new DumpReceiver(System.out);
				t.setReceiver(myReceiver);
			}
		} catch (InvalidMidiDataException e) {
			Speech.speakError(e);
			e.printStackTrace();
		} catch (IOException e) {
			Speech.speakError(e);
			e.printStackTrace();
		} catch (MidiUnavailableException e) {
			Speech.speakError(e);
			e.printStackTrace();
		}
    }
    
    public void play() {
        try {
			sequencer.open();
			sequencer.setSequence(sequence);
			sequencer.start();
		} catch (MidiUnavailableException e) {
			Speech.speakError(e);
			e.printStackTrace();
		} catch (InvalidMidiDataException e) {
			Speech.speakError(e);
			e.printStackTrace();
		}
    }
    
    public void stop() {
    	sequencer.stop();
    }
}