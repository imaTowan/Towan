package at.fh.swenga.game.data;

public enum TileType {

	Grass("_grass", true),
	Dirt("_dirt", false), 
	Water("_water", false), 
	DirtStone("_dirtStone", false),
	StoneFloor("_stoneFloor", false),
	Sand("_sand", true),
	Crystal("_crystal", false),
	NULL("_water", false);
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		this.textureName = textureName;
		this.buildable = buildable;
	}
}
