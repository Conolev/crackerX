package dev.scroopid.crackerx.levels;

import dev.scroopid.crackerx.graphics.Graphics;
import dev.scroopid.crafexEngine.graphics.GraphicsUtil;
import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.Button;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.util.floatPoint;
import dev.scroopid.crafexEngine.util.intPoint;

public class MainMenu extends Level{
	
	public MainMenu(){
		super();
		UILayer layerone = new UILayer();
		Button test = new Button(GraphicsUtil.makeTextButtonImage("test", Graphics.defaultButton,
				Graphics.purple_text, new intPoint(6, 6), true), 
				new floatPoint(200, 200), 0){
			@Override
			public void whenPressed(CrafexTouchEvent touch) {
				if(getLocation().getX() == 200){
					setTargetLocation(500, 500);
				}else{
					setTargetLocation(200, 200);
				}
			}
			
		};
		layerone.addUIObject(test);
		addLayer(layerone);
	}
	
}
