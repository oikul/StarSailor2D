package biomes;

import java.awt.Color;

import galaxy.BiomePart;
import galaxy.Block;

public class BiomeOcean extends Biome {

	public BiomeOcean(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.water_ocean, 0, 1, 1));
		decoration.add(new BiomePart(Block.deco_rocks, 0, 1, 0.02));
	}

}
