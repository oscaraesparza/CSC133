/* 
 * Oscar Esparza
 * Created : 20 September 2018
 * Updated : 20 September 2018
 * PSMissleLauncher.java 
 * Homework 1 CSC 133 
 */

package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class PSMissleLauncher extends Movable implements ISteerable{
	public String toString() {
		return ("PS MissleLauncher: Location = " + getXCoordinate() + ", " + getYCoordinate() + 
				", direction = " + getDirection() + 
				", speed = " + getSpeed() +
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", size = " + getSize());
	}

	@Override
	public void moveObject() {
		// TODO Auto-generated method stub
		
	}

}
