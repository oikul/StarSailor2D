package menus;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import utils.InputHandler;

public class NewGameMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton create, cancel;
	private InputHandler createHandler, cancelHandler;
	private JLabel galaxyName, seed;
	private JTextField nameEntry, seedEntry;
	
	public NewGameMenu(){
		create = new JButton("Create");
		createHandler = new InputHandler(create);
		create.setBounds((int) InputHandler.midPoint.x / 4, (int) (4 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 10);
		cancel = new JButton("Cancel");
		cancelHandler = new InputHandler(cancel);
		galaxyName = new JLabel("Galaxy Name: ");
		seed = new JLabel("Seed: ");
		nameEntry = new JTextField("galaxy");
		seedEntry = new JTextField("seed");
	}
	
	public int update(){
		int change = 0;
		if(createHandler.isMouseDown(MouseEvent.BUTTON1)){
			change = 1;
		}
		if(cancelHandler.isMouseDown(MouseEvent.BUTTON1)){
			change = 2;
		}
		return change;
	}

}
