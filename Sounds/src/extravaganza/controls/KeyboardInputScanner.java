package extravaganza.controls;

import java.util.Scanner;

public class KeyboardInputScanner {
	private Scanner scanner = new Scanner(System.in);
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		scanner.close();
	}

	public int readMode() {
		try {
			// TODO read next line
			// convert that line to an int
			int mode = scanner.nextInt();
			return mode;
		} catch (Exception e) {
			return -1;
		}
	}

	public boolean hasMoreInput() {
		return scanner.hasNext();
	}

	public char readOption() {
		try {
			char c = scanner.next(".").charAt(0);
			return c;
		} catch (Exception e) {
			return '0';
		}
	}

	public int readValue() {
		try {
			int value = scanner.nextInt();
			return value;
		} catch (Exception e) {
			return -1;
		}
	}
}
