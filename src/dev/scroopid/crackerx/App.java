package dev.scroopid.crackerx;

import dev.scroopid.crackerx.levels.MainMenu;
import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.CrafexActivity;
import dev.scroopid.crafexEngine.graphics.GraphicsManager;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.util.intPoint;
import android.graphics.Color;

public class App extends CrafexActivity {

	@Override
	public void beforeCreated() {
		setDefaultResolution(new intPoint(1280, 720));
		removeTitle();
		setLandscape();
		setFullScreen(true);
		setDefaultColor(Color.WHITE);
		setFPS(60);
	}

	@Override
	public void afterCreated() {
		loadTextures();
		setLevel(new MainMenu());
	}
	
	public void loadTextures(){
		GraphicsManager.addImage("button", 
				GraphicsUtil.loadAssestImage("images/GUI/buttons/button.png"));
		GraphicsManager.addImage("text", 
				GraphicsUtil.loadAssestImage("images/GUI/fonts/ascii.png"));
		GraphicsManager.addImage("stick", GraphicsUtil.loadAssestImage("images/GUI/stick.png"));
		GraphicsManager.addImage("base", GraphicsUtil.loadAssestImage("images/GUI/base.png"));
	}

}
