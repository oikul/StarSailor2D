package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import main.State;
import utils.InputHandler;

public class Galaxy extends JPanel {

	private static final long serialVersionUID = 1L;
	private Random random;
	private Star[] stars;
	private PlanetaryBody[][] planets;
	private PlanetaryBody[][][] moons;
	private int size = 16384, numStars = 4096, minPlanets = 4, maxPlanets = 16, minMoons = 2, maxMoons = 8,
			currentStar = 0, currentPlanet = 1, currentMoon = 1;
	private long seed;
	private BufferedImage offImage = new BufferedImage(InputHandler.screenSize.width, InputHandler.screenSize.height,
			BufferedImage.TYPE_INT_ARGB);
	private Graphics2D offGraphics;

	public Galaxy(long seed) {
		stars = new Star[this.numStars];
		planets = new Planet[this.numStars][this.maxPlanets];
		moons = new Planet[this.numStars][this.maxPlanets][this.maxMoons];
		random = new Random(this.seed);
		offGraphics = (Graphics2D) offImage.getGraphics();
		generateStars();
	}

	public void update() {
		switch (State.state) {
		case GAME_BATTLE:
			break;
		case GAME_GALACTIC:
			for (int i = 0; i < numStars; i++) {
				stars[i].update();
			}
			for (int i = 0; i < numStars; i++) {
				int index = stars[i].getConnectIndex();
				if (index != i && index != -1) {
					stars[i].setHyperSpaceLane(stars[stars[i].getConnectIndex()].getRect());
				}
			}
			break;
		case GAME_PLANETARY:
			for (int i = 0; i < maxMoons; i++) {
				if (moons[currentStar][currentPlanet][i] != null) {
					moons[currentStar][currentPlanet][i].update();
				}
			}
			break;
		case GAME_SATTELITE:
			break;
		case GAME_SOLAR:
			for (int i = 0; i < maxPlanets; i++) {
				if (planets[currentStar][i] != null) {
					planets[currentStar][i].update();
				}
			}
			break;
		case GAME_SURFACE:
			break;
		default:
			break;
		}
	}

	public void draw(Graphics2D g2d) {
		offGraphics.setColor(Color.black);
		offGraphics.fillRect(0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height);
		switch (State.state) {
		case GAME_BATTLE:
			break;
		case GAME_GALACTIC:
			for (int i = 0; i < numStars; i++) {
				stars[i].draw(offGraphics);
			}
			break;
		case GAME_PLANETARY:
			planets[currentStar][currentPlanet].draw(offGraphics);
			for (int i = 0; i < maxMoons; i++) {
				if (moons[currentStar][currentPlanet][i] != null) {
					moons[currentStar][currentPlanet][i].draw(offGraphics);
				}
			}
			break;
		case GAME_SATTELITE:
			moons[currentStar][currentPlanet][currentMoon].draw(offGraphics);
			break;
		case GAME_SOLAR:
			stars[currentStar].draw(offGraphics);
			for (int i = 0; i < maxPlanets; i++) {
				if (planets[currentStar][i] != null) {
					planets[currentStar][i].draw(offGraphics);
				}
			}
			break;
		case GAME_SURFACE:
			planets[currentStar][currentPlanet].draw(offGraphics);
			break;
		default:
			break;
		}
		g2d.drawImage(offImage, 0, 0, null);
	}

	public void generateStars() {
		for (int i = 0; i < numStars; i++) {
			stars[i] = new Star(random.nextDouble() * 4 + 1, random.nextInt(size), random.nextDouble() * 2 * Math.PI,
					seed + i);
			stars[i].getXAndY();
		}
		for (int i = 0; i < numStars; i++) {
			double distance = this.size;
			int index = -1;
			for (int j = 0; j < numStars; j++) {
				double temp = getDistance(stars[i], stars[j]);
				if (temp < distance && i != j) {
					distance = temp;
					index = j;
				}
			}
			if (index != -1) {
				stars[i].setConnectIndex(index);
				stars[i].setHyperSpaceLane(stars[index].getRect());
			}
		}
	}

	public void generatePlanets() {
		int numPlanets = random.nextInt(maxPlanets - minPlanets) + minPlanets;
		for (int i = 0; i < numPlanets; i++) {

		}
	}

	public void generateMoons() {
		int numMoons = random.nextInt(maxMoons - minMoons) + minMoons;
		for (int i = 0; i < numMoons; i++) {

		}
	}

	private double getDistance(Star a, Star b) {
		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
	}

}
