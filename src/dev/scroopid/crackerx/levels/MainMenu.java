package dev.scroopid.crackerx.levels;

import dev.scroopid.crackerx.graphics.Graphics;
import dev.scroopid.crafexEngine.Crafex;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.UIButton;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.ui.UIObject;
import dev.scroopid.crafexEngine.ui.Input.JoyStick;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;
import dev.scroopid.crafexEngine.util.intRectangle;

public class MainMenu extends Level{
	
	public MainMenu(){
		super();
		UILayer layerone = new UILayer(new intRectangle(new intPoint(),
				Crafex.WINDOW_DIMENTIONS.clone(), 0));
		
		JoyStick stick = new JoyStick(Graphics.base, Graphics.stick, new floatPoint(500, 500), 0);
		UIButton test = new UIButton(GraphicsUtil.makeTextButtonImage("test", Graphics.defaultButton,
				Graphics.purple_text, new intPoint(6, 6), true), 
				new floatPoint(Crafex.WINDOW_DIMENTIONS.getX() / 2, 
						Crafex.WINDOW_DIMENTIONS.getY() / 2), 15, 1.2f, 0){
			
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
		layerone.addUIObject(stick);
//		layerone.addUIObject(test);
		addLayer(layerone);
	}
	
}
