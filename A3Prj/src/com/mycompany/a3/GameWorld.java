/* 
 * Oscar Esparza
 * Created : 17 September 2018
 * Updated : 13 Novemebr 2018
 * GameWorld.java 
 * Homework 3 CSC 133 
 */

package com.mycompany.a3;

import java.util.Observable;
import java.util.Random;
import com.mycompany.a3.interfaces.ICollider;
import com.mycompany.a3.interfaces.IGameWorld;
import com.mycompany.a3.interfaces.IIterator;
import com.mycompany.a3.interfaces.IMovable;
import com.mycompany.a3.objects.Asteroid;
import com.mycompany.a3.objects.GameObject;
import com.mycompany.a3.objects.Missile;
import com.mycompany.a3.objects.MissleLauncher;
import com.mycompany.a3.objects.NonePlayerShip;
import com.mycompany.a3.objects.PlayerShip;
import com.mycompany.a3.objects.Ships;
import com.mycompany.a3.objects.SpaceStation;

public class GameWorld extends Observable implements IGameWorld{
	Random rand = new Random();
	/********************Objects******************************/
	private GameCollection go;
	private Asteroid asteroid;
	private NonePlayerShip nps;
	private MissleLauncher launcher;
	private MissleLauncher psLauncher;
	private SpaceStation station;
	private PlayerShip ps;
	private Missile missile;
	/*****************PointView Stuff*************************/
	private int lives = 3;
	private int score = 0;
	private int time = 0;
	private boolean soundOn;
	/*****************Other Variables************************/
	public int WIDTH = 0;
	public int HEIGHT = 0;
	private static final int MAXMISSILES = 10;
	Boolean play = true; 
	// Sound
	BackgroundSound backgroundSound = new BackgroundSound("backgroud.wav");
	SoundEffect shots = new SoundEffect("Missile.mp3");

	// create a collection
	public GameWorld() { go = new GameCollection();}
	
