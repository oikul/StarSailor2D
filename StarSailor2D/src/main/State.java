package main;

public class State {
	
	private static STATE state = STATE.MENU_MAIN;

	public static enum STATE {
		MENU_MAIN, MENU_NEW, MENU_LOAD, MENU_CONNECT, MENU_PAUSE, MENU_INVENTORY,
		GAME_GALACTIC, GAME_SOLAR, GAME_PLANETARY, GAME_SATTELITE, GAME_SURFACE, GAME_BATTLE, GAME_SHIP, GAME_DUNGEON
	}

	public static STATE getState() {
		return state;
	}

	public static void setState(STATE state) {
		State.state = state;
	}

}
