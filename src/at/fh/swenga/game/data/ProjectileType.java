package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;

import at.fh.swenga.game.dependencies.slick.Texture;

public enum ProjectileType {

		ProjectileFruit(QuickLoad("projectileFruit"), 10, 100),
		ProjectileStone(QuickLoad("projectileStone"), 20, 300),
		ProjectileIce(QuickLoad("projectileIce"), 100, 500),
		ProjectileLightning(QuickLoad("projectileLightning"), 2, 1000);
		
		Texture texture;
		int damage;
		float speed;
		
		ProjectileType(Texture texture, int damage, float speed){
			this.texture = texture;
			this.damage = damage;
			this.speed = speed;
		}
}
