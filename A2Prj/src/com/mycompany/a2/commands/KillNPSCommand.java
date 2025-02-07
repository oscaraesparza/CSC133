/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * KillNPSConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class KillNPSCommand extends Command{
	private GameWorld gw;
	public KillNPSCommand(GameWorld gw) {
		super("Destoy NPS w/Missile");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.killNPS();
		System.out.println("Destoy NPS w/Missile Clicked");
	}
}
