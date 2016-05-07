package main;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;

import utils.InputHandler;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private boolean running = false;

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
		setVisible(true);
		running = true;
	}

	public void update() {
	}

	public void draw() {
		Graphics2D g2d = (Graphics2D) this.getGraphics();
		Image offImage = this.createImage(InputHandler.screenDim.width, InputHandler.screenDim.height);
		Graphics2D offGraphics = (Graphics2D) offImage.getGraphics();
		g2d.drawImage(offImage, 0, 0, null);
	}

	public void capFPS(int fps) {
	}

}
