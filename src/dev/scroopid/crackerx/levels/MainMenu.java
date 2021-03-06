package dev.scroopid.crackerx.levels;

import java.util.List;

import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.entity.Entity;
import dev.scroopid.crafexEngine.graphics.GraphicsManager;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.UIButton;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.util.Util;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;
import dev.scroopid.crafexEngine.util.intRectangle;

public class MainMenu extends Level{
	
	public MainMenu(){
		super();
		UILayer layerone = new UILayer(new intRectangle(new intPoint(),
				Crafex.WINDOW_DIMENTIONS.clone(), 0));
		
		UIButton test = new UIButton(GraphicsUtil.makeTextButtonImage("play", 
				GraphicsManager.getImageFromKey("button"),
				GraphicsManager.getImageFromKey("text"), new intPoint(12, 8),
				GraphicsUtil.STRETCH_CUT), 
				new floatPoint(-150f, -150f), 0, 1.2f){
			
			@Override
			public void whenHeld(CrafexTouchEvent touch) {
		
			}
			
			@Override
			public void whenReleased(CrafexTouchEvent touch) {
				if(touch != null){
					play();
				}
				super.whenReleased(touch);
			}
		};
		
		test.setTargetLocation(Crafex.WINDOW_DIMENTIONS.getX() / 2,
				Crafex.WINDOW_DIMENTIONS.getY() / 2);
		test.setSpeed((int) Util.pixelScale(75));
		layerone.addUIObject(test);
		addLayer(layerone);
	}
	
	public void play(){
		Crafex.levelMan.setLevel(new Game());
	}
	
	@Override
	public List<Entity> getEntities() {
		return null;
	}
	
}
