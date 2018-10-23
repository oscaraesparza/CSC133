/* 
 * Oscar Esparza
 * Created : 21 September 2018
 * Updated : 22 September 2018
 * Missle.java 
 * Homework 1 CSC 133 
 */
package com.mycompany.a1;

import com.codename1.charts.util.ColorUtil;

public class Missile extends Movable{
	private int fuel;
	
	public void setFuel(int fuel) {this.fuel = fuel;}
	
	public int getFuelLevel() {return fuel;}
	
	public Boolean useFuel() { 
		fuel--;
		if(fuel <= 0) return true;
		else return false;
		}
	
	public String toString() {
		return ("Missile: Loc = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", dir = " + getDirection() + 
				", fuel level = " + getFuelLevel());
	}
}
