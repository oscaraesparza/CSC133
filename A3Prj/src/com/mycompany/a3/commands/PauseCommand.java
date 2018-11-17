/* 
 * Oscar Esparza
 * Created : 16 November 2018
 * Updated : 16 November 2018
 * PauseCommand.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a3.GameWorld;

public class PauseCommand extends Command{
	GameWorld gw;
	
	public PauseCommand(GameWorld gw) {
		super("Pause");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Pause is pressed");
		gw.play();
		
		if(gw.getPlay()) gw.playTOpause();
		else gw.pauseTOplay();
	}
}
