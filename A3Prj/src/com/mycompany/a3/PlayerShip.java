/* 
 * Oscar Esparza
 * Created : 19 September 2018
 * Updated : 19 September 2018
 * PlayerShip.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3;

import com.codename1.charts.util.ColorUtil;

public class PlayerShip extends Ships implements ISteerable{
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
}
