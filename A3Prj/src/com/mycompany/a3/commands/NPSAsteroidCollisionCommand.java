/* 
 * Oscar Esparza
 * Created : 14 October 2018
 * Updated : 14 October 2018
 * NPSAsteroidCollision.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class NPSAsteroidCollisionCommand extends Command{
	private GameWorld gw;
	public NPSAsteroidCollisionCommand(GameWorld gw) {
		super("NPS & Asteroid Collision");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.npsAsteroidCollision();
		System.out.println("NPS & Asteroid Collision Clicked");
	}
}