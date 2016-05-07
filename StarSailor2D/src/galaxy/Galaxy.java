package galaxy;

import java.awt.Graphics;
import java.util.Random;

public class Galaxy {

	private Random random;
	private PlanetaryBody[] stars;
	private PlanetaryBody[][] planets;
	private PlanetaryBody[][][] moons;
	private int size, numStars, minPlanets, maxPlanets, minMoons, maxMoons;
	private long seed;

	public Galaxy(int size, int numStars, int minPlanets, int maxPlanets, int minMoons, int maxMoons, long seed) {
		this.size = size;
		this.numStars = numStars;
		this.minPlanets = minPlanets;
		this.maxPlanets = maxPlanets;
		this.minMoons = minMoons;
		this.maxMoons = maxMoons;
		this.seed = seed;
		stars = new Star[this.numStars];
		planets = new Planet[this.numStars][this.maxPlanets];
		moons = new Planet[this.numStars][this.maxPlanets][this.maxMoons];
		random = new Random(this.seed);
	}

	public void update() {

	}

	public void draw(Graphics g) {

	}
	
	public void generateStars(){
		for(int i = 0; i < numStars; i++){
			stars[i] = new Star(random.nextDouble() * 5, random.nextInt(size), random.nextDouble() * 2 * Math.PI, seed + i);
		}
	}

}
