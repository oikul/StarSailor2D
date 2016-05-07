package galaxy;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JPanel;

import entities.Player;
import main.State;
import utils.InputHandler;

public class Galaxy extends JPanel {

	private static final long serialVersionUID = 1L;
	private Random random;
	private Star[] stars;
	private PlanetaryBody[][] planets;
	private PlanetaryBody[][][] moons;
	private int size = 65536, numStars = 4096, minPlanets = 4, maxPlanets = 16, minMoons = 2, maxMoons = 8,
			currentStar = -1, currentPlanet = -1, currentMoon = -1;
	private long seed;
	private BufferedImage offImage = new BufferedImage(InputHandler.screenSize.width, InputHandler.screenSize.height,
			BufferedImage.TYPE_INT_ARGB);
	private Graphics2D offGraphics;
	private InputHandler input;

	public Galaxy(long seed) {
		stars = new Star[this.numStars];
		planets = new Planet[this.numStars][this.maxPlanets];
		moons = new Planet[this.numStars][this.maxPlanets][this.maxMoons];
		random = new Random(seed);
		offGraphics = (Graphics2D) offImage.getGraphics();
		input = new InputHandler(this);
		generateStars();
	}

	public void update() {
		switch (State.state) {
		case GAME_BATTLE:
			break;
		case GAME_GALACTIC:
			if (input.isMouseDown(MouseEvent.BUTTON1)) {
				currentStar = checkForClickGalactic(input.getMousePositionOnScreen());
			}
			if (input.getMouseWheelUp()) {
				State.setState("star");
			}
			for (int i = 0; i < numStars; i++) {
				stars[i].update();
				if (currentStar != -1) {
					if (Player.playerRect.x > stars[currentStar].x + stars[currentStar].xOffset) {
						stars[i].panLeft();
					} else if (Player.playerRect.x < stars[currentStar].x + stars[currentStar].xOffset) {
						stars[i].panRight();
					}
					if (Player.playerRect.y > stars[currentStar].y + stars[currentStar].yOffset) {
						stars[i].panUp();
					} else if (Player.playerRect.y < stars[currentStar].y + stars[currentStar].yOffset) {
						stars[i].panDown();
					}
				}
			}
			for (int i = 0; i < numStars; i++) {
				int index = stars[i].getConnectIndex();
				if (index != i && index != -1) {
					stars[i].setHyperSpaceLane(stars[stars[i].getConnectIndex()].getRectWithOffset());
				}
			}
			break;
		case GAME_PLANETARY:
			if (!planets[currentStar][currentPlanet].isGenerated()) {
				generateMoons();
				planets[currentStar][currentPlanet].setGenerated(true);
			}
			for (int i = 0; i < maxMoons; i++) {
				if (moons[currentStar][currentPlanet][i] != null) {
					moons[currentStar][currentPlanet][i].update();
				}
			}
			break;
		case GAME_SATTELITE:
			break;
		case GAME_SOLAR:
			if (!stars[currentStar].isGenerated()) {
				generatePlanets();
				stars[currentStar].setGenerated(true);
			}
			for (int i = 0; i < maxPlanets; i++) {
				if (planets[currentStar][i] != null) {
					planets[currentStar][i].update();
				}
			}
			break;
		case GAME_SURFACE:
			planets[currentStar][currentPlanet].update();
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
			stars[i] = new Star(random.nextDouble() * 4 + 2, random.nextInt(size), random.nextDouble() * 2 * Math.PI,
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
		random.setSeed(seed + currentStar);
		int numPlanets = random.nextInt(maxPlanets - minPlanets) + minPlanets;
		for (int i = 0; i < numPlanets; i++) {
			planets[currentStar][i] = new Planet(random.nextDouble() * 6 + 5,
					random.nextDouble() * (InputHandler.midPoint.y - stars[currentStar].size * 10)
							+ stars[currentStar].size * 10,
					random.nextDouble() * 2 * Math.PI, seed + currentStar + i);
		}
		random.setSeed(seed);
	}

	public void generateMoons() {
		int numMoons = random.nextInt(maxMoons - minMoons) + minMoons;
		for (int i = 0; i < numMoons; i++) {

		}
	}

	private int checkForClickGalactic(Point point) {
		Rectangle searchRect = new Rectangle(point.x - 3, point.y - 3, 6, 6);
		int index = -1;
		for (int i = 0; i < numStars; i++) {
			if (stars[i].getRectWithOffset().intersects(searchRect)) {
				stars[i].selected = true;
				index = i;
			} else {
				stars[i].selected = false;
			}
		}
		return index;
	}

	private double getDistance(Star a, Star b) {
		return Math.sqrt(Math.pow((a.x - b.x), 2) + Math.pow((a.y - b.y), 2));
	}

}
