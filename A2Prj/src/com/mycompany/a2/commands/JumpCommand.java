/* 
 * Oscar Esparza
 * Created : 10 October 2018
 * Updated : 10 October 2018
 * JumpConmmand.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2.commands;

import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
import com.mycompany.a2.GameWorld;

public class JumpCommand extends Command{
	private GameWorld gw;
	public JumpCommand(GameWorld gw) {
		super("Jump");
		this.gw = gw;
	}
	
	public void actionPerformed(ActionEvent e) {
		gw.jump();
		System.out.println("Jump Clicked");
	}
}