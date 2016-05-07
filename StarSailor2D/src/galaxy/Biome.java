package galaxy;

import java.util.ArrayList;

public class Biome {

	public static final Biome ISLANDS = new BiomeIslands(1.0f, 0.25f, 4);

	protected float amplitude, roughness;
	protected int octaves;
	protected ArrayList<BiomePart> biomeParts = new ArrayList<BiomePart>();
	protected ArrayList<BiomePart> decoration = new ArrayList<BiomePart>();

	public Biome(float amplitude, float roughness, int octaves) {
		this.amplitude = amplitude;
		this.roughness = roughness;
		this.octaves = octaves;
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

}
