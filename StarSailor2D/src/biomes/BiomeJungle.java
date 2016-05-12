package biomes;

import java.awt.Color;

import galaxy.BiomePart;
import galaxy.Block;

public class BiomeJungle extends Biome {

	public BiomeJungle(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.grass_rainforest, 0, 1, 1));
		biomeParts.add(new BiomePart(Block.water_river, 0.8, 1, 1));
		decoration.add(new BiomePart(Block.tree_shrub, 0, 0.77, 0.2));
		decoration.add(new BiomePart(Block.tree_shrub1, 0, 0.77, 0.2));
		decoration.add(new BiomePart(Block.tree_rubber, 0, 0.77, 0.2));
		decoration.add(new BiomePart(Block.tree_palm, 0, 0.77, 0.2));
	}

}
