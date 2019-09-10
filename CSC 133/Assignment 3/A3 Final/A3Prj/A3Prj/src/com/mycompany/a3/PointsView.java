package com.mycompany.a3;
import java.util.Observable; 
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

public class PointsView extends Container implements Observer{

	private Label pointsVal;
	private Label missileCountNum;
	private Label elapsedTime;
	private Label soundSetting;
	private Label livesLeft;
	
	
	
	public PointsView() {
	
		this.setLayout(new FlowLayout(LEFT));
		
		setUpPoints();
		setUpMissileCount();
		setUpTime();
		setUpSound();
		setUpLives();		
	
	}
	
	public void gameSetUp()
	{
		setUpPoints();
		setUpMissileCount();
		setUpTime();
		setUpSound();
		setUpLives();
		
		
	}

	private void setUpLives() {
		Label lifeTxt = new Label("Lives:");
		lifeTxt.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		livesLeft = new Label("0");
		livesLeft.getAllStyles().setPadding(RIGHT, 5);
		
		this.add(lifeTxt);
		this.add(livesLeft);
	}

	private void setUpSound() {
		Label soundTxt = new Label("Sound:");
		soundTxt.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundSetting = new Label("OFF");
		soundSetting.getAllStyles().setPadding(RIGHT, 5);
		this.add(soundTxt);
		this.add(soundSetting);
		
		
		
		
	}

	private void setUpTime() {
		Label timeTxt = new Label("Elapsed Time:");
		timeTxt.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		elapsedTime = new Label("0");
		elapsedTime.getAllStyles().setPadding(RIGHT, 5);
		this.add(timeTxt);
		this.add(elapsedTime);
		
		
		
	}

	private void setUpMissileCount() {
		Label missileTxt = new Label("Missile Count:");
		missileTxt.getAllStyles().setPadding(RIGHT, 5);
		this.add(missileTxt);
		missileCountNum = new Label("0");
		missileCountNum.getAllStyles().setPadding(RIGHT, 5);
		this.add(missileCountNum);
		
		
	}

	private void setUpPoints() {
			Label pointsText = new Label("Points:");
			pointsText.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
			pointsVal = new Label("0");
			pointsVal.getAllStyles().setPadding(RIGHT, 5);
			
			Container pointContainer = new Container();
			pointContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			
			pointContainer.add(pointsText);
			pointContainer.add(pointsVal);
			
			this.add(pointContainer);
			
	
	
	}

	@Override
	public void update(Observable observable, Object data) {
		IGameWorld gameProxy = (IGameWorld) data;
		pointsVal.setText(""+Integer.toString(gameProxy.getPoints()));
		missileCountNum.setText(""+Integer.toString(gameProxy.getMissileCount()));
		elapsedTime.setText(""+Integer.toString(gameProxy.getTime()));
		livesLeft.setText(""+Integer.toString(gameProxy.getLives()));
		
		if(gameProxy.getSoundSetting())
		{
			soundSetting.setText("ON");
		}
		else
		{
			soundSetting.setText("OFF");
		}
		this.repaint();

		
	}

}
