package galaxy;

import java.awt.Color;

public class BiomeDesert extends Biome {

	public BiomeDesert(float amplitude, float roughness, int octaves, Color color) {
		super(amplitude, roughness, octaves, color);
		biomeParts.add(new BiomePart(Block.sand, 0, 1, 1));
		decoration.add(new BiomePart(Block.tree_cactus, 0, 1, 0.1));
	}

}
