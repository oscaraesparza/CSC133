/* 
 * Oscar Esparza
 * Created : 10 September 2018
 * Updated : 19 September 2018
 * SpaceStation.java 
 * Homework 1 CSC 133 
 */

package com.mycompany.a1; 

import com.codename1.charts.util.ColorUtil;

public class SpaceStation extends Fixed{
	private int blinkRate;
	
	public void setBlinkRate(int rate) {this.blinkRate = rate;}
	
	public int getBlinkRate() {return blinkRate;}
	
	public String toString() {
		return ("SpaceStation: Location = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" + 
				", blinkrate = [" + getBlinkRate() + "]");
				//", id = " + getID());
	}
}
