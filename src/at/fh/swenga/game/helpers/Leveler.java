package at.fh.swenga.game.helpers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import at.fh.swenga.game.data.Grid;
import at.fh.swenga.game.data.Tile;
import at.fh.swenga.game.data.TileType;

public class Leveler {

	public static void SaveMap(String mapName, Grid grid){ 
		String mapData = "";
		
		for (int i = 0; i < grid.getTilesWide(); i++) {
			for (int j = 0; j < grid.getTilesHigh(); j++) {
				mapData += getTileID(grid.getTile(i,j));
			}
		}
		
		try {
			File file = new File(mapName);
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Grid LoadMap(String mapName) {
		Grid grid = new Grid();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			String data = br.readLine();
			
			for (int i = 0; i < grid.getTilesWide(); i++){
				for (int j = 0; j < grid.getTilesHigh(); j++){
					grid.setTile(i, j, getTileType(data.substring(i * grid.getTilesHigh() + j, i * grid.getTilesHigh() + j + 1)));
				}
			}
			
			br.close();
		} catch (Exception e) {
			return null;
		}
		
		return grid;
	}
	
	public static TileType getTileType(String ID) {
		TileType type = TileType.NULL;
		
		switch (ID) {
		case "0":
			type = TileType.Grass;
			break;
		case "1":
			type = TileType.Dirt;
			break;
		case "2":
			type = TileType.Water;
			break;
		case "3":
			type = TileType.DirtStone;
			break;
		case "4":
			type = TileType.StoneFloor;
			break;
		case "5":
			type = TileType.Sand;
			break;
		case "6":
			type = TileType.Crystal;
			break;
		case "7":
			type = TileType.NULL;
			break;
		}
		
		return type;
	}
	
	public static String getTileID(Tile t) {
		String ID = "E";
		
		if(t == null)
			return "7";
		
		switch (t.getType()) {
		case Grass:
			ID = "0";
			break;
		case Dirt:
			ID = "1";
			break;
		case Water:
			ID = "2";
			break;
		case DirtStone:
			ID = "3";
			break;
		case StoneFloor:
			ID = "4";
			break;
		case Sand:
			ID = "5";
			break;
		case Crystal:
			ID = "6";
			break;
		case NULL:
			ID = "7";
			break;
		}
		
		return ID;
	}
}
