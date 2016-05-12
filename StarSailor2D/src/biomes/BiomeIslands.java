package biomes;

import java.awt.Color;

import galaxy.BiomePart;
import galaxy.Block;

public class BiomeIslands extends Biome {

	public BiomeIslands(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.grass_jungle, 0, 1, 1));
		biomeParts.add(new BiomePart(Block.sand_beach, 0.55, 0.85, 1));
		biomeParts.add(new BiomePart(Block.water_ocean, 0.6, 0.8, 1));
		decoration.add(new BiomePart(Block.tree_palm, 0, 0.54, 0.15));
		decoration.add(new BiomePart(Block.tree_palm, 0.86, 1, 0.15));
		decoration.add(new BiomePart(Block.deco_rocks, 0.65, 0.75, 0.01));
	}

}
