/* 
 * Oscar Esparza
 * Created : 10 September 2018
 * Updated : 11 November 2018
 * SpaceStation.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3.objects; 

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.interfaces.ICollider;
import com.mycompany.a3.interfaces.IDrawable;

public class SpaceStation extends Fixed implements IDrawable, ICollider{
	private int blinkRate;
	
	public void setBlinkRate(int rate) {this.blinkRate = rate;}
	
	public int getBlinkRate() {return blinkRate;}
	
	public String toString() {
		return ("SpaceStation: Location = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" + 
				", blinkrate = [" + getBlinkRate() + "]");
				//", id = " + getID());
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Turn (x, y) from float to int
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoordinate());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoordinate());
		g.setColor(getColor());
		g.drawRect(x, y, getSize(), getSize());
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
		System.out.println("You shouldn't see this");
	}
}
