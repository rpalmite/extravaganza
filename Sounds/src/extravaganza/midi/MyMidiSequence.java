package extravaganza.midi;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;


public class MyMidiSequence extends Sequence {
	
	public MyMidiSequence(Sequence orgin)
			throws InvalidMidiDataException {
		super(orgin.getDivisionType(), orgin.getResolution());
	}

	public MyMidiSequence(float divisionType, int resolution)
			throws InvalidMidiDataException {
		super(divisionType, resolution);
	}

}
