package biomes;

import java.awt.Color;

import galaxy.BiomePart;
import galaxy.Block;

public class BiomeForest extends Biome {

	public BiomeForest(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.grass_forest, 0, 1, 1));
		biomeParts.add(new BiomePart(Block.water_river, 0.3, 0.5, 1));
		decoration.add(new BiomePart(Block.tree_oak, 0, 0.3, 0.1));
		decoration.add(new BiomePart(Block.tree_oak, 0.5, 1, 0.1));
	}

}
