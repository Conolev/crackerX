package dev.scroopid.crackerx.levels;

import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.UIButton;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.ui.Input.JoyStick;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;
import dev.scroopid.crafexEngine.util.intRectangle;

public class Game extends Level{
	
	private UILayer pauseLayer = new UILayer(new intRectangle(new intPoint(), 
			Crafex.WINDOW_DIMENTIONS.clone(), 0));
	
	public Game() {
		UILayer gameLayer = new UILayer(new intRectangle(new intPoint(),
				Crafex.WINDOW_DIMENTIONS.clone(), 0));
		
		
		JoyStick stick = new JoyStick(Crafex.graphicsMan.getImageFromKey("base"), 
				Crafex.graphicsMan.getImageFromKey("stick"), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() - 120,
						Crafex.WINDOW_DIMENTIONS.getY() - 120), 0);
		char pause = '~' + 1;
		UIButton pauseButton = new UIButton(GraphicsUtil.makeTextButtonImage(String.valueOf(pause), 
				Crafex.graphicsMan.getImageFromKey("button"),
				Crafex.graphicsMan.getImageFromKey("text"), new intPoint(6, 6), true), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() - 50, 50), 0, 1.2f, 0){
			@Override
			public void whenReleased(CrafexTouchEvent touch) {
				super.whenPressed(touch);
				pause();
			}
		};
		
		UIButton resume = new UIButton(GraphicsUtil.makeTextButtonImage("resume", 
				Crafex.graphicsMan.getImageFromKey("button"),
				Crafex.graphicsMan.getImageFromKey("text"), new intPoint(6, 6), true), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() / 2, 
						Crafex.WINDOW_DIMENTIONS.getY() / 2), 0, 1.2f, 0){
			@Override
			public void whenReleased(CrafexTouchEvent touch) {
				super.whenPressed(touch);
				unpause();
			}
		};
		
		
		gameLayer.addUIObject(stick);
		gameLayer.addUIObject(pauseButton);
		pauseLayer.addUIObject(resume);
		addLayer(gameLayer);
	}
	
	public void unpause(){
		uiscreen.removeLayer();
	}
	
	public void pause(){
		addLayer(pauseLayer);
	}
	
}
