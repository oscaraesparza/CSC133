/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * FireMissileConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class FireMissileCommand extends Command{
	private GameWorld gw;
	public FireMissileCommand(GameWorld gw) {
		super("FireMissile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.fireMissile();
		System.out.println("FireMissile Clicked");
	}
}
