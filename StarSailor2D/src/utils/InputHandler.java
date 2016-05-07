package utils;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

public class InputHandler {

	public static int refreshRate = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices()[0]
			.getDisplayMode().getRefreshRate();
	public static Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();

}
