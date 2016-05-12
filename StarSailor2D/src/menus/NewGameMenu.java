package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import main.State;
import utils.InputHandler;

public class NewGameMenu extends Menu {

	private static final long serialVersionUID = 1L;
	private JButton create, cancel;
	private InputHandler createHandler, cancelHandler;
	private JLabel galaxyName, seed;
	private JTextField nameEntry, seedEntry;

	public NewGameMenu() {
		create = new JButton("Create");
		createHandler = new InputHandler(create);
		create.setBounds((int) InputHandler.midPoint.x / 2 - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		cancel = new JButton("Cancel");
		cancelHandler = new InputHandler(cancel);
		cancel.setBounds((int) (3 * InputHandler.midPoint.x / 2) - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		galaxyName = new JLabel("Galaxy Name: ");
		galaxyName.setFont(new Font("Arial", Font.PLAIN, 16));
		galaxyName.setForeground(Color.white);
		galaxyName.setBounds(InputHandler.screenSize.width / 12, InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 30);
		seed = new JLabel("Seed: ");
		seed.setFont(new Font("Arial", Font.PLAIN, 16));
		seed.setForeground(Color.white);
		seed.setBounds(InputHandler.screenSize.width / 12, 2 * InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 30);
		nameEntry = new JTextField("galaxy");
		nameEntry.setBounds(3 * InputHandler.screenSize.width / 12, InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 2, InputHandler.screenSize.height / 30);
		seedEntry = new JTextField("" + new Random().nextLong());
		seedEntry.setBounds(3 * InputHandler.screenSize.width / 12, 2 * InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 2, InputHandler.screenSize.height / 30);
		setLayout(null);
		add(create);
		add(cancel);
		add(galaxyName);
		add(seed);
		add(nameEntry);
		add(seedEntry);
	}

	@Override
	public int update() {
		int change = 0;
		if (createHandler.isMouseDown(MouseEvent.BUTTON1)) {
			State.setState(State.STATE.GAME_SURFACE);
			change = 1;
		}
		if (cancelHandler.isMouseDown(MouseEvent.BUTTON1)) {
			State.setState(State.STATE.MENU_MAIN);
			change = 2;
		}
		return change;
	}

	public String getName() {
		return nameEntry.getText();
	}

	public String getSeed() {
		return seedEntry.getText();
	}

}
