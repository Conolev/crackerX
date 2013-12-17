package dev.scroopid.crackerx;

import dev.scroopid.crackerx.graphics.Graphics;
import dev.scroopid.crackerx.levels.MainMenu;
import dev.scroopid.crafexEngine.AppActivity;
import dev.scroopid.crafexEngine.util.intPoint;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class App extends AppActivity {

	@Override
	public void beforeCreated() {
		setDefaultResolution(new intPoint(1280, 720));
		removeTitle();
		setLandscape();
		setFullScreen(true);
	}

	@Override
	public void afterCreated() {
		Graphics.loadTextures();
		setLevel(new MainMenu());
	}

}
