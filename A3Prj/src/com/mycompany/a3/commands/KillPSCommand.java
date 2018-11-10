/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * KillPSConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillPSCommand extends Command{
	private GameWorld gw;
	public KillPSCommand(GameWorld gw) {
		super("Destoy PS w/Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.killPS();
		System.out.println("Destoy PS w/Missile Clicked");
	}
}
