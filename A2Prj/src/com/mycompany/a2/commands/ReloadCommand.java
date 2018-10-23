/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * ReloadConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class ReloadCommand extends Command{
	private GameWorld gw;
	public ReloadCommand(GameWorld gw) {
		super("Reload");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.reload();
		System.out.println("Reload Clicked");
	}
}