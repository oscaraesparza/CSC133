/* 
 * Oscar Esparza
 * Created : 3 October 2018
 * Updated : 10 October 2018
 * IGameWorld.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3.interfaces;

import com.mycompany.a3.GameCollection;

public interface IGameWorld {
	//specifications here for all GameWorld methods
	public int getPlayerScore();
	public int getTime();
	public int getMissileCount();
	public String getSound();
	public int getLives();
	public int getWidth();
	public int getHeight();
	public GameCollection getCollection();
}
