package galaxy;

import java.awt.Graphics2D;

import utils.NameGenerator;

public abstract class PlanetaryBody {
	
	protected double size, distance, angle;
	protected long seed;
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