package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;
import static at.fh.swenga.game.helpers.Clock.*;

import java.util.ArrayList;

import at.fh.swenga.game.dependencies.slick.Texture;

public class Enemy implements Entity {

	private int width, height, currentCheckpoint, scorePoints, enemyGold;
	private float speed, x, y, health, startHealth, hiddenHealth;
	private Texture texture, healthBackground, healthForeground, healthBorder;
	private Tile startTile;
	private boolean first, alive;
	private Grid grid;
	private ArrayList<Checkpoint> checkpoints;
	private int[] directions;
	
	//Default constructor, filled with default values
	public Enemy(int tileX, int tileY, Grid grid){
		this.texture = QuickLoad("enemyTroll");
		this.startTile = grid.getTile(tileX, tileY);
		this.width = TILE_SIZE;
		this.height = TILE_SIZE;
		this.speed = 40;
		this.health = 5;
		this.scorePoints = 10;
		this.enemyGold = 10;
		setupEnemy(grid);
		populateCheckpointList();
	}
	
	//Enhanced constructor
	public Enemy(Texture texture, Tile startTile, Grid grid, int width, int height, float speed, float health, int scorePoints, int enemyGold){
		this.texture = texture;
		this.startTile = startTile;
		this.width = width;
		this.height = height;
		this.speed = speed;
		this.health = health;
		this.scorePoints = scorePoints;
		this.enemyGold = enemyGold;
		setupEnemy(grid);
		populateCheckpointList();
	}
	
	private void setupEnemy(Grid g){
		this.healthBackground = QuickLoad("healthbarBackground");
		this.healthForeground = QuickLoad("healthbarForeground");
		this.healthBorder = QuickLoad("healthbarBorder");
		this.x = startTile.getX();
		this.y = startTile.getY();
		this.startHealth = health;
		this.hiddenHealth = health;
		this.grid = g;
		this.first = true;
		this.alive = true;
		this.checkpoints = new ArrayList<Checkpoint>();
		this.directions = new int[2];
		this.directions[0] = 0; // X direction 
		this.directions[1] = 0; // Y direction
		this.directions = findNextD(startTile);
		this.currentCheckpoint = 0;
	}
	
	public void update(){
		// Check if it's the first time this class is updated, is so do nothing
		if (first)
			first = false;
		else {
			if (checkpointReached()){
				// Check if there are more checkpoints before moving on
				if (currentCheckpoint + 1 == checkpoints.size())
					endOfMazeReached();
				else
					currentCheckpoint++;
			} else {
				// if not at a Checkpoint, continue going in the current direction
				x += Delta() * checkpoints.get(currentCheckpoint).getxDircetion() * speed;
				y += Delta() * checkpoints.get(currentCheckpoint).getyDirection() * speed;
			}
		}		
	}
	
	private void endOfMazeReached() {
		Player.ModifyLives(-1);
		alive = false;
	}
	
	private boolean checkpointReached() {
		boolean reached = false;
		Tile t = checkpoints.get(currentCheckpoint).getTile();
		
		// Check if Checkpoint is reached, within variance of 3 (arbitrary)
		if (x > t.getX() - 3 && x < t.getX() + 3 && y > t.getY() - 3 && y < t.getY() + 3) {
			reached = true;
			x = t.getX();
			y = t.getY();
		}
		
		return reached;
	}
	
	private void populateCheckpointList(){
		// Add first Checkpoint manually based on startTile
		checkpoints.add(findNextC(startTile, directions = findNextD(startTile)));
		
		int counter = 0; 
		boolean cont = true; 
		
		while (cont) {
			int[] currentD = findNextD(checkpoints.get(counter).getTile());
			// Check if a next direction/checkpoint exists, end after 20 checkpoints (arbitrary)
			if (currentD[0] == 2 || counter == 20) {
				cont = false;
			} else {
				checkpoints.add(findNextC(checkpoints.get(counter).getTile(), directions = findNextD(checkpoints.get(counter).getTile())));
			}
			counter++;
		}
	}
	
	private Checkpoint findNextC(Tile s, int[] dir) {
		Tile next = null;
		Checkpoint c = null;
		
		boolean found = false; // Boolean to decide if next checkpoint is found
		int counter = 1; // Integer to increment each loop
		
		while (!found) {
			if (s.getXPlace() + dir[0] * counter == grid.getTilesWide() || s.getYPlace() + dir[1] * counter == grid.getTilesHigh() || s.getType() != grid.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace() + dir[1] * counter).getType()){
				found = true;
				counter -= 1; // count back to find tile before new tileType
				next = grid.getTile(s.getXPlace() + dir[0] * counter, s.getYPlace() + dir[1] * counter);
			}
			counter++;
		}
		
		c = new Checkpoint(next, dir[0], dir[1]);
		return c;
	}
	
	private int[] findNextD(Tile s){
		int[] dir = new int[2];
		Tile u = grid.getTile(s.getXPlace(), s.getYPlace() - 1);
		Tile r = grid.getTile(s.getXPlace() + 1, s.getYPlace());
		Tile d = grid.getTile(s.getXPlace(), s.getYPlace() + 1);
		Tile l = grid.getTile(s.getXPlace() - 1, s.getYPlace());
		
		// Check if current inhabited tileType matches tileType above, right, down or left
		if (s.getType() == u.getType() && directions[1] != 1){
			dir[0] = 0; 
			dir[1] = -1;
		} else if (s.getType() == r.getType() && directions[0] != -1) {
			dir[0] = 1; 
			dir[1] = 0;
		} else if (s.getType() == d.getType() && directions[1] != -1) {
			dir[0] = 0; 
			dir[1] = 1;
		} else if (s.getType() == l.getType() && directions[0] != 1) {
			dir[0] = -1; 
			dir[1] = 0;
		} else {
			dir[0] = 2;
			dir[1] = 2;
		}
		
		return dir;
	}
	
	// Take damage from external source
	public void damage(int amount) {
		health -= amount;
		if(health <= 0) {
			die();
		}
	}
	
	private void die() {
		alive = false;
		Player.ModifyScore(scorePoints);
		Player.ModifyGold(enemyGold);
	}
	
	public void draw(){
		float healthPercentage = health / startHealth;
		DrawQuadTex(texture, x, y, width, height);
		DrawQuadTex(healthBackground, x, y - TILE_SIZE / 4, width, TILE_SIZE / 8);
		DrawQuadTex(healthForeground, x, y - TILE_SIZE / 4, TILE_SIZE * healthPercentage, TILE_SIZE / 8);
		DrawQuadTex(healthBorder, x, y - TILE_SIZE / 4, width, TILE_SIZE / 8);
	}

	public void reduceHiddenHealth(float amount) {
		hiddenHealth -= amount;
	}
	
	public float getHiddenHealth() {
		return hiddenHealth;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public Texture getTexture() {
		return texture;
	}

	public void setTexture(Texture texture) {
		this.texture = texture;
	}
	
	public void setTexture(String textureName){
		this.texture = QuickLoad(textureName);
	}

	public Tile getStartTile() {
		return startTile;
	}

	public void setStartTile(Tile startTile) {
		this.startTile = startTile;
	}

	public boolean isFirst() {
		return first;
	}

	public void setFirst(boolean first) {
		this.first = first;
	}
	
	public Grid getGrid(){
		return grid;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public int getScorePoints(){
		return scorePoints;
	}
	
	public void setScorePoints(int scorePoints){
		this.scorePoints = scorePoints;
	}
	
	public int getEnemyGold(){
		return enemyGold;
	}
	
	public void setEnemyGold(int enemyGold){
		this.enemyGold = enemyGold;
	}
}
