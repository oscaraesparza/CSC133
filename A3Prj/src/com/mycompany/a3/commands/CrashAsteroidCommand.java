/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * KillPSConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class CrashAsteroidCommand extends Command{
	private GameWorld gw;
	public CrashAsteroidCommand(GameWorld gw) {
		super("Crash Into Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.crashAsteroid();
		System.out.println("Crash Into Clicked");
	}
}