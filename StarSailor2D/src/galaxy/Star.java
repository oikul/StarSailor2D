package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

import main.State;
import utils.InputHandler;

public class Star extends PlanetaryBody {

	private Random random;
	private Rectangle connection;
	private int connectIndex = -1;

	public Star(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		random = new Random(seed + name.hashCode());
		generate();
	}

	@Override
	public void update() {
		switch (State.getState()) {
		case GAME_GALACTIC:
			incrementAngle(0.0001);
			getXAndY();
			break;
		case GAME_SOLAR:
			
			break;
		default:
			break;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		switch(State.getState()){
		case GAME_GALACTIC:
			if (connection != null) {
				g2d.setColor(Color.cyan);
				g2d.drawLine(x - (int) size / 2 + xOffset, y - (int) size / 2 + yOffset, connection.x - connection.width / 2,
						connection.y - connection.height / 2);
			}
			if(selected){
				g2d.setColor(Color.green);
				g2d.drawRect((int) (x - size) + xOffset, (int) (y - size) + yOffset, (int) (size * 2), (int) (size * 2)); 
			}
			g2d.setColor(color);
			g2d.fillOval((int) (x - size / 2) + xOffset, (int) (y - size / 2) + yOffset, (int) size, (int) size);
			break;
		case GAME_SOLAR:
			g2d.setColor(color);
			g2d.fillOval((int) (InputHandler.midPoint.x - size * 10), (int) (InputHandler.midPoint.y - size * 10), (int) size * 20, (int) size * 20);
			break;
		default:
			break;
		}
	}

	@Override
	public void generate() {
		getColor();
	}

	private void getColor() {
		double val = random.nextDouble();
		if (val >= 0 && val < 0.1) {
			color = Color.white;
		} else if (val >= 0.1 && val < 0.2) {
			color = Color.white;
		} else if (val >= 0.2 && val < 0.3) {
			color = Color.white;
		} else if (val >= 0.3 && val < 0.4) {
			color = Color.white;
		} else if (val >= 0.4 && val < 0.5) {
			color = Color.yellow;
		} else if (val >= 0.5 && val < 0.6) {
			color = Color.yellow;
		} else if (val >= 0.6 && val < 0.7) {
			color = Color.orange;
		} else if (val >= 0.7 && val < 0.8) {
			color = Color.red;
		} else if (val >= 0.8 && val < 0.9) {
			color = Color.cyan;
		} else if (val >= 0.9 && val <= 1) {
			color = Color.pink;
		}
	}

	public void setHyperSpaceLane(Rectangle star) {
		connection = star;
	}

	public int getConnectIndex() {
		return connectIndex;
	}

	public void setConnectIndex(int connectIndex) {
		this.connectIndex = connectIndex;
	}

}
