package menus;

import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.State;
import utils.InputHandler;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel title;
	private JButton newGame, loadGame, connect, exit;
	private InputHandler newHandler, loadHandler, connectHandler, exitHandler;

	public MainMenu() {
		title
		newGame = new JButton("New Game");
		newHandler = new InputHandler(newGame);
		newGame.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) InputHandler.midPoint.y - 2 * InputHandler.screenSize.height / 8,
				InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 10);
		loadGame = new JButton("Load Game");
		loadHandler = new InputHandler(loadGame);
		loadGame.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) InputHandler.midPoint.y - InputHandler.screenSize.height / 8, InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		connect = new JButton("Connect");
		connectHandler = new InputHandler(connect);
		connect.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) InputHandler.midPoint.y, InputHandler.screenSize.width / 6, InputHandler.screenSize.height / 10);
		exit = new JButton("Exit");
		exitHandler = new InputHandler(exit);
		exit.setBounds((int) InputHandler.midPoint.x - InputHandler.screenSize.width / 12,
				(int) InputHandler.midPoint.y + InputHandler.screenSize.height / 8, InputHandler.screenSize.width / 6,
				InputHandler.screenSize.height / 10);
		setLayout(null);
		add(newGame);
		add(loadGame);
		add(connect);
		add(exit);
	}

	public int update() {
		int change = 0;
		if (newHandler.isMouseDown(MouseEvent.BUTTON1)) {
			State.setState("new");
			change = 1;
		}
		if (loadHandler.isMouseDown(MouseEvent.BUTTON1)) {
			State.setState("load");
			change = 2;
		}
		if (connectHandler.isMouseDown(MouseEvent.BUTTON1)) {
			State.setState("connect");
			change = 3;
		}
		if (exitHandler.isMouseDown(MouseEvent.BUTTON1)) {
			System.exit(0);
		}
		return change;
	}

}
