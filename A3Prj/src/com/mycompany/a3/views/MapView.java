/* 
 * Oscar Esparza
 * Created : 4 October 2018
 * Updated : 4 October 2018
 * MapView.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3.views;

import java.util.Observable;
import java.util.Observer;
import com.codename1.ui.Container;
import com.mycompany.a3.interfaces.IGameWorld;

public class MapView extends Container implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// casting o as a GameWorld
		IGameWorld gw = (IGameWorld) arg;
		setWidth(getAbsoluteX());
		setHeight(gw.getHeight());
		this.repaint();
	}
}
