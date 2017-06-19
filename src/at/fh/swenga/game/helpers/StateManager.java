package at.fh.swenga.game.helpers;

import static at.fh.swenga.game.helpers.Artist.MAP_NAME;
import static at.fh.swenga.game.helpers.Leveler.*;

import java.io.File;
import java.io.IOException;

import at.fh.swenga.game.data.Editor;
import at.fh.swenga.game.data.Game;
import at.fh.swenga.game.data.Grid;
import at.fh.swenga.game.data.MainMenu;

public class StateManager {

	public static enum GameState {
		MAINMENU, GAME, EDITOR
	}
	
	public static int[][] default_map_layout = {
			{1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,4,4,4,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,5,4,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,4,4,4,0},
	};
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Game game;
	public static Editor editor;
	
	public static long nextSecond = System.currentTimeMillis() + 1000;
	public static int framesInLastSecond = 0;
	public static int framesInCurrentSecond = 0;
	
	public static int checkMap = 1;
	static Grid map = new Grid(default_map_layout);
	
	public static void Update() {
		
		if (checkMap == 1) {
			if (LoadMap(MAP_NAME) == null){
				try {
					File f = new File(MAP_NAME);
					f.getParentFile().mkdirs();
					f.createNewFile();
				} catch (IOException e) {
					System.out.println("Error upon file creation");
					e.printStackTrace();
				}
				SaveMap(MAP_NAME, map);
			}
			else
				checkMap = 0;
		}
		
		if (checkMap == 0) {
			map = LoadMap(MAP_NAME);
			checkMap = 2;
		}
		
		switch(gameState) {
		case MAINMENU:
			if (mainMenu == null) 
				mainMenu = new MainMenu();
			mainMenu.update();
			break;
		case GAME:
			if (game == null)
				game = new Game(map);
			game.update();
			break;
		case EDITOR:
			if (editor == null)
				editor = new Editor();
			editor.update();
			break;
		}
		
		long currentTime = System.currentTimeMillis();
		if (currentTime > nextSecond){
			nextSecond += 1000;
			framesInLastSecond = framesInCurrentSecond;
			framesInCurrentSecond = 0;
		}
		
		framesInCurrentSecond++;
	}
	
	public static void setState(GameState newState) {
		gameState = newState;
	}
}
