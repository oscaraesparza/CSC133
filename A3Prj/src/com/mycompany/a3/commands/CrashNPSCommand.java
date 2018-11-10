/* 
 * Oscar Esparza
 * Created : 13 October 2018
 * Updated : 13 October 2018
 * CrashNPSConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class CrashNPSCommand extends Command{
	private GameWorld gw;
	public CrashNPSCommand(GameWorld gw) {
		super("Crash Into NPS");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.crashNPS();
		System.out.println("Crash Into NPS Clicked");
	}
}