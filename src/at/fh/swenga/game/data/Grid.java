package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;

public class Grid {

	public Tile[][] map;
	private int tilesWide, tilesHigh;
	
	public Grid(){
		this.tilesWide = WIDTH / TILE_SIZE;
		this.tilesHigh = HEIGHT / TILE_SIZE;
		this.map = new Tile[tilesWide][tilesHigh];
		
		for(int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Grass);
			}
		}
	}
	
	public Grid(int[][] newMap){
		this.tilesWide = newMap[0].length;
		this.tilesHigh = newMap.length;
		map = new Tile[tilesWide][tilesHigh];
		for(int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				switch (newMap[j][i]){
				case 0:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Grass);
					break;
				case 1:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Dirt);
					break;
				case 2:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Water);
					break;
				case 3:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.DirtStone);
					break;
				case 4:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.StoneFloor);
					break;
				case 5:
					map[i][j] = new Tile(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE, TileType.Sand);
					break;
				}
			}
		}
	}
	
	public void setTile(int xCoord, int yCoord, TileType type){
		map[xCoord][yCoord] = new Tile(xCoord * TILE_SIZE, yCoord * TILE_SIZE, TILE_SIZE, TILE_SIZE, type);
	}
	
	public Tile getTile(int xPlace, int yPlace){
		if (xPlace < tilesWide && yPlace < tilesHigh && xPlace > -1 && yPlace > -1)
			return map[xPlace][yPlace];
		else
			return new Tile(0,0,0,0,TileType.NULL);
	}
	
	public void draw(){
		for(int i = 0; i < map.length; i++){
			for (int j = 0; j < map[i].length; j++){
				if (map[i][j] != null)
					map[i][j].draw();
			}
		}
	}

	public int getTilesWide() {
		return tilesWide;
	}

	public void setTilesWide(int tilesWide) {
		this.tilesWide = tilesWide;
	}

	public int getTilesHigh() {
		return tilesHigh;
	}

	public void setTilesHigh(int tilesHigh) {
		this.tilesHigh = tilesHigh;
	}
}
