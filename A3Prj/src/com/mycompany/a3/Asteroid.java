/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 10 November 2018
 * Asteroid.java 
 * Homework 3 CSC 133 
 */
package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.mycompany.a3.interfaces.IDrawable;

public class Asteroid extends Movable implements IDrawable{
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
		g.drawArc(x, y, getSize(), getSize(), 0, 360);	
	}
}