	public void addAsteroid() {
		asteroid = new Asteroid();
		asteroid.setSize((rand.nextInt(24) + 6) * 7); 	// 6 - 30
		asteroid.setSpeed(rand.nextInt(10));		// 0 - 10
		asteroid.setDirection(rand.nextInt(359));	// 0 - 359
		asteroid.setColor(255, 0, 0);				// red
		asteroid.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		go.add(asteroid);
		//System.out.println("Asteroid has been created");
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void addNonePlayerShip() {
		int direction = rand.nextInt(359);			// 0 - 359
		nps = new NonePlayerShip();
		nps.setSize(((rand.nextInt(1) + 1) * 10) * 7); 	// 10 or 20
		nps.setMissleCount(MAXMISSILES);			// 10
		nps.setSpeed(rand.nextInt(10));				// 0 - 10
		nps.setDirection(direction);				// 0 - 359
		nps.setColor(201, 154, 0);					//  Dark yellow
		nps.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		
		launcher = nps.getLauncher();
		launcher.setSpeed(rand.nextInt(10));	// 0 - 10
		launcher.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		launcher.setDirection(direction);		// 0 - 359
		launcher.setColor(255, 255, 100);		// lighter yellow
		nps.setMissleLaucher(launcher);
		go.add(nps);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void addSpaceStation() {
		station = new SpaceStation();
		station.setLocation(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
		station.setColor(0, 255, 0);			// green
		station.setID();
		station.setSize(50);
		station.setBlinkRate(rand.nextInt(4));	// 0 - 4
		go.add(station);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));		
	}
	
	public void addPlayerShip() {
		IIterator theElements = go.getIterator();
		// checks to see if there is a ship already
		while(theElements.hasNext()) {
			if(theElements.getNext() instanceof PlayerShip) {
				System.out.println("You already have a ship");
				return;
			}
		}
		
		ps = new PlayerShip();
		ps.setMissleCount(MAXMISSILES);
		ps.setSpeed(0);
		ps.setDirection(0);							// points north
		ps.setColor(0, 0, 0);						// black
		ps.setLocation((WIDTH / 2), (HEIGHT / 2));	// center of map
		ps.setSize(50);

		psLauncher = ps.getLauncher();
		psLauncher.setSpeed(0);	// 0 - 10
		psLauncher.setLocation((WIDTH / 2), (HEIGHT / 2));
		psLauncher.setDirection(rand.nextInt(359));	// 0 - 359
		psLauncher.setColor(50, 50, 50);		// grey
		psLauncher.setSize(5);
		ps.setMissleLaucher(psLauncher);
		go.add(psLauncher);
		go.add(ps);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void increaseSpeed() {
		if(ps == null) {
			System.out.println("No PS exists so we can increment the speed!");
			return;
		}
		
		IIterator theElements = go.getIterator();
		MissleLauncher psLauncher = ps.getLauncher();
		// checks to see if there is a ship already
		while(theElements.hasNext()){
			if(ps.getSpeed() >= 10)	{
				System.out.println("You are already at max speed");
				return;
			}
			if(theElements.getNext() instanceof PlayerShip) {
				ps.increaseSpeed();
				psLauncher.increaseSpeed(); // since ps and its launcher must have matching speed
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}		
		}
	}
	
	public void decreaseSpeed() {
		if(ps == null) {
			System.out.println("No PS exists so we can't decrement the speed!");
			return;
		}
		
		IIterator theElements = go.getIterator();
		MissleLauncher psLauncher = ps.getLauncher();
		// checks to see if there is a ship already
		while(theElements.hasNext()){
			if(theElements.getNext() instanceof PlayerShip) {
				ps.decreaseSpeed();
				psLauncher.decreaseSpeed(); // since ps and its launcher must have matching speed
				this.setChanged();
				this.notifyObservers(new GameWorldProxy(this));
				return;
			}		
		}
	}
	
	public void turnLeft() {
		if(ps != null) { ps.turnLeft();}
		else {System.out.println("There is no ship");}
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void turnRight() {
		if(ps != null) { 
			ps.turnRight();
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else {System.out.println("There is no ship");}
	}
	
	public void turnMissleLauncherL() {
		if(psLauncher != null) { 
			psLauncher.turnLeft();
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else {System.out.println("There is no ship or Missile Launcher");}
	}
	
	public void turnMissleLauncherR() {
		if(psLauncher != null) { 
			psLauncher.turnRight();
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else {System.out.println("There is no ship or Missile Launcher");}
	}
	
	public void fireMissile() {
		if((ps != null) && (ps.getMissleCount() > 0)) { 
			shots.play();
			missile = new Missile();
			launcher = ps.getLauncher();
			missile.setDirection(launcher.getDirection()); // since a ps launcher could have diff direction than ps
			missile.setSpeed(10);
			// prevent own missile from hitting the ship
			missile.setLocation(launcher.getXCoordinate() + 3, launcher.getYCoordinate() + 3); 
			missile.setColor(50,50,50); // same as launcher (gray)
			missile.setFuel(10);
			missile.setFlag(true); 		// missile is from ps
			missile.setSize(10);
			go.add(missile);
			ps.useMissile(1);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else if(ps == null) {System.out.println("There is no ship");}
		else System.out.println("You have no more missiles!");
	}
	
	public void launchMissile() {
		if((nps != null) && (nps.getMissleCount() > 0)) { 
			missile = new Missile();
			launcher = nps.getLauncher();
			missile.setDirection(launcher.getDirection());
			missile.setSpeed(nps.getSpeed() + 1);
			missile.setLocation(nps.getXCoordinate(), nps.getYCoordinate()); //missile location is same as ps missile launcher
			missile.setColor(50,50,50); // same as launcher (gray)
			missile.setFuel(10000);	// fix this
			go.add(missile);
			nps.useMissile(1);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
		}
		else if(nps == null) {System.out.println("There is no ship");}
		else System.out.println("You have no more missiles!");
	}
	// fix
	public void jump() {
		if(ps != null) ps.setLocation((WIDTH / 2), (HEIGHT / 2));
		else System.out.println("There is no ship");
		}
	
	public void reload() {
		if (ps != null) {
			if (ps.getMissleCount() == 10) System.out.println("You are already at max capacity");
			else ps.setMissleCount(MAXMISSILES);
		}
		else System.out.println("There is no ship");
	}
	
	public void killAsteroid() {
		IIterator theElements = go.getIterator();
		GameObject tempA = null;
		GameObject tempM = null;
		while(theElements.hasNext()) {					
			if(theElements.getNext() instanceof Asteroid) {	tempA = (GameObject)theElements.get();}
			if(theElements.hasNext())		
				if(theElements.getNext() instanceof Missile) { tempM = (GameObject)theElements.get();}
		}
		
		if((tempA != null) && (tempM != null)) {
			go.remove(tempA);
			go.remove(tempM);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			score++;
		}
		
		else if(tempA == null) System.out.println("You have no asteroid in space.");
		else if(tempM == null) System.out.println("You have no missile to shoot.");	
	}
	
	public void killNPS() {
		IIterator theElements = go.getIterator();
		GameObject tempN = null;
		GameObject tempM = null;
		while(theElements.hasNext()) {					//iterate to find NPS
			if(theElements.getNext() instanceof NonePlayerShip) {tempN = (GameObject)theElements.get();}
			if(theElements.hasNext())		//needs a check again since it already checked for NPS getNext
				if(theElements.getNext() instanceof Missile) {tempM = (GameObject)theElements.get();}
		}
		
		if((tempN != null) && (tempM != null)) {
			go.remove(tempN);
			go.remove(tempM);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			score = score + 2;
		}
		
		else if(tempN == null) System.out.println("You have no NPS in space.");
		else if(tempM == null) System.out.println("You have no missile to shoot.");
	}
	
	public void killPS() {
		IIterator theElements = go.getIterator();
		GameObject tempM = null;
		GameObject tempP = null;
		while(theElements.hasNext()) {
			// look for Missile
			if(theElements.hasNext())
				if(theElements.getNext() instanceof Missile) {tempM = (GameObject)theElements.get();}
			// look for PS
			if(theElements.hasNext())
				if(theElements.getNext() instanceof PlayerShip) {tempP = (GameObject)theElements.get();}
		}
		
		if((tempP != null) && (tempM != null)) {
			go.remove(tempP);
			go.remove(tempM);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			lives--;
			System.out.println("NPS has hit you, you have lost a life");
		}
		else System.out.println("You have no PS or Missile in space.");
	}
	
	public void crashAsteroid() {
		IIterator theElements = go.getIterator();
		GameObject tempA = null;
		GameObject tempP = null;
		while(theElements.hasNext()) {	
			// look for Asteroid
			theElements.getNext();
			if(theElements.get() instanceof Asteroid) {	
				tempA = (GameObject)theElements.get();
				}
			if(theElements.get() instanceof PlayerShip) {
				tempP = (GameObject)theElements.get();
				}
			
		}
		if((tempP != null) && (tempA != null)) {
			go.remove(tempP);
			go.remove(tempA);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			lives--;
			System.out.println("You have crashed into an asteroid, you have lost a life");
		}
		else System.out.println("You have no PS or Asteroid in space.");
	}
	
	public void crashNPS() {
		IIterator theElements = go.getIterator();
		GameObject tempN = null;
		GameObject tempP = null;
		while(theElements.hasNext()) {	
			theElements.getNext();
			if(theElements.get() instanceof NonePlayerShip) {tempN = (GameObject)theElements.get();}
			if(theElements.get() instanceof PlayerShip) {tempP = (GameObject)theElements.get();}		
		}
		if((tempP != null) && (tempN != null)) {
			go.remove(tempP);
			go.remove(tempN);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			lives--;
			System.out.println("You have crashed into an NPS, you have lost a life");
		}
		else System.out.println("You have no PS or NPS in space.");
	}
	
	// May need some debugging 
	// if you only have 1 of each it might not work for some reason...
	public void npsAsteroidCollision() {
		IIterator theElements = go.getIterator();
		GameObject tempN = null;
		GameObject tempA = null;
		while(theElements.hasNext()) {	
			theElements.getNext();
			if(theElements.get() instanceof NonePlayerShip) {tempN = (GameObject)theElements.get();}		
			if(theElements.get() instanceof Asteroid) { tempA = (GameObject)theElements.get();}	
		}
		if((tempA != null) && (tempN != null)) {
			go.remove(tempA);
			go.remove(tempN);
			this.setChanged();
			this.notifyObservers(new GameWorldProxy(this));
			System.out.println("NPS & Asteroid have collided");
		}
		else System.out.println("You have no Asteroid or NPS in space.");
	}
	
	public void tick() { //game clock has ticked
		time++;
		IIterator theElements = go.getIterator();
		
		while(theElements.hasNext()) {					
			if(theElements.getNext() instanceof IMovable) {	
				IMovable mObj = (IMovable)theElements.get();
				mObj.move();
				// missle launcher needs to follow player ship
				if (mObj instanceof MissleLauncher) {
					((MissleLauncher) mObj).setLocation(ps.getXCoordinate(), ps.getYCoordinate());
				}
			}
		}
		// need to restart iterator
		// will fail if you fire 2 missiles at the same time ... sometimes
		theElements = go.getIterator();
		while(theElements.hasNext()) {					
			if(theElements.getNext() instanceof Missile) {	
				Missile mObj = (Missile)theElements.get();
				if(getTime() % 10 == 0) {
					if(mObj.useFuel()) {	//if out of fuel
						System.out.println("Missile has run out of fuel");
						go.remove(mObj); 	// removes the missile
					}
				}
			}
		}
		
		// blink for spacestation
		theElements = go.getIterator();
		while(theElements.hasNext()) {					
			if(theElements.getNext() instanceof SpaceStation) {	
				SpaceStation mObj = (SpaceStation)theElements.get();
				if(mObj.getBlinkRate() != 0) 		//if blink rate = 0, there could be an issue
					if((time % mObj.getBlinkRate()) == 0) System.out.print("BLINK\n");
			}
		}
		
		//collision detection
		theElements = go.getIterator();
		while(theElements.hasNext()) {
			// get object
			ICollider currentObject = (ICollider)theElements.getNext();
			// grab the secound list of objects
			IIterator theElements2 = go.getIterator();
			
			while(theElements2.hasNext()) {
				ICollider otherObject = (ICollider)theElements2.getNext();
				// make sure the objects are not the same 
				if(currentObject != otherObject) {
					if(currentObject.collidesWith(otherObject)) {
						currentObject.handleCollision(otherObject);
					}
				}
			}
		}
		
		// now lets get rid of crash objects
		theElements = go.getIterator();	
		MissleLauncher ms;
		while(theElements.hasNext()) {
			GameObject obj = theElements.getNext();
			// for some reason this is the only way to not crash the game when PS hits an object
			if(obj instanceof PlayerShip) {
				if(obj.getCollision() == true) {
					ms = ((PlayerShip) obj).getLauncher();
					go.remove(obj);
					go.remove(ms);
					lives--;
					this.setChanged();
					this.notifyObservers(new GameWorldProxy(this));
					return;
				}
			}
			if(obj instanceof Asteroid) {
				if(obj.getCollision() == true) {
					if(((Asteroid) obj).hitByMissile()) score++;
					go.remove(obj);
				}
			}
			else if(obj.getCollision() == true)
				go.remove(obj);
		}
		
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	// display objects in the collections
	public void map() {
		IIterator theElements = go.getIterator();
		while(theElements.hasNext()) {
			GameObject o = (GameObject) theElements.getNext();
			System.out.println(o);
		}
	}
	
	public int getPlayerScore() {return this.score;}
	
	public String getSound() {
		String sound;
		if(soundOn == true) {
			sound = "ON";
			return sound;
		}
		else {	
			sound = "OFF";
			return sound;
		}
	}
	
	public void toggleSound() {
		soundOn = !soundOn;		//toggles sound
		if(soundOn) backgroundSound.run();
		else backgroundSound.pause();
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public int getTime() {return time;}

	public int getMissileCount() {
		IIterator theElements = go.getIterator();
		Ships tempA;
		// get the missile count
		while(theElements.hasNext()) {					
			if(theElements.getNext() instanceof PlayerShip) {	
				tempA = (Ships)theElements.get();
				return tempA.getMissleCount();
			}
		}
		return 0;
	}

	public int getLives() {return lives;}
	public void setDim(int w, int h) {
		this.HEIGHT = h;
		this.WIDTH = w;
	}
	public GameCollection getCollection(){
		return go;
	}

	public void setHeight(int height2) {
		HEIGHT = height2;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public Boolean getPlay() {return play;}
	public void setPlay(Boolean play) {this.play = play;}
	
	public void play() {
		if(!getPlay())	setPlay(true);
		else 	setPlay(false);
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void playTOpause() {
		Game.pause().setText("Pause");
		if(getSound() == "ON")	toggleSound();	
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void pauseTOplay() {
		Game.pause().setText("Play");
		if(getSound() == "OFF")	toggleSound();	
		this.setChanged();
		this.notifyObservers(new GameWorldProxy(this));
	}
	
	public void refuel() {
		if(getPlay())	System.out.println("Game must be paused to use this!");
		else {
			IIterator theElements = go.getIterator();
			Missile m;
			// checks to see if there is a missile
			while(theElements.hasNext()){
				if(theElements.getNext() instanceof Missile) {
					m = (Missile)theElements.get();
					if(m.isSelected()) {	// checks to see if selected
						m.setFuel(10);
						System.out.println("Missile Has been refueled.");
					}
				}		
			}
		}
	}
	
	public void incrementScore() {this.score++;}
}
