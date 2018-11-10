/* 
 * Oscar Esparza
 * Created : 8 October 2018
 * Updated : 8 October 2018
 * AddPSCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddPSCommand extends Command{
	private GameWorld gw;
	public AddPSCommand(GameWorld gw) {
		super("Add Player Ship");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.addPlayerShip();
		System.out.println("Add PS Clicked.");
	}

}