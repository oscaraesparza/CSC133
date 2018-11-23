/* 
 * Oscar Esparza
 * Created : 22 November 2018
 * Updated : 22 November 2018
 * RefuelCommand.java 
 * Homework 3CSC 133 
 */

package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class RefuelCommand extends Command {
	private GameWorld gw;
	public RefuelCommand(GameWorld gw) {
		super("Refuel");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.refuel();
		System.out.println("Refuel Clicked");
	}
}
