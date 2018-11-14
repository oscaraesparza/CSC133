/* 
 * Oscar Esparza
 * Created : 21 September 2018
 * Updated : 10 October 2018
 * Missle.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.interfaces.ICollider;
import com.mycompany.a3.interfaces.IDrawable;

public class Missile extends Movable implements IDrawable, ICollider{
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
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Turn (x, y) from float to int
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoordinate());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoordinate());
		g.setColor(getColor());
		g.drawRect(x, y, getSize(), getSize() / 2);
	}
	
	public Boolean collidesWith(ICollider otherObject) {
		Boolean result = false; 
		int thisCenterX = (int)(this.getXCoordinate() + (this.getSize()/2));
		int thisCenterY = (int)(this.getYCoordinate() + (this.getSize()/2));
		int otherCenterX = (int)(((GameObject)otherObject).getXCoordinate() + ((GameObject)otherObject).getSize()/2);
		int otherCenterY = (int)(((GameObject)otherObject).getYCoordinate() + ((GameObject)otherObject).getSize()/2);
		
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distance = (dx * dx) + (dy * dy);
		
		int thisRadius = this.getSize()/2;
		int otherRadius =((GameObject)otherObject).getSize()/2;
		
		int radii = (thisRadius * thisRadius) + (2 * thisRadius) + (otherRadius * otherRadius);
		
		if (distance <= radii)	result = true;
		
		return result;
	}

	public void handleCollision(ICollider otherObject) {	
		if(otherObject instanceof Asteroid)
			this.setCollision(true);
		if(otherObject instanceof NonePlayerShip)
			this.setCollision(true);
		if(otherObject instanceof Missile)
			this.setCollision(true);
		//if(otherObject instanceof PlayerShip)
			//this.setCollision(true);
	}
}
