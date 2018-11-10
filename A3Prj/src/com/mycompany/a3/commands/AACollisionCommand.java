/* 
 * Oscar Esparza
 * Created : 13 October 2018
 * Updated : 9 November 2018
 * AACollision.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class AACollisionCommand extends Command{
	private GameWorld gw;
	public AACollisionCommand(GameWorld gw) {
		super("Asteroid Collision");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.asteroidCollision();
		System.out.println("Asteroid Collision Clicked");
	}
}