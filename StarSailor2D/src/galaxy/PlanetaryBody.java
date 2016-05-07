package galaxy;

import java.awt.Graphics2D;

import utils.InputHandler;
import utils.NameGenerator;

public abstract class PlanetaryBody {
	
	protected double size, distance, angle;
	protected long seed;
	protected int x, y;
	protected String name;
	
	public PlanetaryBody(double size, double distance, double angle, long seed){
		this.size = size;
		this.distance = distance;
		this.angle = angle;
		name = NameGenerator.generateName(3, seed);
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics2D g2d);
	
	public abstract void generate();
	
	public void incrementAngle(double amount){
		if(angle < 360){
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

}
