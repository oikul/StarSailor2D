package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

import utils.InputHandler;

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
		generateStars();
	}

	public void update() {
		for(int i = 0; i < numStars; i++){
			stars[i].update();
		}
	}

	public void draw(Graphics2D g2d) {
		g2d.setColor(Color.black);
		g2d.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
		for(int i = 0; i < numStars; i++){
			stars[i].draw(g2d);
		}
	}
	
	public void generateStars(){
		for(int i = 0; i < numStars; i++){
			stars[i] = new Star(random.nextDouble() * 5, random.nextInt(size), random.nextDouble() * 2 * Math.PI, seed + i);
		}
	}

}
