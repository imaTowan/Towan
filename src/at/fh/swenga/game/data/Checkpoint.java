package at.fh.swenga.game.data;

public class Checkpoint {

	private Tile tile;
	private int xDircetion, yDirection;
	
	public Checkpoint(Tile tile, int xDirection, int yDirection){
		this.tile = tile;
		this.xDircetion = xDirection;
		this.yDirection = yDirection;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
		this.tile = tile;
	}

	public int getxDircetion() {
		return xDircetion;
	}

	public void setxDircetion(int xDircetion) {
		this.xDircetion = xDircetion;
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}
}
