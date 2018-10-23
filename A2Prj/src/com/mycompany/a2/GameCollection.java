/* 
 * Oscar Esparza
 * Created : 6 October 2018
 * Updated : 6 October 2018
 * GameCollection.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a2;

import java.util.Vector;

public class GameCollection implements ICollection{
	private Vector<GameObject> gameObjects;
	
	// create new vector for game objects
	public GameCollection() { gameObjects = new Vector<GameObject>();}	// create new vector for game objects
	public void add(GameObject o) { gameObjects.addElement(o);}			// add to the vector
	public void remove(GameObject o) { gameObjects.removeElement(o);}	// remove element
	public IIterator getIterator() { return new SpaceVectorIterator();}

	private class SpaceVectorIterator implements IIterator{
		private int currentElementIndex;
		
		public SpaceVectorIterator() { currentElementIndex = -1;}
		
		public boolean hasNext() {
			if(gameObjects.size() <= 0) return false;
			if (currentElementIndex == gameObjects.size() - 1) return false;
			return true;
		}
		
		public GameObject getNext() {
			currentElementIndex++;
			return (gameObjects.elementAt(currentElementIndex));
		}
		
		public GameObject get() { return (GameObject) (gameObjects.elementAt(currentElementIndex));}
	}
}
