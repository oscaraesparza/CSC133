/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 18 September 2018
 * NonePlayerShip.java 
 * Homework 1 CSC 133 
 */

package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;

public class NonePlayerShip extends Ships{
	private MissleLauncher ms = getLauncher();
	public String toString() {
		return ("None Player Ship: Location = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) +
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", direction = " + getDirection() + 
				", size = " + getSize());
	}
}