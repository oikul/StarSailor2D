package menus;

import java.awt.Graphics;

import javax.swing.JPanel;

import utils.InputHandler;
import utils.ResourceLoader;

public abstract class Menu extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	public abstract int update();

	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(ResourceLoader.background, 0, 0, InputHandler.screenSize.width, InputHandler.screenSize.height, null);
	}

}
