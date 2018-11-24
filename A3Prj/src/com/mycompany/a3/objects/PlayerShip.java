/* 
 * Oscar Esparza
 * Created : 19 September 2018
 * Updated : 19 September 2018
 * PlayerShip.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.objects;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.interfaces.ICollider;
import com.mycompany.a3.interfaces.IDrawable;
import com.mycompany.a3.interfaces.ISteerable;

public class PlayerShip extends Ships implements ISteerable, IDrawable, ICollider{
	private MissleLauncher ms = getLauncher();
	public String toString() {
		return ("PlayerShip: Loc = " + Math.round(getXCoordinate()) + ", " + Math.round(getYCoordinate()) + 
				", color = [" + ColorUtil.red(getColor()) + ", " + ColorUtil.green(getColor()) + ", " + ColorUtil.blue(getColor()) + "]" +
				", speed = " + getSpeed() +
				", dir = " + getDirection() + 
				", missiles = " + getMissleCount() + 
				", Missile Launcher dir = " + ms.getDirection());
	}

	@Override
	public void moveObject() {
		// TODO Auto-generated method stub	
	}
	
	public void draw(Graphics g, Point pCmpRelPrnt) {
		// Turn (x, y) from float to int
		int x = (int)(pCmpRelPrnt.getX() + this.getXCoordinate());
		int y = (int)(pCmpRelPrnt.getY() + this.getYCoordinate());
		Point top = new Point(x , y + 40);
		Point bLeft = new Point(x - 40, y - 40); 
		Point bRight = new Point(x + 40, y - 40);
		
		g.setColor(getColor());
		int [] xPoints = new int [] {(int) top.getX(), (int) bLeft.getX(), (int)bRight.getX()} ; 
	    int [] yPoints = new int [] {(int) top.getY(), (int) bLeft.getY(), (int)bRight.getY()} ; 
		g.drawPolygon(xPoints, yPoints, 3);
	}

	@Override
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

	@Override
	public void handleCollision(ICollider otherObject) {
		if(otherObject instanceof Asteroid)
			this.setCollision(true);
		if(otherObject instanceof NonePlayerShip)
			this.setCollision(true);
		//if(otherObject instanceof Missile)
			//this.setCollision(true);
		if(otherObject instanceof PlayerShip)
			this.setCollision(true);
	}
}
