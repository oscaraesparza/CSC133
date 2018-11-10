/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * KillAsteroidConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class KillAsteroidCommand extends Command{
	private GameWorld gw;
	public KillAsteroidCommand(GameWorld gw) {
		super("Destoy Asteroid w/Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.killAsteroid();
		System.out.println("Destoy Asteroid w/Missile Clicked");
	}
}