/* 
 * Oscar Esparza
 * Created : 9 October 2018
 * Updated : 9 October 2018
 * DecelerateCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class DecelerateCommand extends Command{
	private GameWorld gw;
	public DecelerateCommand(GameWorld gw) {
		super("Decelerate");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.decreaseSpeed();
		System.out.println("Decelerate Clicked.");
	}

}