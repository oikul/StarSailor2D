package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import main.State;
import utils.InputHandler;

public class LoadGameMenu extends Menu {
	
	private static final long serialVersionUID = 1L;
	private JButton loadGame, cancel;
	private InputHandler loadGameHandler, cancelHandler;
	private JLabel load;
	private JList<String> loadList;

	public LoadGameMenu(){
		loadGame = new JButton("Load Game");
		loadGame.setBounds((int) InputHandler.midPoint.x / 2 - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		loadGameHandler = new InputHandler(loadGame);
		cancel = new JButton("Cancel");
		cancel.setBounds((int) (3 * InputHandler.midPoint.x / 2) - InputHandler.screenSize.width / 12,
				(int) (5 * InputHandler.midPoint.y / 3), InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		cancelHandler = new InputHandler(cancel);
		load = new JLabel("Saved Games: ");
		load.setFont(new Font("Arial", Font.PLAIN, 16));
		load.setForeground(Color.white);
		load.setBounds(InputHandler.screenSize.width / 12, InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 30);
		loadList = new JList<String>();
		loadList.setBounds(2 * InputHandler.screenSize.width / 12, InputHandler.screenSize.height / 12,
				InputHandler.screenSize.width / 2, InputHandler.screenSize.height / 2);
		setLayout(null);
		add(loadGame);
		add(cancel);
		add(load);
		add(loadList);
	}

	@Override
	public int update() {
		int change = 0;
		if(loadGameHandler.isMouseDown(MouseEvent.BUTTON1)){
			State.setState("");
			change = 1;
		}
		if(cancelHandler.isMouseDown(MouseEvent.BUTTON1)){
			State.setState("main");
			change = 2;
		}
		return change;
	}

}
