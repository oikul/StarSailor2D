package galaxy;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import biomes.Biome;
import main.State;
import utils.ValueNoiseGenerator;

public class Planet extends PlanetaryBody {

	private float[][] terrain;
	private Block[][] blocks;
	private Block[][] deco;
	private ValueNoiseGenerator noise;
	private Biome biome;
	private BufferedImage terrainImage;
	private boolean imageMade = false;

	public Planet(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		terrain = new float[(int) size * 10][(int) size * 10];
		terrainImage = new BufferedImage(terrain.length * 16, terrain.length * 16, BufferedImage.TYPE_INT_ARGB);
		chooseBiome();
		noise = new ValueNoiseGenerator(seed + name.hashCode(), biome);
		generate();
	}

	@Override
	public void update() {
		switch (State.getState()) {
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
		switch (State.getState()) {
		case GAME_PLANETARY:
			break;
		case GAME_SOLAR:
			g2d.setColor(biome.getColor());
			g2d.fillOval(x - (int) size / 2 + xOffset, y - (int) size / 2 + yOffset, (int) size, (int) size);
			break;
		case GAME_SURFACE:
			if (imageMade) {
				g2d.drawImage(terrainImage, xOffset, yOffset, terrainImage.getWidth(), terrainImage.getHeight(), null);
			} else {
				Graphics2D g = (Graphics2D) terrainImage.getGraphics();
				for (int i = 0; i < terrain.length; i++) {
					for (int j = 0; j < terrain[0].length; j++) {
						if (!blocks[i][j].equals(null)) {
							blocks[i][j].draw(g, i * 16 + xOffset, j * 16 + yOffset);
						}
						if (deco[i][j] != null) {
							deco[i][j].draw(g, i * 16 + xOffset, j * 16 + yOffset);
						}
					}
				}
				g2d.drawImage(terrainImage, xOffset, yOffset, null);
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
		// double maxDist = InputHandler.midPoint.y;
		biome = Biome.JUNGLE;
		// if (size >= 0 && size < 4) {
		// if (distance >= 0 && distance < maxDist / 3) {
		// biome = Biome.DESERT;
		// } else if (distance >= maxDist / 3 && distance < 2 * maxDist / 3) {
		// biome = Biome.ISLANDS;
		// } else if (distance >= 2 * maxDist / 3 && distance <= maxDist) {
		// biome = Biome.OCEAN;
		// }
		// } else if (size >= 4 && size < 7) {
		// if (distance >= 0 && distance < maxDist / 3) {
		// biome = Biome.ISLANDS;
		// } else if (distance >= maxDist / 3 && distance < 2 * maxDist / 3) {
		// biome = Biome.DESERT;
		// } else if (distance >= 2 * maxDist / 3 && distance <= maxDist) {
		// biome = Biome.OCEAN;
		// }
		// } else if (size >= 7 && size <= 10) {
		// if (distance >= 0 && distance < maxDist / 3) {
		// biome = Biome.DESERT;
		// } else if (distance >= maxDist / 3 && distance < 2 * maxDist / 3) {
		// biome = Biome.ISLANDS;
		// } else if (distance >= 2 * maxDist / 3 && distance <= maxDist) {
		// biome = Biome.OCEAN;
		// }
		// }
	}

}
