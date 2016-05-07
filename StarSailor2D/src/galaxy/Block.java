package galaxy;

import java.awt.Graphics2D;
import java.awt.Image;

import utils.ResourceLoader;

public class Block {
	
	public static final Block grass_plains = new Block("grass/grass_plains.png", -1, false);
	public static final Block grass_forest = new Block("grass/grass_forest.png", -1, false);
	public static final Block sand = new Block("sand/sand.png", -1, false);
	public static final Block water_river = new Block("water/water_river.png", 500, true);
	
	public static final Block tree_palm = new Block("trees/tree_palm.png", -1, true);
	
	private Image[] textures;
	private long time, animationWaitTime;
	private int index;
	private boolean solid;

	public Block(String path, long animationWaitTime, boolean solid) {
		textures = ResourceLoader.getBlockSprites(path, 16, 16);
		this.animationWaitTime = animationWaitTime;
		time = System.currentTimeMillis();
		this.solid = solid;
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

}

