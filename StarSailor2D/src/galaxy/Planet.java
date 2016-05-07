package galaxy;

import java.awt.Graphics2D;

import utils.ValueNoiseGenerator;

public class Planet extends PlanetaryBody {

	private float[][] terrain;
	private Block[][] blocks;
	private Block[][] deco;
	private ValueNoiseGenerator noise;
	private Biome biome;

	public Planet(double size, double distance, double angle, long seed) {
		super(size, distance, angle, seed);
		terrain = new float[(int) size * 10][(int) size * 10];
		System.out.println(name);
		biome = Biome.ISLANDS;
		noise = new ValueNoiseGenerator(seed + name.hashCode(), biome);
		generate();
		blocks = biome.generateBiome(terrain);
		deco = biome.generateDeco(terrain);
	}

	@Override
	public void update() {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				blocks[i][j].update();
			}
		}
	}

	@Override
	public void draw(Graphics2D g2d) {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				if(!blocks[i][j].equals(null)){
					blocks[i][j].draw(g2d, i * 16, j * 16);
				}
				if(deco[i][j] != null){
					deco[i][j].draw(g2d, i * 16, j * 16);
				}
			}
		}
	}

	@Override
	public void generate() {
		for (int i = 0; i < terrain.length; i++) {
			for (int j = 0; j < terrain[0].length; j++) {
				terrain[i][j] = noise.generateHeight(i, j) % 1;
			}
		}
	}
	
	public void chooseBiome(){
		
	}

}
