package extravaganza.controls;

public class MenuSelection {
	public enum Option {
	    COLOR,
	    PATTERN,
	    TIMING
	}
	
	public enum Letter {
		A,B,C,D,E,F,G,H
	}
	
	private Letter l;
	private Option o;
	
	public MenuSelection(Option o, Letter l) {
		this.o = o;
		this.l = l;
	}
}
