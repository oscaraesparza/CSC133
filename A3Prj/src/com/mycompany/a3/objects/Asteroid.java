/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 14 November 2018
 * Asteroid.java 
 * Homework 3 CSC 133 
 */
package com.mycompany.a3.objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.interfaces.ICollider;
import com.mycompany.a3.interfaces.IDrawable;
import com.mycompany.a3.interfaces.ISelectable;

public class Asteroid extends Movable implements IDrawable, ICollider, ISelectable{
	Boolean selected = false;
	Boolean cFlag;
	public String toString() {
		return ("Asteroid: Loc = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", direction = " + getDirection() + 
				", size = " + getSize());
	}

	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Turn (x, y) from float to int
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoordinate());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoordinate());
		g.setColor(getColor());
		if(isSelected()) g.drawArc(x, y, getSize(), getSize(), 0, 360);	
		else g.fillArc(x, y, getSize(), getSize(), 0, 360);
	}

	public Boolean collidesWith(ICollider otherObject) {
		Boolean result = false; 
		// get center coordinates for both objects
		int thisCenterX = (int)(this.getXCoordinate() + (this.getSize()/2));
		int thisCenterY = (int)(this.getYCoordinate() + (this.getSize()/2));
		int otherCenterX = (int)(((GameObject)otherObject).getXCoordinate() + ((GameObject)otherObject).getSize()/2);
		int otherCenterY = (int)(((GameObject)otherObject).getYCoordinate() + ((GameObject)otherObject).getSize()/2);
		// calculate distances
		int dx = thisCenterX - otherCenterX;
		int dy = thisCenterY - otherCenterY;
		int distance = (dx * dx) + (dy * dy);
		int thisRadius = this.getSize()/2;
		int otherRadius =((GameObject)otherObject).getSize()/2;
		int radii = (thisRadius * thisRadius) + (2 * thisRadius) + (otherRadius * otherRadius);
		// did they collide
		if (distance <= radii)	result = true;
		
		return result;
	}

	// checks if asteriod collided w/any of these objects
	public void handleCollision(ICollider otherObject) {	
		if(otherObject instanceof Asteroid)
			this.setCollision(true);
		if(otherObject instanceof NonePlayerShip)
			this.setCollision(true);
		if(otherObject instanceof Missile)
			this.setCollision(true);
		if(otherObject instanceof PlayerShip)
			this.setCollision(true);
	}

	public Boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt) {
		int iShapeX=(int)this.getXCoordinate(); 
	    int iShapeY=(int)this.getXCoordinate(); 
	    int px = pPtrRelPrnt.getX(); 
		int py = pPtrRelPrnt.getY(); 
		int xLoc = (pCmpRelPrnt.getX())+iShapeX ;
		int yLoc = (pCmpRelPrnt.getY())+iShapeY ;
		
		if((xLoc<=px&&px<=xLoc+getSize())&&(yLoc<=py&&py<=yLoc+getSize())) setContainFlag(false);
		else setContainFlag(true);
		
		return getContainFlag();
	}

	private Boolean getContainFlag() { return cFlag;}
	private void setContainFlag(Boolean f) {this.cFlag = f;}
	public void setSelected(Boolean select) {selected = select;}
	public Boolean isSelected() {return selected;}
}