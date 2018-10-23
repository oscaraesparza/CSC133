/* 
 * Oscar Esparza
 * Created : 17 September 2018
 * Updated : 21 September 2018
 * Game.java 
 * Homework 1 CSC 133 
 */

package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;

public class Game extends Form{
	private GameWorld gw;
	
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	private void play() {
		Label myLabel = new Label("Enter a Command:");
		this.addComponent(myLabel);
		final TextField myTextField = new TextField();
		this.addComponent(myTextField);
		this.show();
		myTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String sCommand = myTextField.getText().toString();
				myTextField.clear();
				switch (sCommand.charAt(0)) {
					case 'a' : 
						gw.addAsteroid();
						break;
					case 'y' : 
						gw.addNonePlayerShip();
						break; 
					case 'b' :
						gw.addSpaceStation();
						break;
					case 's' :
						gw.addPlayerShip();
						break;
					case 'i' : 
						gw.increaseSpeed();
						break;
					case 'd' :
						gw.decreaseSpeed();
						break;
					case 'l' : 
						gw.turnLeft();
						break;
					case 'r' :
						gw.turnRight();
						break;
					case '<' :
						gw.turnMissleLauncher();
						break;
					case 'f':
						gw.fireMissile();
						break;
					case 'L' :
						gw.launchMissile();
						break;
					case 'j' : 
						gw.jump();
						break;
					case 'n' :
						gw.reload();
						break;
					case 'k' :
						gw.killAsteroid();
						break;
					case 'e' :
						gw.killNPS();
						break;
					case 'E' :
						gw.killPS();
						break;
					case 'c' :
						gw.crashAsteroid();
						break; 
					case 'h' :
						gw.crashNPS();
						break;
					case 'x' :
						gw.asteroidCollision();
						break; 
					case 'I' :
						gw.npsAsteroidCollision();
						break;
					case 't' :
						gw.tick();
						break;
					case 'p' : 
						gw.print();
						break;
					case 'm' :
						gw.map();
						break;
					case 'q' :
						System.exit(0);
						break;
					// more code to handle other commands
				}
			}
		});
	}
}
