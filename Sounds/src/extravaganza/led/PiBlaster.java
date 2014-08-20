package extravaganza.led;

import java.io.IOException;

public class PiBlaster {
	
	public static void set(int pin, int value) {
		// echo "17=0" > /dev/pi-blaster
		try {
			System.out.println("echo " + pin+"="+value);
			Process tr = Runtime.getRuntime().exec( new String[]{ "echo", pin+"="+value, ">", "/dev/pi-blaster" } );
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
