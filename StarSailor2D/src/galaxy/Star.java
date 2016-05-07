package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Star extends PlanetaryBody {
	
	private Color color;
	private Random random;

	public Star(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		random = new Random(seed + name.hashCode());
		getColor();
	}

	@Override
	public void update() {
		incrementAngle(0.0001);
		getXAndY();
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.fillOval(x, y, (int) size, (int) size);
	}

	@Override
	public void generate() {
		
	}
	
	private void getColor(){
		double val = random.nextDouble();
		if(val >= 0 && val < 0.1){
			color = Color.white;
		}else if(val >= 0.1 && val < 0.2){
			color = Color.white;
		}else if(val >= 0.2 && val < 0.3){
			color = Color.white;
		}else if(val >= 0.3 && val < 0.4){
			color = Color.white;
		}else if(val >= 0.4 && val < 0.5){
			color = Color.yellow;
		}else if(val >= 0.5 && val < 0.6){
			color = Color.yellow;
		}else if(val >= 0.6 && val < 0.7){
			color = Color.orange;
		}else if(val >= 0.7 && val < 0.8){
			color = Color.red;
		}else if(val >= 0.8 && val < 0.9){
			color = Color.cyan;
		}else if(val >= 0.9 && val <= 1){
			color = Color.pink;
		}
	}
	
}
