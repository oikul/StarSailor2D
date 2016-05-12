package biomes;

import java.awt.Color;
import java.util.ArrayList;

import galaxy.BiomePart;
import galaxy.Block;

public class Biome {

	public static final Biome ISLANDS = new BiomeIslands(1.0f, 0.25f, 4, Color.blue);
	public static final Biome DESERT = new BiomeDesert(8f, 0f, 4, Color.yellow);
	public static final Biome OCEAN = new BiomeOcean(1.0f, 0.1f, 2, Color.blue);
	public static final Biome FOREST = new BiomeForest(5f, 0.0f, 6, Color.green);

	protected float amplitude, roughness;
	protected int octaves;
	protected ArrayList<BiomePart> biomeParts = new ArrayList<BiomePart>();
	protected ArrayList<BiomePart> decoration = new ArrayList<BiomePart>();
	protected Color color;

	public Biome(float amplitude, float roughness, int octaves, Color color) {
		this.amplitude = amplitude;
		this.roughness = roughness;
		this.octaves = octaves;
		this.color = color;
	}

	public Block[][] generateBiome(float[][] noise) {
		Block[][] blocks = new Block[noise.length][noise[0].length];
		for (int i = 0; i < noise.length; i++) {
			for (int j = 0; j < noise[0].length; j++) {
				for (int k = 0; k < biomeParts.size(); k++) {
					if (biomeParts.get(k).isBetween(noise[i][j])) {
						blocks[i][j] = biomeParts.get(k).getBlock();
					}
				}
			}
		}
		return blocks;
	}

	public Block[][] generateDeco(float[][] noise) {
		Block[][] blocks = new Block[noise.length][noise[0].length];
		for (int i = 0; i < noise.length; i++) {
			for (int j = 0; j < noise[0].length; j++) {
				for (int k = 0; k < decoration.size(); k++) {
					if (decoration.get(k).isBetween(noise[i][j])) {
						blocks[i][j] = decoration.get(k).getBlock();
					}
				}
			}
		}
		return blocks;
	}

	public float getAmplitude() {
		return amplitude;
	}

	public float getRoughness() {
		return roughness;
	}

	public int getOctaves() {
		return octaves;
	}

	public Color getColor() {
		return color;
	}

}
