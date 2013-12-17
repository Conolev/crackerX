package dev.scroopid.crackerx.levels;

import dev.scroopid.crafexEngine.input.CrafexTouchEvent;
import dev.scroopid.crafexEngine.level.Level;
import dev.scroopid.crafexEngine.ui.Button;
import dev.scroopid.crafexEngine.ui.UILayer;
import dev.scroopid.crafexEngine.util.floatPoint;

public class MainMenu extends Level{
	
	public MainMenu(){
		super();
		UILayer layerone = new UILayer();
		Button test = new Button(null, new floatPoint(200, 200), 1, null){
			@Override
			public void whenPressed(CrafexTouchEvent touch) {
				if(getLocation().getX() == 200){
					setTargetLocation(500, 500);
				}else{
					setTargetLocation(200, 200);
				}
			}
			
		};
		addLayer(layerone);
	}
	
}
