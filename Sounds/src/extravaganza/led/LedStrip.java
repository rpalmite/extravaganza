package extravaganza.led;

public class LedStrip {
	int redGpioPin;
	int greenGpioPin;
	int blueGpioPin;
	int red;
	int green;
	int blue;

	public LedStrip(int redGpioPin, int greenGpioPin, int blueGpioPin) {
		this.redGpioPin = redGpioPin;
		this.greenGpioPin = greenGpioPin;
		this.blueGpioPin = blueGpioPin;
	}

	// percentage red, percentage green, percentage blue
	public void setColor(int red, int green, int blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	public void setColor(Color color) {
		setRed(color.getRed());
		setGreen(color.getGreen());
		setBlue(color.getBlue());
	}
	
	public void setRed(int red) {
		this.red = red;
		PiBlaster.set(this.redGpioPin, red);
	}
	
	public void setGreen(int green) {
		this.green = green;
		PiBlaster.set(this.greenGpioPin, green);
	}

	public void setBlue(int blue) {
		this.blue = blue;
		PiBlaster.set(this.blueGpioPin, blue);
	}
	
	public Color getColor() {
		return Color.create(red, green, blue);
	}
}
