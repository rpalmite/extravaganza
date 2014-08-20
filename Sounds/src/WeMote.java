import java.io.IOException;

/*
import wiiremotej.ButtonMap;
import wiiremotej.WiiRemote;
import wiiremotej.WiiRemoteJ;
import wiiremotej.event.WRAccelerationEvent;
import wiiremotej.event.WRButtonEvent;
import wiiremotej.event.WRIREvent;
import wiiremotej.event.WRNunchukExtensionEvent;
import wiiremotej.event.WRStatusEvent;
import wiiremotej.event.WiiRemoteAdapter;

public class WeMote extends WiiRemoteAdapter {
	public static void main(String[] args) throws IllegalStateException,
			InterruptedException, IOException {
		System.setProperty("bluecove.jsr82.psm_minimum_off", "true");

		System.out.println("Connecting...");
		WiiRemote remote = WiiRemoteJ.findRemote();
		remote.addWiiRemoteListener(new WeMote(remote));
		remote.setAccelerometerEnabled(true);
		remote.setSpeakerEnabled(true);
		remote.setIRSensorEnabled(true, WRIREvent.BASIC);
		remote.setLEDIlluminated(0, true);
		
        remote.getButtonMaps().add(new ButtonMap(WRButtonEvent.HOME, ButtonMap.NUNCHUK, WRNunchukExtensionEvent.C, new int[]{java.awt.event.KeyEvent.VK_CONTROL}, 
                java.awt.event.InputEvent.BUTTON1_MASK, 0, -1));
                        
        final WiiRemote remoteF = remote;
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable(){public void run(){remoteF.disconnect();}}));

	}

	private WiiRemote remote;
	private static int t = 0;
	private static int x = 0;
	private static int y = 0;
	private static int z = 0;

	private static int lastX = 0;
	private static int lastY = 0;
	private static int lastZ = 0;

	public WeMote(WiiRemote remote) {
		this.remote = remote;
	}

	@Override
	public void disconnected() {
		System.out.println("Remote disconnected.");
		System.exit(0);
	}
	
	@Override
	public void statusReported(WRStatusEvent evt) {
		System.out.println("Battery level: " + (double) evt.getBatteryLevel()
				/ 2 + "%");
		System.out.println("Continuous: " + evt.isContinuousEnabled());
		System.out
				.println("Remote continuous: " + remote.isContinuousEnabled());
	}
	
	@Override
	public void accelerationInputReceived(WRAccelerationEvent evt) {
		System.out.println("R: " + evt.getRoll());
		System.out.println("P: " + evt.getPitch());
		
		lastX = x;
		lastY = y;
		lastZ = z;

		x = (int) (evt.getXAcceleration() / 5 * 300) + 300;
		y = (int) (evt.getYAcceleration() / 5 * 300) + 300;
		z = (int) (evt.getZAcceleration() / 5 * 300) + 300;

		t++;

		System.out.println("---Acceleration Data---");
		System.out.println("X: " + evt.getXAcceleration());
		System.out.println("Y: " + evt.getYAcceleration());
		System.out.println("Z: " + evt.getZAcceleration());

	}

}
*/