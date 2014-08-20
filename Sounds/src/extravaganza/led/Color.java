package extravaganza.led;

public class Color {
	private int red;
	private int green;
	private int blue;
	private static final int MAX_COLOR_SATURATION = 100;

	private Color(int red, int green, int blue) {
		super();
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public static Color create(int red, int green, int blue) {
		return new Color(red, green, blue);
	}
	
	public static Color red() {
		return new Color(100, 0, 0);
	}
	
	public static Color green() {
		return new Color(0, 100, 0);
	}
	
	public static Color blue() {
		return new Color(0, 0, 100);
	}
	
	public static Color black() {
		return new Color(0, 0, 0);
	}
	
	public static Color white() {
		return new Color(100, 100, 100);
	}

	public int getRed() {
		return red;
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getGreen() {
		return green;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getBlue() {
		return blue;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public void darken(int amount) {
		this.red += amount;
		this.green += amount;
		this.blue += amount;
	}
	
	public void lighten(int amount) {
		this.red -= (red + amount) < MAX_COLOR_SATURATION ? amount : this.red;
		this.green -= (green + amount) < MAX_COLOR_SATURATION ? amount : this.green;
		this.blue -= (blue + amount) < MAX_COLOR_SATURATION ? amount : this.blue;
	}

}
