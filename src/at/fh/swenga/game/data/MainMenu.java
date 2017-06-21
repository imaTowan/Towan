package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.*;
import static at.fh.swenga.game.helpers.Scorer.*;

import org.lwjgl.input.Mouse;

import at.fh.swenga.game.UI.UI;
import at.fh.swenga.game.dependencies.slick.Texture;
import at.fh.swenga.game.helpers.StateManager;
import at.fh.swenga.game.helpers.StateManager.GameState;

public class MainMenu {

	private int highScore;
	private Texture background;
	private UI menuUI;
	
	public MainMenu() {
		this.highScore = 1;
		this.background = QuickLoad("backgroundMainMenu");
		this.menuUI = new UI();
		menuUI.addButton("Play", "buttonPlay", (WIDTH + MENU_WIDTH) / 2 - 128, (int) (HEIGHT * 0.45f));
		menuUI.addButton("Editor", "buttonEditor", (WIDTH + MENU_WIDTH) / 2 - 128, (int) (HEIGHT * 0.60f));
		menuUI.addButton("Quit", "buttonQuit", (WIDTH + MENU_WIDTH) / 2 - 128, (int) (HEIGHT * 0.75f));
	}
	
	// Check if a button is clicked and perform appropriate actions
	private void updateButton() {
		if (Mouse.isButtonDown(0)) {
			if (menuUI.isButtonClicked("Play"))
				StateManager.setState(GameState.GAME);
			if (menuUI.isButtonClicked("Editor"))
				StateManager.setState(GameState.EDITOR);
			if (menuUI.isButtonClicked("Quit"))
				menuUI.drawString((WIDTH + MENU_WIDTH) / 2 - 112, (int) (HEIGHT * 0.75f) + 65, "Just press Alt + F4, it's faster.");
		}
	}
	
	public void update() {
		if (Player.GameOver == true){
			Player.GameOver = false;
		}
		
		if (highScore == 1){
			if (LoadScore(HIGHSCORE_FILENAME) == 0) {
				highScore = 0;
				SaveScore(HIGHSCORE_FILENAME, highScore);
			}
			else
				highScore = LoadScore(HIGHSCORE_FILENAME);
		}
		
		if (highScore == 0)
			if (Player.Score > highScore)
				highScore = Player.Score;
		
		DrawQuadTex(background, 0 , 0, 2048, 1024);
		menuUI.draw();
		updateButton();
		if (highScore > 0)
			menuUI.drawString(350, 160, "Current Highscore: " + highScore + " Points");
		if (Player.Score > 0)
			menuUI.drawString(350, 190, "You scored " + Player.Score + " Points!");
		if (Player.Score > Player.HighScore)
			menuUI.drawString(350, 220, "NEW HIGHSCORE!");
	}
}