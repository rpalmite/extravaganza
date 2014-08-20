package extravaganza.led;

public abstract class LedPattern {
	private LedController ledController;

	public LedPattern(LedController ledController) {
		this.ledController = ledController;
	}
	
	public abstract void preSequence();
	
	public abstract void nextSequence();
	
	public abstract void postSequence();
	
	public LedStrip getStrip(int index) {
		return ledController.getStrip(index);
	}
	
	public int getStripCount() {
		return ledController.getStripCount();
	}

}
