package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;
import static at.fh.swenga.game.helpers.Leveler.LoadMap;
import static at.fh.swenga.game.helpers.Leveler.SaveMap;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import at.fh.swenga.game.UI.UI;
import at.fh.swenga.game.UI.UI.Menu;
import at.fh.swenga.game.dependencies.slick.Texture;
import at.fh.swenga.game.helpers.StateManager;
import at.fh.swenga.game.helpers.StateManager.GameState;

public class Editor {

	private Grid grid;
	private int index;
	private TileType[] types;
	private UI editorUI;
	private Menu tilePickerMenu;
	private Texture menuBackground;
	
	public Editor() {
		this.grid = LoadMap(MAP_NAME);
		this.index = 0;
		this.menuBackground = QuickLoad("backgroundTilePicker");
		setupTypes();
		setupUI();
	}

	private void setupTypes() {
		this.types = new TileType[7];
		this.types[0] = TileType.Grass;
		this.types[1] = TileType.Dirt;
		this.types[2] = TileType.Water;
		this.types[3] = TileType.DirtStone;
		this.types[4] = TileType.StoneFloor;
		this.types[5] = TileType.Sand;
		this.types[6] = TileType.Crystal;
	}
	
	private void setupUI() {
		this.editorUI = new UI();
		editorUI.createMenu("TilePicker", WIDTH, TILE_SIZE * 2, MENU_WIDTH, HEIGHT, 2, 0);
		this.tilePickerMenu = editorUI.getMenu("TilePicker");
		tilePickerMenu.quickAdd("Grass", "_grass");
		tilePickerMenu.quickAdd("Dirt", "_dirt");
		tilePickerMenu.quickAdd("Water", "_water");
		tilePickerMenu.quickAdd("DirtStone", "_dirtStone");
		tilePickerMenu.quickAdd("StoneFloor", "_stoneFloor");
		tilePickerMenu.quickAdd("Sand", "_sand");
		tilePickerMenu.quickAdd("Crystal", "_crystal");
	}
	
	public void update() {
		draw();
		editorUI.drawString(WIDTH + 3, HEIGHT / 2, "Press 's' to");
		editorUI.drawString(WIDTH + 3, HEIGHT / 2 + 20, "save this");
		editorUI.drawString(WIDTH + 3, HEIGHT / 2 + 40, "map!");
		editorUI.drawString(WIDTH + 3, HEIGHT / 2 + 80, "Press 'm' to");
		editorUI.drawString(WIDTH + 3, HEIGHT / 2 + 100, "return to");
		editorUI.drawString(WIDTH + 3, HEIGHT / 2 + 120, "the menu!");
		
		// Mouse Input
		if (Mouse.next()){
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (tilePickerMenu.isButtonClicked("Grass")) {
					index = 0;
				} else if (tilePickerMenu.isButtonClicked("Dirt")){
					index = 1;
				} else if (tilePickerMenu.isButtonClicked("Water")) {
					index = 2;
				} else if (tilePickerMenu.isButtonClicked("DirtStone")) {
					index = 3;
				} else if (tilePickerMenu.isButtonClicked("StoneFloor")) {
					index = 4;
				} else if (tilePickerMenu.isButtonClicked("Sand")) {
					index = 5;
				} else if (tilePickerMenu.isButtonClicked("Crystal")) {
					index = 6;
				} else {
					if (Mouse.getX() < WIDTH)
						setTile();
				}
			}
		}

		// Keyboard Input
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) {
				SaveMap(MAP_NAME, grid);
				StateManager.checkMap = 0;
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_M && Keyboard.getEventKeyState()) {
				StateManager.setState(GameState.MAINMENU);
			}
		}
	}

	private void draw() {
		DrawQuadTex(menuBackground, WIDTH, 0, MENU_WIDTH, HEIGHT);
		grid.draw();
		editorUI.draw();
	}
	
	private void setTile() {
		grid.setTile((int) Math.floor(Mouse.getX() / TILE_SIZE), (int) Math.floor((HEIGHT - Mouse.getY() - 1) / TILE_SIZE),	types[index]);
	}
}
