/* 
 * Oscar Esparza
 * Created : 6 October 2018
 * Updated : 6 October 2018
 * ICollection.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3.interfaces;

import com.mycompany.a3.objects.GameObject;

public interface ICollection {
	public void add(GameObject o);
	public void remove(GameObject o);
	public IIterator getIterator();
}
