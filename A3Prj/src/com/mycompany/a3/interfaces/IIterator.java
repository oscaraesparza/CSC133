package com.mycompany.a3.interfaces;

import com.mycompany.a3.objects.GameObject;

public interface IIterator {
	public boolean hasNext();
	public GameObject getNext();
	public GameObject get();
	//public GameObject getPrevious();
}
