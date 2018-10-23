/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 7 October 2018
 * GameObject.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.geom.Point2D;

public abstract class GameObject {
	private int color;
	private Point2D location;
	private int size;
	
	public GameObject() {};
	//-----------------------------------Setters----------------------------------------------------
	public void setColor(int red, int green, int blue) {this.color = ColorUtil.rgb(red, green, blue);}
	public void setLocation(double d, double e) {this.location = new Point2D(d, e);}	
	public void setSize(int size) {this.size = size;}
	public void setColor(int color) {this.color = color;}
	//----------------------------------getters------------------------------------------------------
	public int getColor() {return color;}
	public double getXCoordinate(){return location.getX();}
	public double getYCoordinate() {return location.getY();}
	public int getSize() {return size;}
}