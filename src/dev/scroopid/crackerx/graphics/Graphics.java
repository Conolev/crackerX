package dev.scroopid.crackerx.graphics;

import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import android.graphics.Bitmap;

public class Graphics {
	public static Bitmap defaultButton;
	public static Bitmap purple_text;
	
	public Graphics(){
		
	}
	
	public static void loadTextures(){
		defaultButton = GraphicsUtil.loadAssestImage("images/GUI/buttons/button.png");
		purple_text = GraphicsUtil.loadAssestImage("images/GUI/fonts/purple_text.png");
	}
}