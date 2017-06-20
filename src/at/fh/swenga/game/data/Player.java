package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;
import static at.fh.swenga.game.helpers.Scorer.LoadScore;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import at.fh.swenga.game.helpers.Clock;

public class Player {

	private Grid grid;
	private TileType[] types;
	private WaveManager waveManager;
	private ArrayList<Tower> towerList;
	private boolean leftMouseButtonDown, rightMouseButtonDown, holdingTower;
	private Tower tempTower;
	public static int Gold, Lives, Score, HighScore, Enemies_slain, Waves_completed, Towers_built;
	public static boolean GameOver = false;
	
	public Player(Grid grid, WaveManager waveManager){
		this.grid = grid;
		this.types = new TileType[3];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.waveManager = waveManager;
		this.towerList = new ArrayList<Tower>();
		this.leftMouseButtonDown = false;
		this.rightMouseButtonDown = false;
		this.holdingTower = false;
		this.tempTower = null;
		Gold = 0;
		Lives = 10;
		Score = 0;
		HighScore = LoadScore(HIGHSCORE_FILENAME);
	}
	
	// Initialize Gold and Lives
	public void setup() {
		Gold = 150;
		Lives = 10;
	}
	
	// Check if Player can afford tower
	public static boolean ModifyGold(int amount) {
		if (Gold + amount >= 0) {
			Gold += amount;
			return true;
		}
		return false;
	}
	
	public static void ModifyLives(int amount) {
		Lives += amount;
		if (Lives <= 0)
			GameOver = true;
	}
	
	public static void ModifyScore(int amount) {
		Score += amount;
	}
	
	public static void ModifyEnemiesSlain() {
		Enemies_slain++;
	}
	
	public static void ModifyWavesCompleted() {
		Waves_completed++;
	}
	
	public static void ModifyTowersBuilt() {
		Towers_built++;
	}
	
	public void update() {
		
		// Update holding tower
		if (holdingTower){
			tempTower.setX(getMouseTile().getX());
			tempTower.setY(getMouseTile().getY());
			tempTower.draw();
		}
		
		// Update all towers in the game
		for (Tower t : towerList){
			t.update();
			t.draw();
			t.updateEnemyList(waveManager.getCurrentWave().getEnemyList());
		}
		
		// Mouse Input
		if (Mouse.isButtonDown(0) && !leftMouseButtonDown)
			placeTower();
		if (Mouse.isButtonDown(1) && !rightMouseButtonDown)
			if (holdingTower)
				unpickTower();
			
		leftMouseButtonDown = Mouse.isButtonDown(0);
		rightMouseButtonDown = Mouse.isButtonDown(1);
		
		// Keyboard Input - Broken mechanics :/
		while (Keyboard.next()){
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()){
				Clock.ChangeMulitplier(0.2f);
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_LEFT && Keyboard.getEventKeyState()){
				Clock.ChangeMulitplier(-0.2f);
			}
		}		
	}
	
	private void placeTower() {
		Tile currentTile = getMouseTile();
		if (holdingTower)
			if (!currentTile.isOccupied() && ModifyGold(-tempTower.getCost())) {
				towerList.add(tempTower);
				currentTile.setOccupied(true);
				holdingTower = false;
				tempTower = null;
				ModifyTowersBuilt();
			}
	}
	
	public void pickTower(Tower t){
		tempTower = t;
		holdingTower = true;
	}
	
	public void unpickTower(){
		tempTower = null;
		holdingTower = false;
	}
	
	private Tile getMouseTile() {
		return grid.getTile(Mouse.getX() / TILE_SIZE, (HEIGHT - Mouse.getY() - 1) / TILE_SIZE);
	}
}
