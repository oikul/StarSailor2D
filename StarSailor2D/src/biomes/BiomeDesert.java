package biomes;

import java.awt.Color;

import galaxy.BiomePart;
import galaxy.Block;

public class BiomeDesert extends Biome {

	public BiomeDesert(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.sand_cracked, 0, 1, 1));
		biomeParts.add(new BiomePart(Block.sand_arid, 0, 0.2, 1));
		decoration.add(new BiomePart(Block.tree_cactus, 0, 1, 0.005));
		decoration.add(new BiomePart(Block.deco_rocks, 0, 1, 0.005));
	}

}
