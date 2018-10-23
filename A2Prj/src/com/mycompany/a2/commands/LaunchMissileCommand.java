/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * LaunchMissileConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class LaunchMissileCommand extends Command{
	private GameWorld gw;
	public LaunchMissileCommand(GameWorld gw) {
		super("LaunchMissile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.launchMissile();
		System.out.println("Launch Missile Clicked");
	}
}