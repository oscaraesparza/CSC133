/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * TurnMissileLauncherLeftCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMissileLauncherLeftCommand extends Command{
	private GameWorld gw;
	public TurnMissileLauncherLeftCommand(GameWorld gw) {
		super("Turn Missile Launcher Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.turnMissleLauncherL();
		System.out.println("turning left");
	}
}