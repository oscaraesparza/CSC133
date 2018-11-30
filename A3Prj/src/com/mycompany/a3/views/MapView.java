/* 
 * Oscar Esparza
 * Created : 4 October 2018
 * Updated : 14 Novemeber 2018
 * MapView.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3.views;

import java.util.Observable;
import java.util.Observer;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;
import com.mycompany.a3.GameCollection;
import com.mycompany.a3.GameWorld;
import com.mycompany.a3.interfaces.IDrawable;
import com.mycompany.a3.interfaces.IGameWorld;
import com.mycompany.a3.interfaces.IIterator;
import com.mycompany.a3.interfaces.IMovable;
import com.mycompany.a3.objects.Asteroid;
import com.mycompany.a3.objects.GameObject;
import com.mycompany.a3.objects.Missile;

public class MapView extends Container implements Observer{
	private GameWorld gwProxy;
	GameCollection objects;
	
	// crates the map container
	public MapView(GameWorld gamePainter) {
		this.getAllStyles().setBgTransparency(255);
		this.getAllStyles().setBgColor(ColorUtil.WHITE);
		this.getAllStyles().setBorder(Border.createLineBorder(3, ColorUtil.MAGENTA));
		gwProxy = gamePainter;
	}
	
	// what to do when you get an update
	public void update(Observable o, Object arg) {
		if(o instanceof IGameWorld) {
			gwProxy = (GameWorld) o;
			repaint();
		}
		gwProxy.setDim(this.getWidth(), this.getHeight());
	}
	
	// Draws all the objects
	public void paint(Graphics g) {
		super.paint(g);
		objects = gwProxy.getCollection();
		IIterator itr = objects.getIterator();
		GameObject currentObject;
		
		while(itr.hasNext()) {
			currentObject = itr.getNext();
			Point pCmpRelPrnt = new Point(this.getX(), this.getY());
			
			// handles objects moving off screen 
			if(currentObject instanceof IMovable) {		
				int x = (int) ((GameObject)currentObject).getXCoordinate();
				int y = (int) ((GameObject)currentObject).getYCoordinate();
				int rightWall = this.getWidth();
				int leftWall = this.getWidth() - this.getX();
				int bottomWall = this.getY() + this.getHeight();
				int topWall = this.getY();
				
				if(x <= leftWall || x >= rightWall) {
					if(x <= 0) ((GameObject)currentObject).setLocation(this.getWidth(), y);
					if(x >= rightWall) ((GameObject)currentObject).setLocation(0, y); 
				}
				
				if(y <= topWall || y >= bottomWall) {
					if (y <= 0) ((GameObject)currentObject).setLocation(x, bottomWall);
					if((y + this.getY()) >= bottomWall) ((GameObject)currentObject).setLocation(x, 0);
					
				}
			}
			
			// draws Objects
			if(currentObject instanceof IDrawable)
				((IDrawable)currentObject).draw(g, pCmpRelPrnt);
		}
	}
	
	public void pointerPressed(int x, int y) {
		x = x - getParent().getAbsoluteX();
		y = y - getParent().getAbsoluteY();
		Point pPtrRelPrnt = new Point(x, y);
		Point pCmpRelPrnt = new Point(getX(), getY());
		
		if (!gwProxy.getPlay()) {
			System.out.println("Paused");
			objects = gwProxy.getCollection();
			IIterator itr = objects.getIterator();
			
			while(itr.hasNext()) {
				GameObject o = (GameObject)itr.getNext();
				
				if(o instanceof Asteroid) {	
					if(((Asteroid)o).contains(pPtrRelPrnt, pCmpRelPrnt)) ((Asteroid)o).setSelected(true);
					//else ((Asteroid)o).setSelected(false);
				}
				
				if(o instanceof Missile) {	
					if(((Missile)o).contains(pPtrRelPrnt, pCmpRelPrnt)) ((Missile)o).setSelected(true);
					//else ((Missile)o).setSelected(false);
				}
				repaint();
			}
		}
		else System.out.println("Game is already pause");
	}
}