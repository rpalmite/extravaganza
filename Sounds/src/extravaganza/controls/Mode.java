package extravaganza.controls;

public interface Mode {
	
	void start();
	
	void stop();

	boolean setOption(char charValue, int value);

	String getName();

	char[] getOptions();

}
