/* 
 * Oscar Esparza
 * Created : 13 November 2018
 * Updated : 13 November 2018
 * BackgroudSound.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3;

import java.io.IOException;
import java.io.InputStream;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Display;

public class BackgroundSound implements Runnable{
	private Media media;

	public BackgroundSound (String fileName) {
		try {
			InputStream stream = Display.getInstance().getResourceAsStream(getClass(), "/" + fileName);
			media = MediaManager.createMedia(stream, "audio/wav", this);
		}
		catch(IOException e) {
			System.out.println("Cannot Play Backgroud Music");
		}
	}
	
	public void pause() {media.pause();}
	
	public void play() {media.play();}
	
	public void run() {
		media.setTime(0);
		media.play();
	}
	
}
