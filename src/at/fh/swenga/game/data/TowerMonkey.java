package at.fh.swenga.game.data;

import java.util.concurrent.CopyOnWriteArrayList;

public class TowerMonkey extends Tower{

	public TowerMonkey(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}

	// This tower does not reduce the hidden health of enemies on purpose. The tower is designed to handicap the player.
	@Override
	public void shoot(Enemy target) {
		super.projectiles.add(new ProjectileFruit(super.type.projectile, super.target, super.getX(), super.getY(), super.getWidth(), super.getHeight()));
	}
}
