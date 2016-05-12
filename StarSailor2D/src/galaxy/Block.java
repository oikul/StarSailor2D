package galaxy;

import java.awt.Graphics2D;
import java.awt.Image;

import utils.ResourceLoader;

public class Block {
	
	public static final Block deco_rocks = new Block("decoration/rocks.png", -1, true);

	public static final Block grass_forest = new Block("grass/grass_forest.png", -1, false);
	public static final Block grass_jungle = new Block("grass/grass_jungle.png", -1, false);
	public static final Block grass_mountains = new Block("grass/grass_mountains.png", -1, false);
	public static final Block grass_plains = new Block("grass/grass_plains.png", -1, false);
	public static final Block grass_rainforest = new Block("grass/grass_rainforest.png", -1, false);
	public static final Block grass_savannah = new Block("grass/grass_savannah.png", -1, false);
	public static final Block grass_snowy = new Block("grass/grass_snowy.png", -1, false);
	public static final Block grass_steppe = new Block("grass/grass_steppe.png", -1, false);
	public static final Block grass_tundra = new Block("grass/grass_tundra.png", -1, false);
	
	public static final Block sand_arid = new Block("sand/sand_arid.png", -1, false);
	public static final Block sand_beach = new Block("sand/sand_beach.png", -1, false);
	public static final Block sand_cracked = new Block("sand/sand_cracked.png", -1, false);
	public static final Block sand_dunes = new Block("sand/sand_dunes.png", -1, false);
	public static final Block sand = new Block("sand/sand.png", -1, false);

	public static final Block tree_baobab = new Block("trees/tree_baobab.png", -1, true);
	public static final Block tree_birch = new Block("trees/tree_birch.png", -1, true);
	public static final Block tree_cactus = new Block("trees/tree_cactus.png", -1, true);
	public static final Block tree_oak = new Block("trees/tree_oak_1.png", -1, true);
	public static final Block tree_palm = new Block("trees/tree_palm.png", -1, true);
	public static final Block tree_pine = new Block("trees/tree_pine.png", -1, true);
	public static final Block tree_rubber = new Block("trees/tree_rubber.png", -1, true);
	public static final Block tree_sequoia = new Block("trees/tree_sequoia.png", -1, true);
	public static final Block tree_shrub = new Block("trees/tree_shrub.png", -1, true);
	public static final Block tree_shrub1 = new Block("trees/tree_shrub_1.png", -1, true);
	public static final Block tree_spruce = new Block("trees/tree_spruce.png", -1, true);

	public static final Block water_murky = new Block("water/water_murky.png", 500, true);
	public static final Block water_ocean = new Block("water/water_ocean.png", 500, true);
	public static final Block water_river = new Block("water/water_river.png", 500, true);
	
	private Image[] textures;
	private long time, animationWaitTime;
	private int index;
	private boolean solid;
	private long id;

	public Block(String path, long animationWaitTime, boolean solid) {
		textures = ResourceLoader.getBlockSprites(path, 16, 16);
		this.animationWaitTime = animationWaitTime;
		time = System.currentTimeMillis();
		this.solid = solid;
		for(char c : path.toCharArray()){
			this.id += (int) c;
		}
	}
	
	public void update(){
		long newTime = System.currentTimeMillis();
		if(newTime > time + animationWaitTime && animationWaitTime != -1){
			time = newTime;
			if(index < textures.length - 1){
				index ++;
			}else{
				index = 0;
			}
		}
	}
	
	public void draw(Graphics2D g2d, int x, int y){
		g2d.drawImage(textures[index], x, y, 16, 16, null);
	}

	public boolean isSolid() {
		return solid;
	}
	
	public long getID(){
		return id;
	}

}

