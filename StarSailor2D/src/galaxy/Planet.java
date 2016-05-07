package galaxy;

import java.awt.Graphics2D;

import utils.ValueNoiseGenerator;
import utils.InputHandler;

public class Planet extends PlanetaryBody {

	private float[][] terrain;
	ValueNoiseGenerator noise;

	public Planet(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		terrain = new float[InputHandler.screenDim.width / 8][InputHandler.screenDim.height / 8];
		noise = new ValueNoiseGenerator(seed + name.hashCode());
		System.out.println(name);
		generate();
	}

	@Override
	public void update() {
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				
			}
		}
	}

	@Override
	public void generate() {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				terrain[i][j] = noise.generateHeight(i, j) % 1;
			}
		}
	}

}
