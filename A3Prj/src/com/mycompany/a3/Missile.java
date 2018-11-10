/* 
 * Oscar Esparza
 * Created : 21 September 2018
 * Updated : 10 October 2018
 * Missle.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;

public class Missile extends Movable{
	private int fuel;
	private Boolean ps = false;
	
	public void setFuel(int fuel) {this.fuel = fuel;}
	
	public int getFuelLevel() {return fuel;}
	
	public Boolean useFuel() { 
		fuel--;
		if(fuel <= 0) return true;
		else return false;
		}
	public void setFlag(Boolean p) {this.ps = p;}	//to figure out if it is a ps missile
	
	public Boolean returnFlag(){return this.ps;}	//true if from ps
	
	public String toString() {
		return ("Missile: Loc = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", dir = " + getDirection() + 
				", fuel level = " + getFuelLevel());
	}
}
