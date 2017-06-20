package at.fh.swenga.game.data;

public class EnemyOgre extends Enemy{

	public EnemyOgre(int tileX, int tileY, Grid grid) {
		super(tileX, tileY, grid);
		this.setTexture("enemyOgre");
		this.setSpeed(50);
		this.setHealth(15);
		this.setScorePoints(50);
		this.setEnemyGold(15);
	}
}
