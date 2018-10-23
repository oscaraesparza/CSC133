/* 
 * Oscar Esparza
 * Created : 7 October 2018
 * Updated : 7 October 2018
 * AddAsteroidCommand.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddAsteroidCommand extends Command{
	private GameWorld gw;
	
	public AddAsteroidCommand(GameWorld gw) {
		super("Add Asteroid");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.addAsteroid();
		System.out.println("Add Asteroid Clicked.");
	}
}
