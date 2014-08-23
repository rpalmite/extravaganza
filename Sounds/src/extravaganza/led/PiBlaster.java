package extravaganza.led;

import java.io.IOException;

import com.pi4j.wiringpi.SoftPwm;

import extravaganza.speech.Speech;

public class PiBlaster {
	
	private static String output = "console";
	
	public static void setOutput(String output) {
		PiBlaster.output = output;
		if (output.equals("pi4j")) {
			// initialize wiringPi library 
			com.pi4j.wiringpi.Gpio.wiringPiSetup();
			// create soft-pwm pins (min=0 ; max=100) 
			SoftPwm.softPwmCreate(1, 0, 100);
		} else if (output.equals("pi-blaster")) {
			try {
				Process tr = Runtime.getRuntime().exec( new String[] { "pi-blaster" } );
			} catch (IOException e) {
				Speech.speakError(e);
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		
  
//        // continuous loop 
//        while (true) {             
//            // fade LED to fully ON 
//            for (int i = 0; i <= 100; i++) { 
//                SoftPwm.softPwmWrite(1, i); 
//                Thread.sleep(100); 
//            } 
//  
//            // fade LED to fully OFF 
//            for (int i = 100; i >= 0; i--) { 
//                SoftPwm.softPwmWrite(1, i); 
//                Thread.sleep(100); 
//            } 
//        } 
	}
	
	public static void set(int pin, int value) {
		// echo "17=0" > /dev/pi-blaster
		try {
            //SoftPwm.softPwmWrite(1, i); 
			
			if (output.equals("pi4j")) {
				SoftPwm.softPwmWrite(pin, value);
			} else if (output.equals("pi-blaster")) {
				Process tr = Runtime.getRuntime().exec( new String[] { "echo", pin+"="+value, ">", "/dev/pi-blaster" } );
			} else if (output.equals("console")) {
				System.out.println("echo " + pin+"="+value);
			} else {
				System.out.println("missing output");
			}
			
			//System.out.println("echo " + pin+"="+value);
//			Writer wr = new OutputStreamWriter( tr.getOutputStream() );
//			BufferedReader rd = new BufferedReader( new InputStreamReader( tr.getInputStream() ) );
//			wr.write( "hello, world\n" );
//			wr.flush();
//			String s = rd.readLine();
//			System.out.println( s );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
}
