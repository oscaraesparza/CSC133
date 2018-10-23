/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 22 September 2018
 * Ships.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a2;

public class Ships extends Movable {
	private int missleCount; 
	private MissleLauncher missileLauncher;
	public Ships() {missileLauncher = new MissleLauncher();}
	
	public MissleLauncher getLauncher(){return missileLauncher;}
	public void setMissleLaucher(MissleLauncher ml) {this.missileLauncher = ml;}
	
	public void setMissleCount(int missles) {this.missleCount = missles;}
	public int getMissleCount() {return this.missleCount;};	
	public void useMissile(int amount) {this.missleCount = this.missleCount - amount;}
}

