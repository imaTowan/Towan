package at.fh.swenga.game.data;

import java.util.concurrent.CopyOnWriteArrayList;

public class TowerLightning extends Tower{

	public TowerLightning(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}

	@Override
	public void shoot(Enemy target) {
		super.projectiles.add(new ProjectileLightning(super.type.projectile, super.target, super.getX(), super.getY(), super.getWidth(), super.getHeight()));
		super.target.reduceHiddenHealth(super.type.projectile.damage);
	}
}
