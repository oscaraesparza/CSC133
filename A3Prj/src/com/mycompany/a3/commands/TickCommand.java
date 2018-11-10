/* 
 * Oscar Esparza
 * Created : 14 October 2018
 * Updated : 14 October 2018
 * TickCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class TickCommand extends Command{
	private GameWorld gw;
	public TickCommand(GameWorld gw) {
		super("TICK");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.tick();
		System.out.println("Tick Clicked");
	}
}