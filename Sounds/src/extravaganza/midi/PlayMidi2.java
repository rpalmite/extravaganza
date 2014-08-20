package extravaganza.midi;
import java.io.File;

import javax.sound.midi.MidiSystem;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;
import javax.swing.JOptionPane;

class PlayMidi2 {

    public static void main(String[] args) throws Exception {
    	File midi = new File("love_runs_out.mid");

    	Sequence sequence1 = MidiSystem.getSequence(midi);
        Sequencer sequencer1 = MidiSystem.getSequencer(false);
        Transmitter tx1 = sequencer1.getTransmitter();
        //Receiver rx1 = receivingDevice.getReceiver();
        //tx1.setReceiver(rx1);

        sequencer1.open();
        sequencer1.setSequence(sequence1);
        
        
        sequencer1.start();
        
        JOptionPane.showMessageDialog(null, "Everlasting Love");
    
        /////////
        
        
    }
}