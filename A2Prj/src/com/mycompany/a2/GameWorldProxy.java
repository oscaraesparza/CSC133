/* 
 * Oscar Esparza
 * Created : 7 October 2018
 * Updated : 7 October 2018
 * GameWorldProxy.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2;

import java.util.Observable;

public class GameWorldProxy extends Observable implements IGameWorld {
	private GameWorld gw;
	public GameWorldProxy(GameWorld gw) {this.gw = gw;}
	public int getPlayerScore() {return gw.getPlayerScore();}
	public String getSound() {return gw.getSound();}
	public int getTime() {return gw.getTime();}
	public int getMissileCount() {return gw.getMissileCount();}
	public int getLives() {return gw.getLives();}

}