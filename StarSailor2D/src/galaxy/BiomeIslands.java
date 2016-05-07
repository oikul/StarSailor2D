package galaxy;

public class BiomeIslands extends Biome {

	public BiomeIslands(float amplitude, float roughness, int octaves) {
		super(amplitude, roughness, octaves);
		biomeParts.add(new BiomePart(Block.grass_plains, 0, 1, 1));
		biomeParts.add(new BiomePart(Block.sand, 0.55, 0.85, 1));
		biomeParts.add(new BiomePart(Block.water_river, 0.6, 0.8, 1));
		decoration.add(new BiomePart(Block.tree_palm, 0, 0.55, 0.3));
		decoration.add(new BiomePart(Block.tree_palm, 0.85, 1, 0.3));
	}

}
