/* 
 * Oscar Esparza
 * Created : 18 September 2018
 * Updated : 9 October 2018
 * Movable.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a2;

public class Movable extends GameObject implements IMovable {
	private int speed;
	private int direction;
	/**********************Setters***************************/	
	public void setSpeed(int speed) {this.speed = speed;}
	public void setDirection(int direction) {this.direction = direction;}	
	
	/**********************Getters***************************/	
	public int getSpeed() {return speed;}
	public int getDirection() {return direction;}
	
	/*********************Modifiers**************************/
	public void increaseSpeed() {
		//System.out.println("The current speed is :" + speed);
		speed++;
		System.out.println("New speed it :" + speed);		
	}
	
	public void decreaseSpeed() {
		if(speed <= 0) {	// can't go in reverse
			System.out.println("Your speed is at 0, you can't go lower!");
			return;
		}
		//System.out.println("The current speed is :" + speed);
		speed--;
		System.out.println("New speed it :" + speed);		
	}
	
	public void turnLeft() {
		if((direction + 10) > 359) {
			direction = (direction + 10) % 359; // if direction 360 then direction = 1
			return;
		}
		System.out.println("The current direction is :" + direction);
		direction = direction + 10;
		System.out.println("New direction is :" + direction);
	}
	
	public void turnRight() {
		if((direction - 10) < 0) {
			direction = 360 - (direction % 10); // if direction -10 then direction = 350
			return;
		}
		System.out.println("The current direction is :" + direction);
		direction = direction - 10;
		System.out.println("New direction is :" + direction);
	}
	
	@Override
	public void move() {
		double theta = 90 - this.direction;
		theta = Math.toRadians(theta); 	// converting to radians
		double deltaX = Math.cos(theta) * this.speed;	//change in x
		double deltaY = Math.sin(theta) * this.speed; 	//change in y
		this.setLocation((this.getXCoordinate() + deltaX), (this.getYCoordinate() + deltaY));
	}
}
