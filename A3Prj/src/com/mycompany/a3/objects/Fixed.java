/* 
 * Oscar Esparza
 * Created : 19 September 2018
 * Updated : 19 September 2018
 * Fixed.java 
 * Homework 2 CSC 133 
 */
package com.mycompany.a3.objects;

public class Fixed extends GameObject{
	private static int id = 0;
	//----------setter-----------
	public void setID() {id++;};
	//----------getter------------
	public int getID() {return id;}
}
