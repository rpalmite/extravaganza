package extravaganza.led;

public abstract class SequencedLedPattern extends LedPattern {
	private int sequence = 0;
	private int iteration = 0;

	public SequencedLedPattern(LedController ledController) {
		super(ledController);
	}
	
	public void preSequence() {
		
	}
	
	public void postSequence() {
		sequence++;
		if (sequence > getStripCount()) {
			iteration++;
			sequence = sequence % getStripCount();
		}
	}
	
	protected int getIteration() {
		return iteration;
	}
	
	protected int getSequence() {
		return sequence;
	}

}
