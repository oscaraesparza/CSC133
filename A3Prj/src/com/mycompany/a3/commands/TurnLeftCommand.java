/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * TurnLeftCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TurnLeftCommand extends Command{
	private GameWorld gw;
	public TurnLeftCommand(GameWorld gw) {
		super("Turn Left");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.turnLeft();
		System.out.println("Turn Left Clicked.");
	}
}