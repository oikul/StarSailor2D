package galaxy;

import java.awt.Graphics2D;

import main.State;
import utils.InputHandler;
import utils.ValueNoiseGenerator;

public class Planet extends PlanetaryBody {

	private float[][] terrain;
	private Block[][] blocks;
	private Block[][] deco;
	private ValueNoiseGenerator noise;
	private Biome biome;

	public Planet(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		terrain = new float[(int) size * 10][(int) size * 10];
		chooseBiome();
		noise = new ValueNoiseGenerator(seed + name.hashCode(), biome);
		generate();
	}

	@Override
	public void update() {
		switch (State.state) {
		case GAME_PLANETARY:
			break;
		case GAME_SOLAR:
			incrementAngle(0.001);
			getXAndY();
			break;
		case GAME_SURFACE:
			for (int i = 0; i < terrain.length; i++) {
				for (int j = 0; j < terrain[0].length; j++) {
					blocks[i][j].update();
				}
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		switch (State.state) {
		case GAME_PLANETARY:
			break;
		case GAME_SOLAR:
			g2d.setColor(biome.color);
			g2d.fillOval(x - (int) size/2 + xOffset, y - (int) size/2 + yOffset, (int) size, (int) size); 
			break;
		case GAME_SURFACE:
			for (int i = 0; i < terrain.length; i++) {
				for (int j = 0; j < terrain[0].length; j++) {
					if (!blocks[i][j].equals(null)) {
						blocks[i][j].draw(g2d, i * 16, j * 16);
					}
					if (deco[i][j] != null) {
						deco[i][j].draw(g2d, i * 16, j * 16);
					}
				}
			}
			break;
		default:
			break;
		}

	}

	@Override
	public void generate() {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				terrain[i][j] = noise.generateHeight(i, j) % 1;
			}
		}
		blocks = biome.generateBiome(terrain);
		deco = biome.generateDeco(terrain);
	}

	public void chooseBiome() {
		double maxDist = InputHandler.midPoint.y;
		biome = Biome.DESERT;
		if(size >= 0 && size < 4){
			if(distance >= 0 && distance < maxDist / 3){
				biome = Biome.DESERT;
			}else if(distance >= maxDist / 3 && distance < 2 * maxDist / 3){
				biome = Biome.ISLANDS;
			}else if(distance >= 2 * maxDist / 3 && distance <= maxDist){
				biome = Biome.DESERT;
			}
		}else if(size >= 4 && size < 7){
			if(distance >= 0 && distance < maxDist / 3){
				biome = Biome.ISLANDS;
			}else if(distance >= maxDist / 3 && distance < 2 * maxDist / 3){
				biome = Biome.DESERT;
			}else if(distance >= 2 * maxDist / 3 && distance <= maxDist){
				biome = Biome.ISLANDS;
			}
		}else if(size >= 7 && size <= 10){
			if(distance >= 0 && distance < maxDist / 3){
				biome = Biome.DESERT;
			}else if(distance >= maxDist / 3 && distance < 2 * maxDist / 3){
				biome = Biome.ISLANDS;
			}else if(distance >= 2 * maxDist / 3 && distance <= maxDist){
				biome = Biome.DESERT;
			}
		}
	}

}
