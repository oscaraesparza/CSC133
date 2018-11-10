/* 
 * Oscar Esparza
 * Created : 7 October 2018
 * Updated : 7 October 2018
 * AddSSCommand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class AddSSCommand extends Command{
	private GameWorld gw;
	public AddSSCommand(GameWorld gw) {
		super("Add Space Station");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.addSpaceStation();
		System.out.println("Add SS Clicked.");
	}

}
