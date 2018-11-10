/* 
 * Oscar Esparza
 * Created : 14 October 2018
 * Updated : 14 October 2018
 * ClosingApp.java 
 * Homework 2 CSC 133 
 */

package com.mycompany.a3;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;

public class ClosingApp extends Form{
	public ClosingApp() {
		Boolean bOk = Dialog.show("Confirm quit", "Are you sure you want to quit?", "Ok", "Cancel");
		if(bOk) {
			Display.getInstance().exitApplication();
		}
	}
}
