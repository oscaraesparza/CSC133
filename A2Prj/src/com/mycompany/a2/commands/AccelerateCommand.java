/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * Accelerate Command.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AccelerateCommand extends Command{
	private GameWorld gw;
	public AccelerateCommand(GameWorld gw) {
		super("Accelerate");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.increaseSpeed();
		System.out.println("Accelerate Clicked.");
	}

}
