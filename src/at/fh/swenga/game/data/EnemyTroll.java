package at.fh.swenga.game.data;

public class EnemyTroll extends Enemy {

	public EnemyTroll(int tileX, int tileY, Grid grid) {
		super(tileX, tileY, grid);
		this.setTexture("enemyTroll");
		this.setSpeed(100);
		this.setHealth(5);
		this.setScorePoints(10);
		this.setEnemyGold(5);
	}
}
