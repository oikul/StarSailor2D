package main;

import java.awt.Graphics2D;

import javax.swing.JFrame;

import galaxy.Galaxy;
import menus.ConnectMenu;
import menus.LoadGameMenu;
import menus.MainMenu;
import menus.NewGameMenu;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private final int TICKS_PER_SECOND = 25;
	private final int SKIP_TICKS = 1000 / TICKS_PER_SECOND;
	private final int MAX_FRAMESKIP = 5;
	private Galaxy galaxy;
	private MainMenu mainMenu;
	private NewGameMenu newMenu;
	private LoadGameMenu loadMenu;
	private ConnectMenu connectMenu;

	public static void main(String args[]) {
		Main main = new Main();
		main.run();
	}

	public void run() {
		initialise();
		double nextTick = System.currentTimeMillis();
		int loops;
		while (running) {
			loops = 0;
			while (System.currentTimeMillis() > nextTick && loops < MAX_FRAMESKIP) {
				update();
				nextTick += SKIP_TICKS;
				loops++;
			}
			draw();
		}
	}

	public void initialise() {
		setTitle("Star Sailor");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		mainMenu = new MainMenu();
		add(mainMenu);
		setVisible(true);
		running = true;
	}

	public void update() {
		int change = 0;
		switch (State.getState()) {
		case GAME_BATTLE:
			galaxy.update();
			break;
		case GAME_GALACTIC:
			galaxy.update();
			break;
		case GAME_PLANETARY:
			galaxy.update();
			break;
		case GAME_SATTELITE:
			galaxy.update();
			break;
		case GAME_SOLAR:
			galaxy.update();
			break;
		case GAME_SURFACE:
			galaxy.update();
			break;
		case MENU_CONNECT:
			change = connectMenu.update();
			if (change == 1) {
				// connect
			} else if (change == 2) {
				mainMenu = new MainMenu();
				remove(connectMenu);
				add(mainMenu);
				setVisible(true);
			}
			break;
		case MENU_LOAD:
			change = loadMenu.update();
			if (change == 1) {
				// load game
			} else if (change == 2) {
				mainMenu = new MainMenu();
				remove(loadMenu);
				add(mainMenu);
				setVisible(true);
			}
			break;
		case MENU_MAIN:
			change = mainMenu.update();
			if (change == 1) {
				newMenu = new NewGameMenu();
				remove(mainMenu);
				add(newMenu);
				setVisible(true);
			} else if (change == 2) {
				loadMenu = new LoadGameMenu();
				remove(mainMenu);
				add(loadMenu);
				setVisible(true);
			} else if (change == 3) {
				connectMenu = new ConnectMenu();
				remove(mainMenu);
				add(connectMenu);
				setVisible(true);
			}
			break;
		case MENU_NEW:
			change = newMenu.update();
			if (change == 1) {
				galaxy = new Galaxy(newMenu.getSeed());
				remove(newMenu);
				add(galaxy);
				setVisible(true);
			} else if (change == 2) {
				mainMenu = new MainMenu();
				remove(newMenu);
				add(mainMenu);
				setVisible(true);
			}
			break;
		default:
			break;
		}
	}

	public void draw() {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		switch (State.getState()) {
		case GAME_BATTLE:
			galaxy.draw(g2d);
			break;
		case GAME_GALACTIC:
			galaxy.draw(g2d);
			break;
		case GAME_PLANETARY:
			galaxy.draw(g2d);
			break;
		case GAME_SATTELITE:
			galaxy.draw(g2d);
			break;
		case GAME_SOLAR:
			galaxy.draw(g2d);
			break;
		case GAME_SURFACE:
			galaxy.draw(g2d);
			break;
		case MENU_CONNECT:
			break;
		case MENU_LOAD:
			break;
		case MENU_MAIN:
			break;
		case MENU_NEW:
			break;
		default:
			break;
		}
	}

}
