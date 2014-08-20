import java.io.File;
import java.net.URI;
import java.net.URL;

//import javax.media.Format;
//import javax.media.Manager;
//import javax.media.MediaLocator;
//import javax.media.Player;
//import javax.media.PlugInManager;
//import javax.media.format.AudioFormat;

public class AudioTest {
	/*
	public static void main(String[] args) {
		Format input1 = new AudioFormat(AudioFormat.MPEGLAYER3);
		Format input2 = new AudioFormat(AudioFormat.MPEG);
		Format output = new AudioFormat(AudioFormat.LINEAR);
		
		PlugInManager.addPlugIn(
			"com.sun.media.codec.audio.mp3.JavaDecoder",
			new Format[]{input1, input2},
			new Format[]{output},
			PlugInManager.CODEC
		);
		
		try {
//			Player player = Manager.createPlayer(new MediaLocator(new File("data/audioFiles/dusche.mp3").toURI().toURL()));
			File mp3File = new File("/Users/russell/Documents/workspaces/sound/Sounds/sounds/songs/misc/502.mp3");
			URI mp3Uri = mp3File.toURI();
			URL mp3URL = mp3Uri.toURL();
			Player player = Manager.createPlayer(new MediaLocator(mp3URL));
			player.start();
			Thread.sleep(100);
			player.getGainControl().setLevel(.01f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.02f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.03f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.04f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.05f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.06f);
			Thread.sleep(100);
			player.getGainControl().setLevel(.07f);
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	 */
}