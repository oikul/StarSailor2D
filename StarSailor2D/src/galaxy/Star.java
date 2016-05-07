package galaxy;

import java.awt.Graphics2D;

public class Star extends PlanetaryBody {

	public Star(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
	}

	@Override
	public void update() {
		incrementAngle(0.1);
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.fillOval(x, y, width, height);
	}

	@Override
	public void generate() {
		
	}
	
}
