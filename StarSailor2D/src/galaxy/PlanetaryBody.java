package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import utils.InputHandler;
import utils.NameGenerator;

public abstract class PlanetaryBody {
	
	protected double size, distance, angle;
	protected long seed;
	protected int x, y, xOffset = 0, yOffset = 0;
	protected String name;
	protected Color color;
	protected boolean generated = false, selected = false;
	
	public PlanetaryBody(double size, double distance, double angle, long seed){
		this.size = size;
		this.distance = distance;
		this.angle = angle;
		name = NameGenerator.generateName(3, seed);
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics2D g2d);
	
	public abstract void generate();
	
	public void panUp(){
		yOffset ++;
	}
	
	public void panLeft(){
		xOffset ++;
	}
	
	public void panDown(){
		yOffset --;
	}
	
	public void panRight(){
		xOffset --;
	}
	
	public void incrementAngle(double amount){
		if(angle < 2 * Math.PI){
			angle += amount;
		}else{
			angle = amount;
		}
	}
	
	public void getXAndY(){
		if(angle >= 0 && angle < 90){
			x = (int) (InputHandler.midPoint.x + distance * Math.cos(angle));
			y = (int) (InputHandler.midPoint.y + distance * Math.sin(angle));
		}else if(angle >= 90 && angle < 180){
			x = (int) (InputHandler.midPoint.x + distance * Math.sin(angle));
			y = (int) (InputHandler.midPoint.y + distance * Math.cos(angle));
		}else if(angle >= 180 && angle < 270){
			x = (int) (InputHandler.midPoint.x + distance * Math.cos(angle));
			y = (int) (InputHandler.midPoint.y + distance * Math.sin(angle));
		}else if(angle >= 270 && angle <= 360){
			x = (int) (InputHandler.midPoint.x + distance * Math.sin(angle));
			y = (int) (InputHandler.midPoint.y + distance * Math.cos(angle));
		}
	}

	public double getSize() {
		return size;
	}

	public double getDistance() {
		return distance;
	}

	public double getAngle() {
		return angle;
	}

	public boolean isGenerated() {
		return generated;
	}

	public void setGenerated(boolean generated) {
		this.generated = generated;
	}

	public Rectangle getRect() {
		return new Rectangle(x, y, (int) size, (int) size);
	}
	
	public Rectangle getRectWithOffset(){
		return new Rectangle(x + xOffset, y + yOffset, (int) size, (int) size);
	}
}
