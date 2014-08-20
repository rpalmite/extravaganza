package extravaganza.midi;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.SysexMessage;


public class MyMidiReceiver implements Receiver {
	private Receiver orgin;
	private NoteReceiver noteReceiver;
	private static final String[] sm_astrKeyNames = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

	public MyMidiReceiver(Receiver orgin, NoteReceiver noteReceiver) {
		this.orgin = orgin;
		this.noteReceiver = noteReceiver;
	}

	@Override
	public void close() {
		this.close();
	}

	@Override
	public void send(MidiMessage message, long timeStamp) {
//		String messageStr = "";
//		byte[] messageBytes = message.getMessage();
//		for (byte b : messageBytes) {
//			messageStr += String.valueOf(b) + " ";
//		}
		
		if (message instanceof ShortMessage)
		{
			ShortMessage shortMessage = (ShortMessage) message;
			
			// if command is note on
			if (shortMessage.getCommand() == 0x90) {
				String key;
				int octive = 0;
				int note = 0;
				int nKeyNumber = shortMessage.getData1();
				if (nKeyNumber > 127)
				{
					key = "N/A"; // illegal value
				}
				else
				{
					int	nNote = nKeyNumber % 12;
					int	nOctave = nKeyNumber / 12;
					key = sm_astrKeyNames[nNote] + (nOctave - 1);
					note = nNote;
					octive = nOctave;
				}
				
				int volume = shortMessage.getData2();
				
				onNote(key, note, octive, volume);
			}
			
		}
//		else if (message instanceof SysexMessage)
//		{
//			strMessage = decodeMessage((SysexMessage) message);
//		}
//		else if (message instanceof MetaMessage)
//		{
//			strMessage = decodeMessage((MetaMessage) message);
//		}
//		else
//		{
//			strMessage = "unknown message type";
//		}
		
		this.orgin.send(message, timeStamp);
	}
	
	
	public void onNote(String key, int note, int octive, int volume) {
		noteReceiver.onNote(key, note, octive, volume);
	}

}
