/* 
 * Oscar Esparza
 * Created : 11 November 2018
 * Updated : 11 November 2018
 * ICollider.java 
 * Homework 3 CSC 133 
 */
package com.mycompany.a3.interfaces;

public interface ICollider {
	public Boolean collidesWith(ICollider otherObject);
	public void handleCollision(ICollider otherObject);
}
