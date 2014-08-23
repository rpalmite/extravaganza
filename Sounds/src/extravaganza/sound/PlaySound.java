package extravaganza.sound;
import java.io.File;
import java.io.FileInputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class PlaySound {
	public PlaySound() throws InterruptedException {
		playSound("dogson.wav");
		playSound("lion.wav");
	}
	
	public static void main(String[] args) throws InterruptedException {
		new PlaySound();
		
	}
	
	public static synchronized void playSound(final String path) {
		  new Thread(new Runnable() {
		  // The wrapper thread is unnecessary, unless it blocks on the
		  // Clip finishing; see comments.
		    public void run() {
		      try {
		        Clip clip = AudioSystem.getClip();
		        String current = new java.io.File( "." ).getCanonicalPath();
		        System.out.println(current);
		        File waveFile = new File(path);
		        FileInputStream fileStream = new FileInputStream(waveFile);
		        AudioInputStream inputStream = AudioSystem.getAudioInputStream(fileStream);
		        clip.open(inputStream);
		        clip.start(); 
		      } catch (Exception e) {
		        System.err.println(e.getMessage());
		      }
		    }
		  }).start();
		}
	
}