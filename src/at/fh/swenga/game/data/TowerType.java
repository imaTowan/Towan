package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.QuickLoad;

import at.fh.swenga.game.dependencies.slick.Texture;

public enum TowerType {

	TowerMonkey(new Texture[]{QuickLoad("towerMonkeyBase"), QuickLoad("towerMonkeyCannon")}, ProjectileType.ProjectileFruit, 64, 1, 5),
	TowerSling(new Texture[]{QuickLoad("towerSlingBase"), QuickLoad("towerSlingCannon")}, ProjectileType.ProjectileStone, 160, 1.5f, 20),
	TowerIce(new Texture[]{QuickLoad("towerIceBase"), QuickLoad("towerIceCannon")}, ProjectileType.ProjectileIce, 500, 3, 250),
	TowerLightning(new Texture[]{QuickLoad("towerLightningBase"), QuickLoad("towerLightningCannon")}, ProjectileType.ProjectileLightning, 320, 0.01f, 400);
	
	Texture[] textures;
	ProjectileType projectile;
	int range, cost;
	float firingSpeed;
	
	TowerType(Texture[] textures, ProjectileType projectile, int range, float firingSpeed, int cost){
		this.textures = textures;
		this.projectile = projectile;
		this.range = range;
		this.firingSpeed = firingSpeed;
		this.cost = cost;
	}
}
