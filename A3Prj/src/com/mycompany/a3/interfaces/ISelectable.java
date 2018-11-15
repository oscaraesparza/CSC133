/* 
 * Oscar Esparza
 * Created : 14 November 2018
 * Updated : 14 November 2018
 * ISelectable.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3.interfaces;

import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;

public interface ISelectable {
	public Boolean contains(Point pPtrRelPrnt, Point pCmpRelPrnt);
	public void draw(Graphics g, Point pCmpRelPrnt);
	public void setSelected(Boolean select);
	public Boolean isSelected();
}
