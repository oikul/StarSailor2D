package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

import utils.InputHandler;

public class Galaxy extends JPanel {

	private static final long serialVersionUID = 1L;
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
		for (int i = 0; i < numStars; i++) {
			stars[i].update();
		}
	}

	public void draw() {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		Image offImage = this.createImage(InputHandler.screenSize.width, InputHandler.screenSize.height);
		Graphics2D offGraphics = (Graphics2D) offImage.getGraphics();
		offGraphics.setColor(Color.black);
		offGraphics.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
		for (int i = 0; i < numStars; i++) {
			stars[i].draw(offGraphics);
		}
		g2d.drawImage(offImage, 0, 0, null);
	}

	public void generateStars() {
		for (int i = 0; i < numStars; i++) {
			stars[i] = new Star(random.nextDouble() * 5, random.nextInt(size), random.nextDouble() * 2 * Math.PI,
					seed + i);
		}
	}

}
