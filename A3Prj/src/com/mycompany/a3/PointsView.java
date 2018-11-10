/* 
 * Oscar Esparza
 * Created : 3 October 2018
 * Updated : 7 October 2018
 * PointsView.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

public class PointsView extends Container implements Observer{
	private Label pointsValueLabel;
	private Label gameTimeLabel;
	private Label soundLabel;
	private Label missileNumberLabel;
	private Label livesNumberLabel;
	
	public PointsView()
	{
		// Instantiate text labels
		Label pointsTextLabel = new Label("Points: ");
		// Instantiating Value labels
		pointsValueLabel = new Label("XXX");
		// set Color
		pointsTextLabel.getAllStyles().setFgColor(ColorUtil.rgb(67, 97, 246));
		
		Label timeElapsedLabel = new Label("Elapsed Time: ");
		gameTimeLabel = new Label ("XXX");									//Instantiate Value Labels
		timeElapsedLabel.getAllStyles().setFgColor(ColorUtil.rgb(67, 97, 246));		//set color
		
		Label missileCountLabel = new Label("Missile count: ");
		missileNumberLabel = new Label ("XXX");
		missileCountLabel.getAllStyles().setFgColor(ColorUtil.rgb(67, 97, 246));		//set color
		
		Label soundToggleLabel = new Label("Sound: ");
		soundLabel = new Label("XXX");
		soundToggleLabel.getAllStyles().setFgColor(ColorUtil.rgb(67, 97, 246));		//set color
		
		Label livesLabel = new Label("Lives: ");
		livesNumberLabel = new Label("XXX");
		livesLabel.getAllStyles().setFgColor(ColorUtil.rgb(67, 97, 246));
		
		// Adding a container with boxlayout
		Container myContainer = new Container();
		myContainer.setLayout(new BoxLayout(BoxLayout.X_AXIS));
			
		// Adding all labels in order
		myContainer.add(pointsTextLabel);
		myContainer.add(pointsValueLabel);
		
		myContainer.add(timeElapsedLabel);
		myContainer.add(gameTimeLabel);
		
		myContainer.add(missileCountLabel);
		myContainer.add(missileNumberLabel);
		
		myContainer.add(soundToggleLabel);
		myContainer.add(soundLabel);
		
		myContainer.add(livesLabel);
		myContainer.add(livesNumberLabel);
		this.add(myContainer);
	}
	public PointsView(GameWorld gw) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable o, Object arg) {
		// casting o as a GameWorld
		IGameWorld gw = (IGameWorld) arg;
		
		int score = gw.getPlayerScore();	// Getting playerScore
		pointsValueLabel.setText(" " + (score > 99 ? " " : "0") + (score > 9 ? " " : "0") + score);
		int time = gw.getTime();			// Getting Time
		gameTimeLabel.setText("" + time);
		int missiles = gw.getMissileCount();// Getting Missile
		missileNumberLabel.setText("" + missiles);
		String soundToggle = gw.getSound();// Getting Soung
		soundLabel.setText("" + soundToggle);
		int lives = gw.getLives();		   // getting lives
		livesNumberLabel.setText("" + lives);
		// Check if dead ....almost forgot to do this..
		// ... its due in an hour and I am testing stuff just in case ....
		if(lives <= 0) {
			Boolean option = Dialog.show("Game Over", "You now floating in oblivion", "This is nice..", "This Sucks");
			if(option) Display.getInstance().exitApplication();
			else Display.getInstance().exitApplication();
		}
		
		this.repaint();
	}

}
