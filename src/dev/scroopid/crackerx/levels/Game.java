package dev.scroopid.crackerx.levels;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.entity.Entity;
import dev.scroopid.crafexEngine.graphics.GraphicsManager;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.UIButton;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.ui.Input.JoyStick;
import dev.scroopid.crafexEngine.util.Util;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;
import dev.scroopid.crafexEngine.util.intRectangle;

public class Game extends Level{
	
	private List<Entity> entitys = new ArrayList<Entity>();
	private Bitmap background;
	private JoyStick stick;
	
	private UILayer pauseLayer = new UILayer(new intRectangle(new intPoint(), 
			Crafex.WINDOW_DIMENTIONS.clone(), 0));
	
	public Game() {
		UILayer gameLayer = new UILayer(new intRectangle(new intPoint(),
				Crafex.WINDOW_DIMENTIONS.clone(), 0));
		
		
		stick = new JoyStick(GraphicsManager.getImageFromKey("base"), 
				GraphicsManager.getImageFromKey("stick"), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() - 120,
						Crafex.WINDOW_DIMENTIONS.getY() - 120));
		
		UIButton pauseButton = new UIButton(GraphicsUtil.makeTextButtonImage(String.valueOf(Util.PAUSE), 
				GraphicsManager.getImageFromKey("button"),
				GraphicsManager.getImageFromKey("text"), new intPoint(12, 8),
				GraphicsUtil.STRETCH_CUT), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() - 50, 50), 0, 1.2f){
			@Override
			public void whenReleased(CrafexTouchEvent touch) {
				super.whenPressed(touch);
				pause();
			}
		};
		
		UIButton resume = new UIButton(GraphicsUtil.makeTextButtonImage("resume", 
				GraphicsManager.getImageFromKey("button"),
				GraphicsManager.getImageFromKey("text"), new intPoint(12, 8), 
				GraphicsUtil.STRETCH_CUT), new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() / 2, 
						Crafex.WINDOW_DIMENTIONS.getY() / 2), 0, 1.2f){
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
	
	@Override
	public void draw(Canvas canvas) {
		if(background != null){
			
		}
		super.draw(canvas);
	}
	
	@Override
	public List<Entity> getEntities() {
		return entitys;
	}
	
	@Override
	public void update() {
		super.update();
	}
}
