package at.fh.swenga.game.data;

public class WaveManager {

	private float timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy[] enemyTypes;
	private Wave currentWave;
	
	public WaveManager(Enemy[] enemyTypes, float timeBetweenEnemies, int enemiesPerWave) {
		this.enemyTypes = enemyTypes;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave = enemiesPerWave;
		this.waveNumber = 0;
		this.currentWave = null;
		newWave();
	}
	
	public void update() {
		if (!currentWave.isCompleted())
			currentWave.update();
		else
			newWave();
	}
	
	private void newWave() {
		if (waveNumber > 1)
			for (Enemy e: enemyTypes)
				e.setHealth((int) Math.floor(e.getHealth() * waveNumber / 2));
		currentWave = new Wave(enemyTypes, timeBetweenEnemies, enemiesPerWave);
		waveNumber++;
	}
	
	public Wave getCurrentWave() {
		return currentWave;
	}

	public int getWaveNumber() {
		return waveNumber;
	}
}
