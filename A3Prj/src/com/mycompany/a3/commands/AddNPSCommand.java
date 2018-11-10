/* 
 * Oscar Esparza
 * Created : 7 October 2018
 * Updated : 7 October 2018
 * AddNPSCommand.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddNPSCommand extends Command {
	private GameWorld gw;
	public AddNPSCommand(GameWorld gw) {
		super("Add NPS");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.addNonePlayerShip();
		System.out.println("Add NPS Clicked.");
	}
}
