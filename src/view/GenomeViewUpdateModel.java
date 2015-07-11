package view;

/**
 * Dumb object for data only. Generated by the view, used by the controller to alter the model's values.
 * 
 * @author Alex Luckett <lucketta@aston.ac.uk>
 */
public class GenomeViewUpdateModel {
	
	private int red;
	private int green;
	private int blue;
	
	private boolean randomColours;

	public GenomeViewUpdateModel() {
		red = 0;
		green = 0;
		blue = 0;
		randomColours = false;
	}
	
	public void setRed(int value) {
		red = value;
	}
	
	public void setGreen(int value) {
		green = value;
	}
	
	public void setBlue(int value) {
		blue = value;
	}
	
	public void setRandomColours(boolean randomColours) {
		this.randomColours = randomColours;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getRed() {
		return red;
	}
	
	public boolean isRandomColours() {
		return randomColours;
	}

}