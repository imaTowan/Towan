package at.fh.swenga.game.data;

import static at.fh.swenga.game.helpers.Artist.BeginSession;

import org.lwjgl.opengl.Display;

import at.fh.swenga.game.helpers.Clock;
import at.fh.swenga.game.helpers.StateManager;

public class Boot {
	
	public Boot(){
		
		// BeginSession Call initializes OpenGL calls
		BeginSession();

		// Main game loop
		while(!Display.isCloseRequested()){
			Clock.Update();
			StateManager.Update();
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	public void main(){
		new Boot();
	}
}
