package extravaganza.controls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import extravaganza.controls.MenuSelection.Letter;
import extravaganza.controls.MenuSelection.Option;

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
	
	
	/*
	//private BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
	
	public MenuSelection readInput() {
		try {
			int c = buffer.read();
			Character character = (char) c;
			Option o = MenuSelection.Option.COLOR;
			
			
//			if (character.equals('1')) {
//				//o =  MenuSelection.Option.COLOR;
//			} else (character.equals('2')) {
//				//o = Option.PATTERN;
//			} else (character.equals('3')) {
//				//o = Option.TIMING;
//			}
			String optionStr = String.valueOf(character);
			
			int c2 = buffer.read();
			char character2 = (char) c;
			String letterStr = String.valueOf(character);
			Letter l = MenuSelection.Letter.valueOf(letterStr);
			
//			int c = 0;
//			while((c = buffer.read()) != -1) {
//				char character = (char) c;
//
//				System.out.println(character);
//
//			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
