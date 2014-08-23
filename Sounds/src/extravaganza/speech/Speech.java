package extravaganza.speech;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Speech {

	private static final String VOICENAME_kevin = "kevin";
	private String text; // string to speech

	public Speech(String text) {
		this.text = text;
	}

	public void speak() {
		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();
		voice = voiceManager.getVoice(VOICENAME_kevin);
		voice.allocate();
		voice.speak(text);
	}
	
	public static void speak(String text) {
		new Speech(text).speak();
	}

	public static void main(String[] args) {
		String text = "FreeTTS was written by the Sun Microsystems Laboratories "
				+ "Speech Team and is based on CMU's Flite engine.";
		Speech freeTTS = new Speech(text);
		freeTTS.speak();
	}

	public static void speakError(Exception e) {
		e.printStackTrace();
		Speech.speak(e.getMessage());
	}
}