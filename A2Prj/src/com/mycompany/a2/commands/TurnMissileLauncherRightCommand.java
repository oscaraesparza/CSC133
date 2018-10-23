/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * TurnMissileLauncherRightCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnMissileLauncherRightCommand extends Command{
	private GameWorld gw;
	public TurnMissileLauncherRightCommand(GameWorld gw) {
		super("Turn Missile Launcher Right");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.turnMissleLauncherR();
		System.out.println("turning Right");
	}
}