package main;

public class State {
	
	public static STATE state = STATE.MENU_MAIN;

	public static enum STATE {
		MENU_MAIN, MENU_NEW, MENU_LOAD, MENU_CONNECT, 
		GAME_GALACTIC, GAME_SOLAR, GAME_PLANETARY, GAME_SATTELITE, GAME_SURFACE, GAME_BATTLE
	}
	
	public static void setState(String name){
		switch(name){
		case "main":
			state = STATE.MENU_MAIN;
			break;
		case "new":
			state = STATE.MENU_NEW;
			break;
		case "load":
			state = STATE.MENU_LOAD;
			break;
		case "connect":
			state = STATE.MENU_CONNECT;
			break;
		case "galaxy":
			state = STATE.GAME_GALACTIC;
			break;
		case "star":
			state = STATE.GAME_SOLAR;
			break;
		case "planet":
			state = STATE.GAME_PLANETARY;
			break;
		case "sattelite":
			state = STATE.GAME_SATTELITE;
			break;
		case "surface":
			state = STATE.GAME_SURFACE;
			break;
		case "battle":
			state = STATE.GAME_BATTLE;
			break;
		default:
			System.out.println("no such state");
			break;
		}
	}

}
