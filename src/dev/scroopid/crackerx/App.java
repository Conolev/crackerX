package dev.scroopid.crackerx;

import dev.scroopid.crackerx.levels.MainMenu;
import dev.scroopid.crafexEngine.AppActivity;
import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.util.intPoint;
import android.graphics.Color;

public class App extends AppActivity {

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
		Crafex.graphicsMan.addImage("button", 
				GraphicsUtil.loadAssestImage("images/GUI/buttons/button.png"));
		Crafex.graphicsMan.addImage("text", 
				GraphicsUtil.loadAssestImage("images/GUI/fonts/purple_text.png"));
		Crafex.graphicsMan.addImage("stick", 
				GraphicsUtil.loadAssestImage("images/GUI/stick.png"));
		Crafex.graphicsMan.addImage("base", 
				GraphicsUtil.loadAssestImage("images/GUI/base.png"));
	}

}
