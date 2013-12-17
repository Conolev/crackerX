package dev.scroopid.crackerx;

import dev.scroopid.crackerx.graphics.Graphics;
import dev.scroopid.crafexEngine.AppActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class App extends AppActivity {

	@Override
	public void beforeCreated() {
		removeTitle();
		setLandscape();
		setFullScreen(true);
	}

	@Override
	public void afterCreated() {
		Graphics.loadTextures();
	}

}
