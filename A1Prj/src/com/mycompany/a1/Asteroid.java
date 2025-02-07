/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 18 September 2018
 * Asteroid.java 
 * Homework 1 CSC 133 
 */package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Asteroid extends Movable{
	public String toString() {
		return ("Asteroid: Loc = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", direction = " + getDirection() + 
				", size = " + getSize());
	}
}
