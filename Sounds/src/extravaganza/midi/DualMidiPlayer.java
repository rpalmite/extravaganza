package extravaganza.midi;
import java.net.URL;
import java.util.Locale;
import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.Transmitter;
import javax.swing.JOptionPane;
//import org.apache.commons.lang.StringUtils;

class DualMidiPlayer {

    public static boolean useExternalSynth = false;

    public static void main(String[] args) throws Exception {
        MidiDevice receivingDevice = getReceivingDevice();
        receivingDevice.open();

        URL url1 = new URL("http://pscode.org/media/EverLove.mid");

        Sequence sequence1 = MidiSystem.getSequence(url1);
        Sequencer sequencer1 = MidiSystem.getSequencer(false);
        Transmitter tx1 = sequencer1.getTransmitter();
        Receiver rx1 = receivingDevice.getReceiver();
        tx1.setReceiver(rx1);

        sequencer1.open();
        sequencer1.setSequence(sequence1);

        URL url2 = new URL("http://pscode.org/media/AftrMdnt.mid");

        Sequence sequence2 = MidiSystem.getSequence(url2);
        Sequencer sequencer2 = MidiSystem.getSequencer(false);
        Transmitter tx2 = sequencer2.getTransmitter();
        Receiver rx2 = receivingDevice.getReceiver();
        tx2.setReceiver(rx2);

        sequencer2.open();
        sequencer2.setSequence(sequence2);

        sequencer1.start();
        JOptionPane.showMessageDialog(null, "Everlasting Love");
        sequencer2.start();
        JOptionPane.showMessageDialog(null, "After Midnight");
    }

    private static MidiDevice getReceivingDevice()
        throws MidiUnavailableException {
        for (MidiDevice.Info mdi: MidiSystem.getMidiDeviceInfo()) {
            MidiDevice dev = MidiSystem.getMidiDevice(mdi);
            if (dev.getMaxReceivers() != 0) {
                String lcName = mdi.getName();
//                    StringUtils.defaultString(mdi.getName())
//                               .toLowerCase(Locale.ENGLISH);
                if (lcName.contains(useExternalSynth? "usb": "java")) {
                    return dev;
                }
            }
        }
        return null;
    }

}