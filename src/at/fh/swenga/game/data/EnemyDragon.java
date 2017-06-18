package at.fh.swenga.game.data;

public class EnemyDragon extends Enemy{

	public EnemyDragon(int tileX, int tileY, Grid grid) {
		super(tileX, tileY, grid);
		this.setTexture("enemyDragon");
		this.setSpeed(60);
		this.setHealth(50);
		this.setScorePoints(100);
		this.setEnemyGold(20);
	}
}
