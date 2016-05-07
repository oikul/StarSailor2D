package galaxy;

import java.util.Random;

public class BiomePart {

	private Block block;
	private double start, end, chance;
	private Random random;

	public BiomePart(Block block, double start, double end, double chance) {
		this.block = block;
		this.start = start;
		this.end = end;
		this.chance = chance;
		random = new Random((long) (start * end * chance));
	}

	public boolean isBetween(double val) {
		if (val >= start && val < end && random.nextDouble() < chance) {
			return true;
		}
		return false;
	}

	public Block getBlock() {
		return block;
	}

}
