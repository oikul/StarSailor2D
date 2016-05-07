package main;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import galaxy.Galaxy;
import menus.MainMenu;
import utils.InputHandler;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean running = false;
	private Galaxy galaxy;
	private MainMenu mainMenu;

	public static void main(String args[]) {
		Main main = new Main();
		main.run();
	}

	public void run() {
		initialise();
		while (running) {
			update();
			draw();
			capFPS(InputHandler.refreshRate);
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
		switch(State.state){
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
		case GAME_SURFACE_P:
			galaxy.update();
			break;
		case GAME_SURFACE_S:
			galaxy.update();
			break;
		case MENU_CONNECT:
			break;
		case MENU_LOAD:
			break;
		case MENU_MAIN:
			if(mainMenu.update() == 1){
				removeAll();
				
				repaint();
			}
			break;
		case MENU_NEW:
			break;
		default:
			break;
		}
	}

	public void draw() {
		switch(State.state){
		case GAME_BATTLE:
			galaxy.draw();
			break;
		case GAME_GALACTIC:
			galaxy.draw();
			break;
		case GAME_PLANETARY:
			galaxy.draw();
			break;
		case GAME_SATTELITE:
			galaxy.draw();
			break;
		case GAME_SOLAR:
			galaxy.draw();
			break;
		case GAME_SURFACE_P:
			galaxy.draw();
			break;
		case GAME_SURFACE_S:
			galaxy.draw();
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

	public void capFPS(int fps) {
	}

}
