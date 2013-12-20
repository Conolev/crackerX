package dev.scroopid.crackerx.levels;

import dev.scroopid.crackerx.graphics.Graphics;
import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.Button;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;
import dev.scroopid.crafexEngine.util.intRectangle;

public class MainMenu extends Level{
	
	public MainMenu(){
		super();
		UILayer layerone = new UILayer(new intRectangle(new intPoint(),
				Crafex.WINDOW_DIMENTIONS.clone()));
		Button test = new Button(GraphicsUtil.makeTextButtonImage("test", Graphics.defaultButton,
				Graphics.purple_text, new intPoint(6, 6), true), 
				new floatPoint(200, 200), 0){
			
			@Override
			public boolean isTouching(CrafexTouchEvent touch) {
				if(this.touch != null)
					return true;
				return super.isTouching(touch);
			}
			
			@Override
			public void whenHeld(CrafexTouchEvent touch) {
				if(this.touch != null && touch != null){
					intPoint temp = touch.getTouchLocation().clone().subtract(this.touch.getTouchLocation().clone());
					setTargetLocation(getTargetLocation().add(temp));
					this.touch = touch;
				}
			}
			
			@Override
			public boolean isActive() {
				return true;
			}
			
		};
		test.setSpeed(10000000);
		layerone.addUIObject(test);
		addLayer(layerone);
	}
	
}
